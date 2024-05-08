package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;

@Controller()
@Secured(SecurityRule.IS_AUTHENTICATED)
public class HomeController {
    @Get
    public String home(Authentication authentication) {
        return "hello world";
    }
}
