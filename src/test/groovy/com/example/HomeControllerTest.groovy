package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class HomeControllerTest extends Specification {
    @Inject
    @Client("/")
    HttpClient client;
    def "Test home controller"() {
        expect:
        String homeControllerResp = client.toBlocking().retrieve(HttpRequest.GET(new URI("/")))
        assert homeControllerResp == "hello world"
    }
}
