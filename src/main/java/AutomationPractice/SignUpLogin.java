package AutomationPractice;

/**
 * Created by Gigabyte on 17.10.2016.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import AutomationPractice.SignUpDashboard;


public class SignUpLogin {
    static WebDriver driver;
    WebElement element;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Before
    public void openBrowser(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        driver.get("http://automationpractice.com/index.php");
        try{
            if (sign.signOutButton != null){
                sign.signOutButton.click();
            }
        }
        catch (Exception e){
        }
    }

    @Test
    public void invalidEmailFormatLogin(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signIn.sendKeys("random.com");
        sign.password_signIn.click();
        try {
            element = sign.signIn_error;
        }
        catch (Exception e){
        }
        Assert.assertNotNull("Error of wrong email format has not been shown!",element);
    }   //checks if error shows up if wrong email format is provided
    @Test
    public void validEmailFormatLogin(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signIn.sendKeys("random.com");
        sign.password_signIn.click();
        try {
            element = sign.signIn_check;
        }
        catch (Exception e){
        }
        Assert.assertNotNull("Check sign of correct email format has not been shown!",element);
    }   //checks if OK sign shows up if correct email format is provided
    @Test
    public void invalidLoginData(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signIn.sendKeys("random@email.com");
        sign.password_signIn.sendKeys("random");
        sign.password_signIn.submit();
        try {
            element = sign.signIn_non_existing_user_error;
        }
        catch (Exception e){

        }
        Assert.assertNotNull("No error has been shown up,after non existing user tried to login!",element);
    }       //checks if error shows up,after non existing user tries to login
    @Test
    public void validLoginData(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signIn.sendKeys("jerrywoodburn@seznam.com");
        sign.password_signIn.sendKeys("kiklop");
        sign.password_signIn.submit();
        try {
            element = sign.signOutButton;
        }
        catch (Exception e){

        }
        Assert.assertNotNull("SignIn was unsuccessful even with correct data!",element);
    }       //checks if user can login with valid login data
    @Test
    public void invalidEmailFormatSignUp(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signUp.sendKeys("random.com");
        sign.emailAddress_signUp.submit();
        try {
            element = sign.signUp_email_format_error;
        }
        catch (Exception e){
        }
        Assert.assertNotNull("Error of wrong email format has not been shown!",element);
    } //checks if error shows up if wrong email format is provided
    @Test
    public void validEmailFormatSignUp(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        sign.signInButton.click();
        sign.emailAddress_signUp.sendKeys("random@email.com");
        sign.emailAddress_signUp.submit();
        try {
            element = sign.customer_first_name_signUp;
        }
        catch (Exception e){
        }
        Assert.assertNotNull("Even though,right email has been provided,error has been shown!",element);
    } //checks if OK sign shows up if correct email format is provided
    @Test
    public void signUp(){
        SignUpDashboard sign = new SignUpDashboard(driver);
        Random rand = new Random();
        int value = rand.nextInt(100000);

        sign.signInButton.click();
        sign.emailAddress_signUp.sendKeys("woodburn"+value+"@seznam.cz");
        sign.emailAddress_signUp.submit();
        try{
            sign.MR_radio_button_sign_up.click();
            sign.customer_first_name_signUp.sendKeys("Jerry");
            sign.customer_last_name_signUp.sendKeys("Woodburn");
            sign.password_signUp.sendKeys("kiklop");
            Select selectDays = new Select(sign.dropDown_days_signUp);
            selectDays.selectByValue("25");
            Select selectMonths = new Select(sign.dropDown_months_signUp);
            selectMonths.selectByValue("8");
            Select selectYears = new Select(sign.dropDown_years_signUp);
            selectYears.selectByValue("1994");
            sign.checkBox_newsLetter_signUp.click();
            sign.checkBox_special_offer_signUp.click();
            sign.first_address_signUp.sendKeys("Jablonova 100");
            sign.city_signUp.sendKeys("Brno");
            Select selectState = new Select(sign.dropDown_state_signUp);
            selectState.selectByValue("8");
            sign.postcode_signUp.sendKeys("85496");
            sign.phone_signUp.sendKeys("854965785");
            sign.button_submit_signUp.click();
            element = sign.signOutButton;
        }
        catch (Exception e){
        }
        Assert.assertNotNull(element);
    } //tries to create a new client and checks if is automatically loged in

    @AfterClass
    public static void goBackAgain(){
        driver.quit();
    }
}
