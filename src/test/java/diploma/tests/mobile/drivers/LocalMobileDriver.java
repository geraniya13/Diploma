package diploma.tests.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import diploma.config.MobileConfig;
import diploma.tests.GlobalTestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriver extends GlobalTestBase implements WebDriverProvider {
    @Override
    public final WebDriver createDriver(final Capabilities capabilities) {

        File app = getApp();
        UiAutomator2Options options = new UiAutomator2Options();

        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(mobileConfig.getPlatformName());
        options.setDeviceName(mobileConfig.getDevice());
        options.setPlatformVersion(mobileConfig.getOsVersion());
        options.setApp(app.getAbsolutePath());
        options.setAppPackage(mobileConfig.getAppPackage());
        options.setAppActivity(mobileConfig.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appUrl = "";//"https://github.com/Papkatru/graduation_project/files/10047087/stepik-1-217.zip";
        String appPath = "src/test/resources/apps/coinkeeper.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }
}