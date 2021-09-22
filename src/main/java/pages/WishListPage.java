package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class WishListPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class,'itemCount_')]")
    private WebElement numberOfProductsInWishlist;
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    public String getNumberOfProductsInWishList(){
        waitVisibilityOfElement(5, numberOfProductsInWishlist);
        final String [] fullNumber = numberOfProductsInWishlist.getText().split(" ");
        String onlyNumber = fullNumber[0];
        return onlyNumber;
    }
    public WebElement isWishListVisible(){
        return  numberOfProductsInWishlist;
    }
}
