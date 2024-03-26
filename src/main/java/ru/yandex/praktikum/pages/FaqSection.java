package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.Utils;

import static org.junit.Assert.assertEquals;

public class FaqSection {
    private final WebDriver driver;
    private final By section = By.className("accordion");
    private final By questionPanels = By.className("accordion__button");
    private final By answerPanels = By.className("accordion__panel");

    public FaqSection (WebDriver driver) {
        this.driver = driver;
    }

    private void clickToQuestion(int panelNumber) {
        Utils.waitElementToBeVisible(driver, section);
        driver.findElements(questionPanels).get(panelNumber).click();
    }

    public void checkQuestionText(int panelNumber, String question) {
        clickToQuestion(panelNumber);
        String actual = driver.findElements(questionPanels).get(panelNumber).getText();
        assertEquals(question, actual);
    }

    public void checkAnswerText(int panelNumber, String answer) {
        String actual = driver.findElements(answerPanels).get(panelNumber).getText();
        assertEquals(answer, actual);
    }
}
