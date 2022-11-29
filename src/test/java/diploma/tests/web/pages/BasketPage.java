package diploma.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BasketPage implements BasePage {
    private final String BASKET_URN = "/basket";
    private final String EMPTY_BASKET_INFO_TEXT = "В вашей корзине еще нет товаров";
    private final String EMPTY_BASKET_CONTINUE_TEXT = "Продолжить покупки";

    public final BasketPage openPage() {
        step("Open basket page", () -> {
            open(BASKET_URN);
        });
        return this;
    }

    public void isFlowerExistsInBasket(String flowerName) {
        step(String.format("Check that item %s exists in basket", flowerName), () -> {
            $(".products-list").shouldHave(Condition.text(flowerName));
        });
    }

    public void checkEmptyBasket() {
        step("Check that empty basket contains info text", () -> {
            zvetElements.getEmptyBasketContent().shouldHave(Condition.text(EMPTY_BASKET_INFO_TEXT));
        });

        step("Check that empty basket contains continue link", () -> {
            zvetElements.getEmptyBasketContent().$x("a").shouldHave(Condition.text(EMPTY_BASKET_CONTINUE_TEXT));
        });
    }


}
