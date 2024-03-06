package br.com.renatolop3s.raaf.core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import static br.com.renatolop3s.raaf.config.Configuration.cfg;
import static io.restassured.http.ContentType.JSON;

public class BaseApi {

    protected BaseApi() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(cfg().baseUrl())
                .addHeader("app-id", cfg().appId())
                .setContentType(JSON)
                .log(LogDetail.URI)
                .addFilter(new AllureRestAssured())
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .build();
    }

    protected RequestSpecification request() {
        return RestAssured.given();
    }
}
