package diploma.config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ZvetConfigProvider {
    public static ZvetConfig zvetConfig = ConfigFactory.create(ZvetConfig.class, System.getProperties());

    public ZvetConfigProvider setWebConfiguration() {
        Configuration.browser = zvetConfig.getBrowserName();
        Configuration.browserVersion = zvetConfig.getBrowserVersion();
        Configuration.browserSize = zvetConfig.getBrowserSize();
        Configuration.browserPosition = zvetConfig.getBrowserPosition();
        if (isRemote()) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("enableVNC", true);
            dc.setCapability("enableVideo", true);
            Configuration.browserCapabilities = dc;
            Configuration.remote = zvetConfig.getRemoteUrl();
        }
        return this;
    }

    public boolean isRemote() {
        return !zvetConfig.getRemoteUrl().equals("");
    }
}
