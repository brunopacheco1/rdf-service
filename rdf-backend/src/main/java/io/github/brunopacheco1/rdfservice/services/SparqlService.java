package io.github.brunopacheco1.rdfservice.services;

import org.apache.jena.query.ResultSet;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SparqlService {

    private final String sparqlEngineUrl;

    public SparqlService(@Value("${sparql-engine.url}") String sparqlEngineUrl) {
        this.sparqlEngineUrl = sparqlEngineUrl;
    }

    public ResultSet query(String query) {
        try (var connection = connection()) {
            var execution = connection.query(query);
            return execution.execSelect();
        }
    }

    private RDFConnection connection() {
        var builder = RDFConnectionFuseki.create().destination(sparqlEngineUrl);
        return builder.build();
    }
}
