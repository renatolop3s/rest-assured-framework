package br.com.renatolop3s.raaf.test.user;

import br.com.renatolop3s.raaf.api.model.request.UserRequest;
import br.com.renatolop3s.raaf.core.BaseTest;
import br.com.renatolop3s.raaf.api.data.UserFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static br.com.renatolop3s.raaf.assertion.Assertions.assertThat;

@Story("User")
@Owner("renato.lopes")
public class CreateUserTest extends BaseTest {

    @Test(description = "Create User", groups = {"bvt", "smoke"})
    @Description("Create new user, return created user data")
    public void test() {
        UserRequest payload = UserFactory.createUser();
        Response response = api.createUser(payload);
        assertThat(response).hasStatusCode(200);
    }
}
