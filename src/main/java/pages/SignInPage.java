package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailAddressInMyAccount;
    @FindBy(xpath = "//input[@data-st-field='id-signIn-emailAddress']")
    private WebElement emailFieldToSignIn;
    @FindBy(xpath = "//input[@data-st-field='id-signIn-password']")
    private WebElement passwordFieldToSignIn;
    @FindBy(xpath = "//div[@class='submit']//*[@id='signin']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@href='/my-account/my-details']")
    private WebElement myDetailsButton;
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public void putEmailForSignIn (String email){
        emailFieldToSignIn.sendKeys(email);
    }
    public void putPasswordForSignIn(String password){
        passwordFieldToSignIn.sendKeys(password);
    }
    public void clickSignIn (){
        signInButton.click();
    }
    public String getEmailFromMyAccount(){
        String email = driver.findElement(By.xpath("//input[@name='emailAddress']")).getText();
        return email;
    }
    public void myDetailsInMyAccount(){
        myDetailsButton.click();
    }
}
