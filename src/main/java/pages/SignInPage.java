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
    @FindBy(xpath = "//div[@class='_2roWJCL3cYLWn-WGjDB73j']")
    private WebElement userNameFromMyAccount;
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
        clickByElement(5, signInButton);
    }
    public String getEmailFromMyAccount() {
        return driver.findElement(By.xpath("//input[@name='emailAddress']")).getText();
    }

    public void myDetailsInMyAccount(){
        clickByElement(10, myDetailsButton);;
    }
    public void isMyDetailsFieldVisible(){
        myDetailsButton.isDisplayed();
    }
    public String getuserNameFromMyAccount (){
        return userNameFromMyAccount.getText();
    }
}
