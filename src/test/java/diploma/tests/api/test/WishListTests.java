package diploma.tests.api.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import diploma.tests.api.base.ApiTestBase;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Api")
@Tag("All")
@Epic("MegaZvet")
@Feature("Api tests")
@Owner("Geraniya")
public class WishListTests extends ApiTestBase {
    @Test
    @Tag("Api")
    @DisplayName("Items in wishlist adding check")
    public void addItemsInWishListTest() {
        step("Try to add random items in wishlist", () -> {
            wishListApi.tryToAddRandomItemAndCountSuccessfullyAdded();
            wishListApi.tryToAddRandomItemAndCountSuccessfullyAdded();
            wishListApi.tryToAddRandomItemAndCountSuccessfullyAdded();
        });
        step("Check if all available items were added", () -> assertEquals(wishListApi.getAddedItems(), wishListApi.countActualItems()));
        step("Clear wishlist and check it is empty", () -> {
            wishListApi.addItemsToDeletionList();
            wishListApi.deleteAllItems();
            assertEquals(0, wishListApi.countActualItems());
        });
    }
}