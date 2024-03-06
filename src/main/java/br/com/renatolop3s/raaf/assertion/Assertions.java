package br.com.renatolop3s.raaf.assertion;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Assertions extends org.assertj.core.api.Assertions {

    private Assertions() {

    }

    public static ResponseAssert assertThat(Response response) {
        log.info("Validating response:\n{}", response.asPrettyString());
        return new ResponseAssert(response);
    }
}
