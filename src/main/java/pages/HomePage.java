package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@id='men-floor']")
    private  WebElement menCategory;
    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishListButton;
    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement accountButton;
    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountButton;



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage (String url){
        driver.get(url);
    }
    public void enterTextToSearchField (String keyword){
        searchField.clear();
        searchField.sendKeys(keyword);
    }
    public void isSearchFieldVisible(){
        searchField.isDisplayed();
    }
    public void isAccountButtonVisible(){
        accountButton.isDisplayed();
    }
    public void isMyAccountButtonVisible(){
        myAccountButton.isDisplayed();
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void choseMenCategory(){
        menCategory.click();
    }
    public void clickWishListButton(){
        wishListButton.click();
    }
    public void clickAccountButton(){accountButton.click();}
    public void clickOnMyAccountButton(){myAccountButton.click();}
}
