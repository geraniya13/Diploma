package diploma.tests.web.dictionary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Flowers {

    VSPLESK("Букет \"Сочный Всплеск\" в ящике"),
    MADAGASKAR("Букет \"Мадагаскар\" в коробке");

    @Getter
    private final String productName;
}
