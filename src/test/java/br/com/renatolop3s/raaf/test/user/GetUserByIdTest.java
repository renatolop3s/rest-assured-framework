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
public class GetUserByIdTest extends BaseTest {

    private UserResponse user;

    @BeforeMethod(alwaysRun = true)
    public void createUser() {
        UserRequest payload = UserFactory.createUser();
        this.user = api.createUser(payload).as(UserResponse.class);
    }

    @Test(description = "Get User by ID", groups = {"bvt", "smoke"})
    @Description("Get user full data by user id")
    public void test() {
        Response response = api.getUserById(user.getId());
        assertThat(response).hasStatusCode(200);
    }
}
