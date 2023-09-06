package io.github.brunopacheco1.rdfservice.rest;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {

    @GetMapping("/api/v1/users/logged-user/name")
    public String name(JwtAuthenticationToken principal) {
        return principal.getToken().getClaimAsString("name");
    }
}
