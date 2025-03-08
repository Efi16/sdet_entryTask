package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;

import java.util.Comparator;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    @FindBy(xpath = "//input[@id='name-input']")
    private SelenideElement nameField;

    @FindBy(xpath = "//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(xpath = "//input[@id='drink2']")
    private SelenideElement checkBoxDrink2;

    @FindBy(xpath = "//input[@id='drink3']")
    private SelenideElement checkBoxDrink3;

    @FindBy(xpath = "//input[@id='color3']")
    private SelenideElement radioColor3;

    @FindBy(xpath = "//select[@id='automation']")
    private SelenideElement automationSelect;

    @FindBy(xpath = "//input[@id='email']")
    private SelenideElement emailField;

    @FindBy(xpath = "//ul[not(@id) and not(@type)]")
    private SelenideElement countMessage;

    @FindBy(xpath = "//ul[not(@id) and not(@type)]//li")
    private SelenideElement sizeTools;

    @FindBy(xpath = "//textarea[@id='message']")
    private SelenideElement message;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private SelenideElement submitButton;

    public MainPage setName(String name){
        nameField.shouldBe(appear).setValue(name);
        return this;
    }

    public MainPage setPassword(String password){
        passwordField.shouldBe(appear).setValue(password);
        return this;
    }

    public MainPage clickCheckBox2(){
        checkBoxDrink2.shouldBe(Condition.visible).click();
        return this;
    }
    public MainPage clickCheckBox3(){
        checkBoxDrink3.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPage clickRadio3(){
        radioColor3.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPage selectRandomAutomationOption(){
        ElementsCollection options = automationSelect.$$("option");
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());
        options.get(randomIndex).click();
        return this;
    }

    public MainPage setEmailField(String email) {
        emailField
                .shouldBe(visible)
                .setValue(email)
                .shouldHave(value(email));
        return this;
    }

    public MainPage setCountMessage(){
        ElementsCollection listTools = countMessage.$$("li");
        int countTools = listTools.size();

        String longTools = listTools.stream().map(SelenideElement::getText).max(Comparator.comparingInt(String::length)).orElse("Не найден");

        String messageText = "Количество инструментов: " + countTools + " Название самого длинного инструмента: " + longTools;
        message
                .shouldHave(visible)
                .setValue(messageText)
                .shouldHave(value(messageText));
        return this;
    }

    public MainPage clickSubmitButton(){
        submitButton
                .shouldHave(visible)
                .click();
        return this;
    }
}