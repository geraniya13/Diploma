package diploma.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ZvetConfigProvider {
    public static ZvetConfig zvetConfig = ConfigFactory.create(ZvetConfig.class, System.getProperties());

    public ZvetConfigProvider setWebConfiguration() {
        Configuration.browser = zvetConfig.browserName();
        Configuration.browserVersion = zvetConfig.browserVersion();
        Configuration.browserSize = zvetConfig.browserSize();
        Configuration.browserPosition = zvetConfig.browserPosition();
        if (isRemote()) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("enableVNC", true);
            dc.setCapability("enableVideo", true);
            Configuration.browserCapabilities = dc;
            Configuration.remote = zvetConfig.remoteUrl();
        }
        return this;
    }

    public boolean isRemote() {
        return !zvetConfig.remoteUrl().equals("");
    }
}
