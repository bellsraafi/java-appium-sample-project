import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class DriverManager {

    private URL remoteUrl;
    private String app;

    public DriverManager(URL remoteUrl, String app) {
        this.remoteUrl = remoteUrl;
        this.app = app;
    }

    public AppiumDriver getDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("app", app);
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        return new AndroidDriver(remoteUrl, desiredCapabilities);
    }
}
