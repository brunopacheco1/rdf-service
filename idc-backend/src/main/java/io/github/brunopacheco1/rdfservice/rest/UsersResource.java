package io.github.brunopacheco1.rdfservice.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersResource {

    @GetMapping("/api/v1/user-name")
    public String name(Principal principal) {
        return principal.getName();
    }
}
