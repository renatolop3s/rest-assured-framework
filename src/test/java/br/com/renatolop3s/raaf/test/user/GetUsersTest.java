package br.com.renatolop3s.raaf.test.user;

import br.com.renatolop3s.raaf.api.model.request.UserRequest;
import br.com.renatolop3s.raaf.api.model.response.UserResponse;
import br.com.renatolop3s.raaf.core.BaseTest;
import br.com.renatolop3s.raaf.api.data.UserFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static br.com.renatolop3s.raaf.assertion.Assertions.assertThat;

@Story("User")
@Owner("renato.lopes")
public class GetUsersTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void createUser() {
        UserRequest payload = UserFactory.createUser();
        api.createUser(payload).as(UserResponse.class);
    }

    @Test(description = "Get List", groups = {"bvt", "smoke"})
    @Description("Get list of users sorted by registration date")
    public void test() {
        Response response = api.getUsers();
        assertThat(response).hasStatusCode(200);
    }
}
