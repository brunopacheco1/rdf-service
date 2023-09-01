package io.github.brunopacheco1.rdfservice;

import org.apache.jena.fuseki.main.FusekiServer;
import org.apache.jena.query.DatasetFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RdfServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdfServiceApplication.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    FusekiServer fusekiServer() {
        var dataset = DatasetFactory.createTxnMem();
        var server = FusekiServer.create()
                .add("/ds", dataset)
                .port(3000)
                .build();
        return server;
    }
}
