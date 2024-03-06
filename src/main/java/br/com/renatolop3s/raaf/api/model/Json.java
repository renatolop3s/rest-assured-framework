package br.com.renatolop3s.raaf.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public interface Json {
    default @SneakyThrows String asJson() {
       return new ObjectMapper()
               .setSerializationInclusion(JsonInclude.Include.NON_NULL)
               .writeValueAsString(this);
    }
}
