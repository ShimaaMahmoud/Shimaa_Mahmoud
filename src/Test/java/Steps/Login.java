package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login {
LoginPage loginPage;

    @When("user enter valid data")
    public void user_enter_valid_data() {
        loginPage =new LoginPage(Hooks.driver);
        loginPage.login("shimaainstabug22@gmail.com","shima2ma7moud");
    }
    @Then("user can login  sucsessfully")
    public void user_can_login_sucsessfully() {
     String url=Hooks.driver.getCurrentUrl().toString();
     System.out.println(url);
        Assert.assertTrue(url.contains("facebook"));
    }

    @When("user enter Invalid data")
    public void userEnterInvalidData() {
        loginPage =new LoginPage(Hooks.driver);
        loginPage.login("shimaainstabug22@gmail.com","AAshima2ma7moud");

    }

    @Then("user cannot login with validation message")
    public void userCannotLoginWithValidationMessage() {
        loginPage =new LoginPage(Hooks.driver);
      String text =loginPage.error_password.getText();
      System.out.println(text);
      Assert.assertTrue(text.contains("password that you've entered is incorrect"));
    }

    @When("user enter empty data")
    public void userEnterEmptyData() {
        loginPage =new LoginPage(Hooks.driver);
        loginPage.login("","");
    }

    @Then("user cannot login with validation_message")
    public void userCannotLoginWithValidation_message() {
        loginPage =new LoginPage(Hooks.driver);
        String text =loginPage.error_password.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("email address or mobile number you entered isn't connected to an account"));
    }
}
