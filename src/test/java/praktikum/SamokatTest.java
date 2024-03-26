package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.DriverRule;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.StatusPage;

public class SamokatTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final String INVALID_ORDER_NUMBER = "123";

    @Test
    public void invalidOrderNumber() {
        WebDriver driver = driverRule.getDriver();

        MainPage mainPage = new MainPage(driver)
                .openBaseLink()
                .clickStatusButton()
                .enterOrder(INVALID_ORDER_NUMBER);

        StatusPage statusPage = mainPage.clickGoButton();
        statusPage.checkNotFound();
    }

}
