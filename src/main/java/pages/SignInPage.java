package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BasePage{
    @FindBy(xpath = "//a[@class='qa-join-asos']")
    private WebElement joinButton;
    @FindBy(xpath = "//input [@class='qa-email-textbox']")
    private WebElement emailFieldInRegistration;
    @FindBy(xpath = "//input[@class='qa-firstname-textbox']")
    private WebElement firstNameInRegistration;
    @FindBy(xpath = "//input[@class='qa-lastname-textbox']")
    private WebElement lastNameInRegistration;
    @FindBy(xpath = "//input[@class='qa-password-textbox']")
    private WebElement passwordInRegistration;
    @FindBy(xpath = "//div[@class='subfield select-list']")
    private WebElement dayInRegistration;
    @FindBy(xpath = "//div[@class='subfield long-subfield select-list']")
    private WebElement monthInRegistration;
    @FindBy(xpath = "//div[@class='subfield last-subfield select-list']")
    private WebElement yearInRegistration;
    @FindBy(xpath = "//input[@id='register']")
    private WebElement submitInRegistration;
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public void clickJoin(){
        joinButton.click();
    }
    public void putEmailInRegistration(String emailForRegistration){
        emailFieldInRegistration.sendKeys(emailForRegistration);
    }
    public void putFirstNameInRegistration (String firstNameForRegistration){
        firstNameInRegistration.sendKeys(firstNameForRegistration);
    }
    public void putLastNameInRegistration (String lastNameForRegistration){
        lastNameInRegistration.sendKeys(lastNameForRegistration);
    }
    public void passwordInRegistration(String passwordForRegistration){
        passwordInRegistration.sendKeys(passwordForRegistration);
    }
    public void setDayInRegistration (int day){
        dayInRegistration.click();
        driver.getCurrentUrl();
        Select options = new Select(driver.findElement(By.className("//div[@class='subfield select-list']")));
        options.selectByIndex(day);
    }
    public void setMonthInRegistration(){
        monthInRegistration.click();
    }
    public void setYearInRegistration(){
        yearInRegistration.click();
    }
    public void clickJoinButton(){
        joinButton.click();
    }
}
