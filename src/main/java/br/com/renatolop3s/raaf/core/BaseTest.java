package br.com.renatolop3s.raaf.core;

import br.com.renatolop3s.raaf.api.DummyApi;
import br.com.renatolop3s.raaf.api.model.request.UserRequest;
import br.com.renatolop3s.raaf.api.data.UserFactory;
import br.com.renatolop3s.raaf.listener.AllureEnvironmentListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({
        AllureEnvironmentListener.class
})
public class BaseTest {

    protected static DummyApi api;
    protected static UserRequest user;

    @BeforeSuite(alwaysRun = true, description = "Set up")
    public void setUp() {
        api = new DummyApi();
        user = UserFactory.createUser();
    }
}
