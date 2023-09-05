package io.github.brunopacheco1.rdfservice.rest;

import java.util.HashSet;
import java.util.List;

import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunopacheco1.rdfservice.dto.Facet;

@RestController
public class FacetsResource {

    private static final String LICENSE_QUERY = "PREFIX dct: <http://purl.org/dc/terms/>\n" +
            "select distinct ?license where { ?s dct:license ?license }";

    private static final String THEME_QUERY = "PREFIX dcat: <http://www.w3.org/ns/dcat#>\n" +
            "select distinct ?mediaType where { ?s dcat:mediaType ?mediaType }";

    private String sparqlEngineUrl;

    public FacetsResource(
            @Value("${sparql-engine.url}") String sparqlEngineUrl) {
        this.sparqlEngineUrl = sparqlEngineUrl;
    }

    @GetMapping("/api/v1/facets")
    public List<Facet> getFacets() {
        var builder = RDFConnectionFuseki.create().destination(sparqlEngineUrl);

        try (var connection = builder.build()) {
            return List.of(
                    getFacet(connection, "license", LICENSE_QUERY),
                    getFacet(connection, "mediaType", THEME_QUERY)//
            );
        }
    }

    private Facet getFacet(RDFConnection connection, String variable, String query) {
        var execution = connection.query(query);
        var resultSet = execution.execSelect();
        var values = new HashSet<String>();
        while (resultSet.hasNext()) {
            var solution = resultSet.next();
            var subject = solution.getResource(variable);
            values.add(subject.getNameSpace());
        }

        return new Facet(variable, values);
    }
}
