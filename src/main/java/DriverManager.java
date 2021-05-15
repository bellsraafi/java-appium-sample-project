import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class DriverManager {

    private URL remoteUrl;
    private File app;

    public DriverManager(URL remoteUrl, File app) {
        this.remoteUrl = remoteUrl;
        this.app = app;
    }

    public AppiumDriver getDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.2.1/TheApp-v1.2.1.apk");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }
}
