package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class WishListPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class,'itemCount_')]")
    private WebElement numberOfProductsInWishlist;
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    public String getNumberOfProductsInWishList(){
        final String [] fullNumber = numberOfProductsInWishlist.getText().split(" ");
        String onlyNumber = fullNumber[0];
        return onlyNumber;
    }
    public WebElement isWishListVisible(){
        return  numberOfProductsInWishlist;
    }
}
