import com.codeborne.selenide.Configuration;
import pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class FieldsFormsTest{
    private MainPage formPage;

    @BeforeClass
    void init(){
        Configuration.baseUrl = "https://practice-automation.com/form-fields/";
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;

        open(Configuration.baseUrl);
        formPage = page(MainPage.class);
    }

    @Test(description = "Проверка ввода имени", priority = 1)
    void testSetFirstNameField() {
        formPage.setName("Elena");
    }

    @Test(description = "Проверка ввода пароля", priority = 2)
    void testSetIdField() {
        formPage.setPassword("5648494");
    }

    @Test(description = "Выбор чекбокса Milk", priority = 3)
    void selectCheckBoxDrink2() {
        formPage.clickCheckBox2();
    }

    @Test(description = "Выбор чекбокса Coffee", priority = 4)
    void selectCheckBoxDrink3() {
        formPage.clickCheckBox3();
    }

    @Test(description = "Выбор чекбокса Yellow", priority = 5)
    void clickRadio3() {
        formPage.clickRadio3();
    }

    @Test(description = "Выбор варианта из выпадающего списка", priority = 6)
    void selectAutomationOption() {
        formPage.selectRandomAutomationOption();
    }

    @Test(description = "Проверка ввода почты", priority = 7)
    void testSetEmailField() {
        formPage.setEmailField("rodgem@mail.ru");
    }

    @Test(description = "Проверка Message", priority = 8)
    void testSetMessage() {
        formPage.setCountMessage();
    }

    @Test(description = "Нажатие кнопки submit и проверка полей", priority = 9)
    void testClickSubmitButton() {
        formPage.clickSubmitButton();
        sleep(10000);
    }
}