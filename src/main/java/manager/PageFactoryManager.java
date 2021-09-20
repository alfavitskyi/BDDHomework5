package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage getHomePage(){
        return new HomePage(driver);
    }
    public SearchResultPage getSearchResultPage (){return new SearchResultPage(driver);}
    public WishListPage getWishListPage (){return new WishListPage(driver);}
    public RegisterPage getRegisterPage(){return new RegisterPage(driver);}
    public SignInPage getSignInPage(){return new SignInPage(driver);}
}
