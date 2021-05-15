import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServerManager {

    private static String NODE_HOME;

    public static String getNodeHome () {
        if (NODE_HOME == null) {
            NODE_HOME = System.getenv("NODE_HOME");
            if (NODE_HOME == null) throw new RuntimeException("NODE_HOME environment variable is not set");
        }
        return NODE_HOME;
    }

    private static String nodeJS = getNodeHome() +"/bin/node";
    private static String appiumJS = getNodeHome() +"/lib/node_modules/appium/build/lib/main.js";

    public static AppiumDriverLocalService createService () {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS));
        return AppiumDriverLocalService.buildService(serviceBuilder);
    }

    public static void main(String ...args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
