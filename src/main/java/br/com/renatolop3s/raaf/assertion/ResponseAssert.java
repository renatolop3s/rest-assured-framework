package br.com.renatolop3s.raaf.assertion;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    protected ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
    }

    @Step("Validate status code equal to {0}")
    public ResponseAssert hasStatusCode(int status) {
        if (actual.statusCode() != status) {
            failWithMessage("Expected status code to be <%s> but was <%s>",
                    status, actual.statusCode());
        }
        return this;
    }
}
