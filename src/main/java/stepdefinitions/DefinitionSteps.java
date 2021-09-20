package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultPage;
import pages.SignInPage;
import pages.WishListPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    private static final long DEFAULT_TIMEOUT_FOR_WISHLIST = 120;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultPage searchResultPage;
    WishListPage wishListPage;
    SignInPage signInPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User makes search by keyword {string}")
    public void enterSearchKeywordToSearchField(String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks on search button")
    public void clickOnSearchButton() throws InterruptedException {
        homePage.clickSearchButton();
    }

    @And("User clicks on Men category")
    public void clickOnMenCategory() {
        homePage.choseMenCategory();
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User clicks first product to wishlist")
    public void clickWishList() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnFirstWishGood();
    }

    @And("User clicks wishlist button")
    public void openWishList() {
        homePage.clickWishListButton();
    }

    @And("User checks that amount of products in wish list are {string}")
    public void checkAmountOfProductsInWishList(String expectedAmount) {
        wishListPage = new WishListPage(driver);
        assertEquals(wishListPage.getNumberOfProductsInWishList(), expectedAmount);
    }
    @And("User clicks on personal account button")
    public void goToPersonalAccount(){
        homePage.clickAccountButton();
    }
    @And("User clicks on MyAccount button")
    public void clickOnMyAccountButton(){
        homePage.clickOnMyAccountButton();
    }
    @And("User puts information for registration: email {string}, first name {string}, last name {string}, password {string}, day{int}")
    public void fillInRegisterForm(String email, String firstName,String lastName, String password, int day){
        signInPage.putEmailInRegistration(email);
        signInPage.putFirstNameInRegistration(firstName);
        signInPage.putLastNameInRegistration(lastName);
        signInPage.passwordInRegistration(password);
        signInPage.setDayInRegistration(day);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}