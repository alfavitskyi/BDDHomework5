package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{
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
    @FindBy (xpath = "//span[@class='field-validation-error qa-email-validation']")
    private WebElement validationOfAlreadyExistAccount;
    public RegisterPage(WebDriver driver) {
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
    public void putPasswordInRegistration(String passwordForRegistration){
        passwordInRegistration.sendKeys(passwordForRegistration);
    }
    public void setDayInRegistration (int day){
        driver.getCurrentUrl();
        Select options = new Select(driver.findElement(By.id("BirthDay")));
        options.selectByIndex(day);
    }
    public void setMonthInRegistration (int month){
        driver.getCurrentUrl();
        Select options = new Select(driver.findElement(By.id("BirthMonth")));
        options.selectByIndex(month);
    }
    public void setYearInRegistration (int year){
        driver.getCurrentUrl();
        Select options = new Select(driver.findElement(By.xpath("//select[@name='BirthYear']")));
        options.selectByIndex(year);
    }

    public void clickJoinButton(){
        clickByElement(5, joinButton);
    }
    public void clickSubmitButton(){
        submitInRegistration.click();
    }
    public String getConfirmationOfAlreadyExistAccount(){
        return validationOfAlreadyExistAccount.getText();
    }


}
