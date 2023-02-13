package com.envision.stepdefs;

import com.envision.pageobjects.LoginPage;
import com.envision.pageobjects.TimeTrackPage;
import com.envision.utilities.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageStepDefs {

    WebDriver driver;
    LoginPage lp = new LoginPage(BrowserFactory.getBrowser());
//    @Given("user opens Chrome browser")
//    public void user_opens_chrome_browser() {
//        String brname = PropertiesFileReader.props.get("testdata.browsername").toString();
//        String rmode = PropertiesFileReader.props.get("testdata.runmode").toString();
//       driver = BrowserFactory.getBrowser(brname,rmode);
//    }
    @And("user launches the  url {string}")
    public void user_launches_the_url(String url) {

       BrowserFactory.openUrl(url);
    }
    @Given("user enters {string} as user id")
    public void user_enters_as_user_id(String usernameInputValue) {

        lp.enterUserName(usernameInputValue);
    }
    @And("user enters {string} as password")
    public void user_enters_as_password(String passwordInputValue) {

        lp.enterPassword(passwordInputValue);
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        lp.clickLoginButton();
    }
    TimeTrackPage ttp = new TimeTrackPage(BrowserFactory.getBrowser());
    @Then("user can see the home page title as {string}")
    public void user_can_see_the_home_page_title_as(String expectedTitle) {
        String actualtitle = ttp.getPageTitle();
        Assert.assertEquals(actualtitle, expectedTitle);
    }

}
