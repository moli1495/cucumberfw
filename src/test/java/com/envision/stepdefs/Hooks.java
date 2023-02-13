package com.envision.stepdefs;

import com.envision.utilities.BrowserFactory;
import com.envision.utilities.PropertiesFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
    @Before
    public void openBrowser(){
        String brname = PropertiesFileReader.props.get("testdata.browsername").toString();
        String rmode = PropertiesFileReader.props.get("testdata.runmode").toString();

        this.driver= BrowserFactory.getBrowser(brname,rmode);

//        String url= PropertiesFileReader.props.get("testdata.url").toString();
//        BrowserFactory.openUrl(url);
    }

    @After
    public void closeBrowser(){
        BrowserFactory.closeCurrentWindow();
    }
    @AfterAll
    public static void closeAllBrowsers(){
        BrowserFactory.closeAllWindow();
    }
}
