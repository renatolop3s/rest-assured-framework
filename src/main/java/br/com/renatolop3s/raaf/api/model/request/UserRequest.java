package br.com.renatolop3s.raaf.api.model.request;

import br.com.renatolop3s.raaf.api.model.Json;
import lombok.Builder;
import lombok.Data;

@Builder
public @Data class UserRequest implements Json {
    private String firstName;
    private String lastName;
    private String email;
}
