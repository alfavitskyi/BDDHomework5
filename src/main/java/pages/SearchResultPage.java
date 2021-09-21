package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> searchResultOfGoodsList;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnFirstWishGood(){
        searchResultOfGoodsList.get(0).click();
    }
    public int getNumberOfProductsDisplayed (){

        List<WebElement> webElementList = driver.findElements(xpath("//button[@data-auto-id='saveForLater']"));
        return webElementList.size();
    }
}
