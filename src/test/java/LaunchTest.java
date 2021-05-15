import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class LaunchTest extends BaseTest{

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws IOException, URISyntaxException {
        String appStr = getAppFile("TheApp.apk").getAbsolutePath();;

        URL remoteUrl = getServiceUrl();

        DriverManager driverManager = new DriverManager(remoteUrl, appStr);

        driver = (AndroidDriver) driverManager.getDriver();

//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Echo Box")));
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Echo Box");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("messageInput");
        el2.sendKeys("rdgkj rtgjkdf fgdkj,f");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"messageSaveBtn\"]/android.widget.TextView");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton");
        el4.click();
        Assert.assertTrue(false);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

