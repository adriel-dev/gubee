package com.example.apispringcontract;

import com.example.apispringcontract.api.GetAgeController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

public class GetAgeTestBase {

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new GetAgeController());
    }

}