package com.example.consumerspringcontract

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate

@SpringBootTest
@AutoConfigureStubRunner(ids = ["com.example:api-spring-contract:+:stubs:8080"], stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ValidateContractTest {

    private lateinit var restTemplate: RestTemplate

    @BeforeEach
    internal fun setUp() {
        this.restTemplate = RestTemplate()
    }

    @Test
    internal fun validateShouldGetAgeContract() {
        val response = restTemplate.getForEntity("http://localhost:8080/api/age/year/2000", String::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.headers.contentType).isEqualTo(MediaType.APPLICATION_JSON)
        assertThat(response.body).isEqualTo("{\"age\":22}")
    }

    @Test
    internal fun validateShouldFailToGetAgeContract() {
        try {
            restTemplate.getForEntity("http://localhost:8080/api/age/year/1726", String::class.java)
        } catch (e: HttpClientErrorException) {
            assertThat(e.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
            assertThat(e.responseBodyAsString).isNullOrEmpty()

        }
    }

}