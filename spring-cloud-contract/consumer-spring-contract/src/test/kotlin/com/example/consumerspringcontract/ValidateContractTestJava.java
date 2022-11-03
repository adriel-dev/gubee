package com.example.consumerspringcontract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.demo:api-spring-contract:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ValidateContractTestJava {

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    void validateShouldGetAgeContract() {
        var response = restTemplate.getForEntity("http://localhost:8080/api/age/year/2000", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType()).isEqualTo("application/json");
        assertThat(response.getBody()).isEqualTo("{\"age\":22}");
    }

}