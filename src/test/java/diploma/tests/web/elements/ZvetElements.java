package diploma.tests.web.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class ZvetElements {
    private SelenideElement emptyBasketContent = $(".empty-basket__content"),
            chooseFlowerCalcElement = $("div.minicalc-body a.choose"),
            chooseColourCalcElement = $("#calc_for_index div.minicalc-body div.param-color button");

    public SelenideElement findFlowerCardByName(String flowerName) {
        return $$(".slick-active").findBy(Condition.text(flowerName));
    }
}
