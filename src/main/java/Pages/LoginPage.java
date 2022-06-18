package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy (id="email")
    WebElement email;

    @FindBy (id="pass")
    WebElement Password;

    @FindBy(name="login")
    WebElement loginbtn;

    @FindBy(xpath ="//div[@class='_9ay7']")
  public   WebElement error_password;

    //@FindBy(xpath ="//div[@class='_9ay7']")
   // public   WebElement error_password_mail;


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void login(String mail,String password)
    {
        email.sendKeys(mail);
        Password.sendKeys(password);
        loginbtn.click();
    }
}
