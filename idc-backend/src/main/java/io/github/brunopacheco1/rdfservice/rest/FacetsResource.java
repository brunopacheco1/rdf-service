package io.github.brunopacheco1.rdfservice.rest;

import java.util.HashSet;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunopacheco1.rdfservice.config.FacetsConfig;
import io.github.brunopacheco1.rdfservice.dto.Facet;
import io.github.brunopacheco1.rdfservice.dto.FacetQuery;
import io.github.brunopacheco1.rdfservice.dto.FacetQueryType;
import io.github.brunopacheco1.rdfservice.dto.KeyValue;
import io.github.brunopacheco1.rdfservice.services.SparqlService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FacetsResource {

    private final SparqlService sparqlService;

    private final FacetsConfig facetsConfig;

    @GetMapping("/public/api/v1/facets")
    public List<Facet> getFacets() {
        return facetsConfig.getQueries().stream()
                .map(query -> queryFacet(query))
                .toList();
    }

    @GetMapping("/public/api/v1/facets/{facetName}")
    public Facet getFacet(@PathVariable("facetName") String facetName) {
        return facetsConfig.getQueries().stream()
                .filter(it -> it.name().equals(facetName))
                .map(query -> queryFacet(query))
                .findFirst()
                .orElse(null);
    }

    private Facet queryFacet(FacetQuery facetQuery) {
        var resultSet = sparqlService.query(facetQuery.query());
        var options = new HashSet<KeyValue>();

        while (resultSet.hasNext()) {
            var solution = resultSet.next();
            if (facetQuery.type() == FacetQueryType.LITERAL) {
                var value = getLiteralString(solution, facetQuery.name());
                options.add(new KeyValue(value, value));
            } else {
                var key = getNamespace(solution, "key");
                var value = getLiteralString(solution, "value");
                options.add(new KeyValue(key, value));
            }
        }

        return new Facet(facetQuery.name(), options);
    }

    private String getNamespace(QuerySolution solution, String arg) {
        var resource = solution.getResource(arg);
        return resource.getNameSpace();
    }

    private String getLiteralString(QuerySolution solution, String arg) {
        var literal = solution.getLiteral(arg);
        return literal.getString();
    }
}
