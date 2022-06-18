package Steps;

import Pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Register {

    RegistrationPage registrationPage;

    @When("user enter valida data")
    public void user_enter_valida_data() {
     registrationPage=new RegistrationPage(Hooks.driver);
     registrationPage.clickOnCreate();
     registrationPage.register("shohso","mahmoud","shos@gmail.com","shos@gmail.com","shimaa12344321");
    }
    @Then("user can register sucsessfully")
    public void user_can_register_sucsessfully() {
        registrationPage=new RegistrationPage(Hooks.driver);
      String text=  registrationPage.text.getText();
      System.out.println(text);
        Assert.assertTrue(text.contains("Enter the code from your email"));
    }

    @When("user enter invalid password")
    public void userEnterInvalidaData() {
        registrationPage=new RegistrationPage(Hooks.driver);
        registrationPage.clickOnCreate();
        registrationPage.register("shohso","mahmoud","shos@gmail.com","sho","shimaa234123");
    }

    @Then("user cannot register sucsessfully")
    public void userCannotRegisterSucsessfully() {
        registrationPage=new RegistrationPage(Hooks.driver);
        Hooks.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String text=  registrationPage.error.getText();
        System.out.println("error is "+text);
        Assert.assertTrue(text.contains("enter a valid email address"));
    }
}
