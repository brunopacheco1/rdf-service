package io.github.brunopacheco1.rdfservice.dto;

public record FacetQuery(
        String name,
        FacetQueryType type,
        String query) {
}
