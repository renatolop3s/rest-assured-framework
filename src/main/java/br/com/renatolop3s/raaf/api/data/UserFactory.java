package br.com.renatolop3s.raaf.api.data;

import br.com.renatolop3s.raaf.api.model.request.UserRequest;
import com.github.javafaker.Faker;

public class UserFactory {

    private static final Faker faker = new Faker();

    private UserFactory() {

    }

    public static UserRequest createUser() {
        return UserRequest.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .build();
    }
}
