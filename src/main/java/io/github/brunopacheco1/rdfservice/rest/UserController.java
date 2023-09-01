package io.github.brunopacheco1.rdfservice.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class UserController {

    @GetMapping("/user-name")
    public String name(@AuthenticationPrincipal OidcUser principal) {
        return principal.getName();
    }
}
