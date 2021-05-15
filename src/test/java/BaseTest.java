import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class BaseTest {

    private static AppiumDriverLocalService service;

    @BeforeSuite
    public void globalSetup () throws IOException {
//        service = AppiumDriverLocalService.buildDefaultService();
        service = AppiumServerManager.createService();
        service.start();
    }

    @AfterSuite
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }

    protected File getAppFile(String app) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("apps/" + app);
        return Paths.get(resource.toURI()).toFile();
    }

}
