package io.github.brunopacheco1.rdfservice.dto;

import java.util.List;

public record Facet(
        String name,
        List<String> values) {
}
