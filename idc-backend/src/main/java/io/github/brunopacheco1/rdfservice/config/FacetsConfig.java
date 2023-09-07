package io.github.brunopacheco1.rdfservice.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.github.brunopacheco1.rdfservice.dto.FacetQuery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "facets")
public class FacetsConfig {

    private List<FacetQuery> queries;
}
