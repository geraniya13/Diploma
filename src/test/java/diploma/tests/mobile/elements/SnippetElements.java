package diploma.tests.mobile.elements;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SnippetElements {
    public static String firstSnippetTitleText = "CoinKeeper",
            firstSnippetTextValue = "CoinKeeper is the most simple and fast way to take care of your finances.",
            snippetSkipBtnText = "SKIP",
            snippetDiscountBtnText = "APPLY DISCOUNT",
            secondSnippetTitleText = "Limited time offer",
            secondSnippetTextValue = "One year of advanced features at a 50% discount. Unlimited number of categories and tags, export, synchronization and enhanced statistics.";


    public static SelenideElement
            snippetImage = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/snippet_image")),
            snippetTitle = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/snippet_title")),
            snippetText = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/snippet_text")),
            snippetSkipBtn = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/snippet_skip_btn")),
            snippetPremiumBtn = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/premium_buttons_one_year")),
            authorizeUserBtn = $(AppiumBy.xpath("//android.widget.Button[@text=\"I'M COINKEEPER USER\"]"));

}
