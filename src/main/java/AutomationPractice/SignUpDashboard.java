package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gigabyte on 17.10.2016.
 */
public class SignUpDashboard {
    private WebDriver driver;

    @FindBy(linkText = "Sign in")
    public WebElement signInButton;

    @FindBy(linkText = "Sign out")
    public WebElement signOutButton;

    @FindBy(id = "email")
    public WebElement emailAddress_signIn;

    @FindBy(id = "email_create")
    public WebElement emailAddress_signUp;

    @FindBy(id = "customer_firstname")
    public WebElement customer_last_name_signUp;

    @FindBy(id = "passwd")
    public WebElement password_signUp;

    @FindBy(id = "customer_lastname")
    public WebElement customer_first_name_signUp;

    @FindBy(id = "passwd")
    public WebElement password_signIn;

    @FindBy(xpath = "//div[@class='form-group form-ok']")
    public WebElement signIn_check;

    @FindBy(xpath = "//div[@class='form-group form-error']")
    public WebElement signIn_error;

    @FindBy(id = "create_account_error")
    public WebElement signUp_email_format_error;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement signIn_non_existing_user_error;

    @FindBy(id = "id_gender1")
    public WebElement MR_radio_button_sign_up;

    @FindBy(id = "newsletter")
    public WebElement checkBox_newsLetter_signUp;

    @FindBy(id = "optin")
    public WebElement checkBox_special_offer_signUp;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement dropDown_days_signUp;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement dropDown_months_signUp;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement dropDown_years_signUp;

    @FindBy(id = "address1")
    public WebElement first_address_signUp;

    @FindBy(id = "city")
    public WebElement city_signUp;

    @FindBy(id = "postcode")
    public WebElement postcode_signUp;

    @FindBy(id = "phone")
    public WebElement phone_signUp;

    @FindBy(id = "submitAccount")
    public WebElement button_submit_signUp;

    @FindBy(xpath = "//select[@name='id_state']")
    public WebElement dropDown_state_signUp;


    public SignUpDashboard(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
