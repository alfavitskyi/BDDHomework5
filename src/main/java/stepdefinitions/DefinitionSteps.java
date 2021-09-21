package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

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
    RegisterPage registerPage;
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
    @And("User checks search Account button visibility")
    public void checkAccountButtonVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isAccountButtonVisible();
    }
    @And("User checks MyDetails button visibility")
    public void checkMyDetailsButtonVisibility() throws InterruptedException {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
        signInPage.isMyDetailsFieldVisible();
    }
    @And("User checks search My account button visibility")
    public void checkMyAccountButtonVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isMyAccountButtonVisible();
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
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
        homePage.clickAccountButton();
    }
    @And("User clicks on MyAccount button")
    public void clickOnMyAccountButton() throws InterruptedException {
        homePage.clickOnMyAccountButton();
    }
    @And("User selects day {int} in registration form")
    public void fillInDayRegisterForm(int day) {
        registerPage.setDayInRegistration(day);
    }
    @And("User selects month {int} in registration form")
    public void fillInMonthRegisterForm(int month) {
        registerPage.setMonthInRegistration(month);
    }
    @And("User selects year {int} in registration form")
    public void fillInYearRegisterForm(int year) {
        registerPage.setYearInRegistration(year);
    }
    @And("User puts email {string} in registration form")
    public void putEmailForRegistration(String email) {
        registerPage = new RegisterPage(driver);
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registerPage.putEmailInRegistration(email);
    }
    @And("User puts  first name {string} in registration form")
    public void putFirstNameForRegistration (String firstName){
        registerPage.putFirstNameInRegistration(firstName);
    }
    @And("User puts  last name {string} in registration form")
    public void putLastNameForRegistration (String lastName){
        registerPage.putLastNameInRegistration(lastName);
    }
    @And("User puts  password {string} in registration form")
    public void putPasswordForRegistration (String password){
        registerPage.putPasswordInRegistration(password);
    }
    @And("User clicks on submit button for registration")
    public void clickOnSubmitButtonForRegistration(){
        registerPage.clickSubmitButton();
    }
    @And("User clicks Join in registration tab")
    public void clickJoinButton (){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        //registerPage.clickJoinButton();
    }
    @And("User checks successful registration with email {string}")
    public void checkSuccessfulRegistration (String expectedEmail){
        signInPage = new SignInPage(driver);
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(expectedEmail,signInPage.getEmailFromMyAccount());
    }

    @And("User puts email {string} for sign in my account")
    public void EmailForSignIn(String email){
        signInPage = new SignInPage(driver);
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
        signInPage.putEmailForSignIn(email);
    }
    @And("User puts password {string} for sign in my account")
    public void PasswordForSignIn(String password){
        signInPage.putPasswordForSignIn(password);
    }
    @And("User clicks Sign In button")
    public void clickSignInToMyAccount(){
        signInPage.clickSignIn();
    }
    @And("User goes to My details in My Account")
    public void goToMyDetails() throws InterruptedException {
       signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
       signInPage.myDetailsInMyAccount();
    }
    @And("User checks that signing in was successful in MyAccount with name {string}")
    public void checkSuccessfulSignIn(String expectedName) throws InterruptedException {
         signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
         sleep(2000);
         assertEquals(expectedName,signInPage.getuserNameFromMyAccount());
    }
    @And("User submits registration")
    public void submitRegistration () throws InterruptedException {
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sleep(3000);
        registerPage.clickSubmitButton();
    }
    @And("User clicks join on main page")
    public void clickRegisterOnMainPage(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickRegisterOnMainPage();
    }
    @And("User checks number of products displayed with expected quantity {int}")
    public void checkNumberOfProductsDisplayed(int expectedNumber) throws InterruptedException {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_FOR_WISHLIST);
        //sleep(3000);
        assertEquals(expectedNumber,searchResultPage.getNumberOfProductsDisplayed());
    }
    @And("User checks that account with entered email already exist - expected pop-up {string}")
        public void checkThatAccountAlreadyExist(String text){
        registerPage = new RegisterPage(driver);
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(text, registerPage.getConfirmationOfAlreadyExistAccount());
    }
    @After
    public void tearDown() {
        driver.close();
    }
}