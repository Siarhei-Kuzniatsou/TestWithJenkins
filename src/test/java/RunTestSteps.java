
import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;


public class RunTestSteps {

    public static final String PASSWORD = "g1020958G";
    public static final String LOGIN = "general_ks";
    public static final String DOMAIN = "@mail.ru";


    @Then("^the button \"([^\"]*)\" should be visible$")
    public void theButtonShouldBeVisible(String arg0) {
        assertEquals(true, $(By.xpath("//span[contains(text(),'Compose')]"))
                .isEnabled());
    }

    @Then("^the \"([^\"]*)\" should be visible$")
    public void theShouldBeVisible(String button) {
        assertEquals(true, $(By.xpath("//div[text()='" + button + "']")).isEnabled());
    }



    @Given("^GetDriver$")
    public void getdriver() throws InterruptedException {
        open("http://www.mail.ru/");
        getWebDriver().manage().window().maximize();
    }

    @When("^Got to Mail\\.ru$")
    public void gotToMailRu() {

    }

    @And("^Close Browser$")
    public void closeBrowser() {
        getWebDriver().quit();
    }

    @And("^I do login$")
    public void iDoLogin() {
        $(byName("domain")).selectOptionContainingText(DOMAIN);
        $(byName("login")).sendKeys(LOGIN, Keys.ENTER);
        $(byName("password")).sendKeys(PASSWORD, Keys.ENTER);

    }
}
