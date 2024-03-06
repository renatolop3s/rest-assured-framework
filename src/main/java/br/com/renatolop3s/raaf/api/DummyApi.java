package br.com.renatolop3s.raaf.api;

import br.com.renatolop3s.raaf.api.model.request.UserRequest;
import br.com.renatolop3s.raaf.core.BaseApi;
import io.qameta.allure.Step;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.Getter;

import static br.com.renatolop3s.raaf.api.endpoint.DummyEndpoints.CREATE_USER;
import static br.com.renatolop3s.raaf.api.endpoint.DummyEndpoints.LIST_USERS;
import static br.com.renatolop3s.raaf.api.endpoint.DummyEndpoints.USER;
import static br.com.renatolop3s.raaf.config.Configuration.cfg;

public class DummyApi extends BaseApi {

    @Step("GET to " + LIST_USERS)
    public Response getUsers() {
        return request().get(LIST_USERS);
    }

    @Step("GET to " + USER)
    public Response getUserById(String id) {
        return request().get(USER, id);
    }

    @Step("POST to " + CREATE_USER)
    public Response createUser(UserRequest payload) {
        return request().body(payload).post(CREATE_USER);
    }

    @Step("PUT to " + USER)
    public Response updateUser(String id, UserRequest payload) {
        return request().body(payload).put(USER, id);
    }

    @Step("DELETE to " + USER)
    public Response deleteUser(String id) {
        return request().delete(USER, id);
    }
}
