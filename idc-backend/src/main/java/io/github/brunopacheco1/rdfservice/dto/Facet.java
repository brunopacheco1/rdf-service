package io.github.brunopacheco1.rdfservice.dto;

import java.util.Set;

public record Facet(
        String name,
        Set<String> values) {
}
