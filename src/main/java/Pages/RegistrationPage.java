package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")
    WebElement createAccount;
    @FindBy(name = "firstname")
    WebElement firstname;
    @FindBy(name = "lastname")
    WebElement lastname;
    @FindBy(name = "reg_email__")
    WebElement email;
    @FindBy (name="reg_email_confirmation__")
    WebElement remail;
    @FindBy(name ="reg_passwd__")
    WebElement password;

    @FindBy(xpath ="//input[@class='_8esa'][1]")
    WebElement gender;
    @FindBy(name ="websubmit")
    WebElement signupbtn;

    @FindBy (className ="uiHeaderTitle")
      public  WebElement text;

    @FindBy (xpath="//div[@class='_5633 _5634 _53ij']")
    public  WebElement error;

    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnCreate()
    {
        createAccount.click();
    }
    public void register(String first_name, String last_name,String mail,String mail2,String pass)
    {
        firstname.sendKeys(first_name);
        lastname.sendKeys(last_name);
        email.sendKeys(mail);
        remail.sendKeys(mail2);
        password.sendKeys(pass);
        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByVisibleText("28");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Select month=new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Sep");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Select year=new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1994");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        gender.click();
        signupbtn.click();

    }
}