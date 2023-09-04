package io.github.brunopacheco1.rdfservice.rest;

import java.util.List;

import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunopacheco1.rdfservice.dto.Facet;

@RestController
public class FacetsResource {

    private String sparqlEngineUrl;

    public FacetsResource(
            @Value("${sparql-engine.url}") String sparqlEngineUrl) {
        this.sparqlEngineUrl = sparqlEngineUrl;
    }

    @GetMapping("/api/v1/facets")
    public List<Facet> getFacets() {

        var builder = RDFConnectionFuseki.create().destination(sparqlEngineUrl);

        var query = QueryFactory.create("select ?s where { ?s ?p ?o . }");

        try (var conn = builder.build()) {
            conn.queryResultSet(query, ResultSetFormatter::out);
        }

        return List.of();
    }
}
