package diploma.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage implements BasePage {
    public MainPage openPage() {
        step("Open main page", () -> {
            open(baseUrl);
        });
        return this;
    }

    public MainPage addToCart(String flowerName) {
        step(String.format("Add %s to cart", flowerName), () -> {
            zvetElements.findFlowerCardByName(flowerName).$("button[class*='btn-cart']").click();
        });
        step("Redirect to basket page");
        $(".cart").shouldBe(visible);
        return this;
    }

    public void calculateFlowerPrice(String flower, String color, int price, int pack) {
        step(String.format("Open calculator flower choice"), () -> {
            zvetElements.getChooseFlowerCalcElement().click();
            step(String.format("Choose flower %s for calculation", flower));
            $$("div.flower").find(text(flower)).find(".flower_image").click();
        });
        step(String.format("Open calculator flower color choice"), () -> {
            zvetElements.getChooseColourCalcElement().shouldNotBe(disabled).click();
            step(String.format("Choose flower color %s for calculation", color));
            $$("div.flower").find(text(flower + " " + color)).find(".flower_image").click();
        });
        step(String.format("Check calculation total sum"), () -> {
            $("div.itog span").shouldHave(text(price * pack + ""));
        });
    }

    static Stream<Arguments> calculatorTest() {
        return Stream.of(
                Arguments.of("Гербера", "Малиновая", 149, 30),
                Arguments.of("Калла", "Белая", 199, 10),
                Arguments.of("Хризантема", "Карамельная", 299, 10)
        );
    }
}
