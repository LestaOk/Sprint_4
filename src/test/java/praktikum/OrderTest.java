package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.DriverRule;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.OrderFirstPage;
import ru.yandex.praktikum.pages.OrderModalPage;
import ru.yandex.praktikum.pages.OrderSecondPage;

@RunWith(Parameterized.class)
public class OrderTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private boolean isTopButton;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private String period;
    private String color;
    private String comment;

    public OrderTest(boolean isTopButton, String firstName, String lastName, String address, String metroStation, String phoneNumber,
                     String date, String period, String color, String comment) {
        this.isTopButton = isTopButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Test
    public void correctOrderFlow() {
        WebDriver driver = driverRule.getDriver();

        OrderFirstPage orderFirstPage = new MainPage(driver)
                .openBaseLink()
                .clickOrderButton(isTopButton);

        OrderSecondPage orderSecondPage = orderFirstPage
                .fillInFirstName(firstName)
                .fillInLastName(lastName)
                .fillInAddress(address)
                .selectMetroStation(metroStation)
                .fillInPhoneNumber(phoneNumber)
                .clickNextButton();

        OrderModalPage orderModalPage = orderSecondPage.waitTillSecondPageIsLoaded()
                .fillInDate(date)
                .fillInRentalPeriod(period)
                .selectColor(color)
                .addComment(comment)
                .clickNextButton();

        orderModalPage.clickToYesButton()
                .checkSuccessfulOrderHeader();
    }

    @Parameterized.Parameters
    public static Object[][] getSectionata() {
        return new Object[][] {
                {true, "Джон", "Доу", "Адрес1", "ЗИЛ", "+11234567890", "01.04.2024", "сутки", "black", "комментарий к заказу"},
                {false, "Джейн", "Доу", "Адрес2", "Черкизовская", "+00987654321", "04.04.2024", "двое суток", "grey", ""},
        };
    }
}
