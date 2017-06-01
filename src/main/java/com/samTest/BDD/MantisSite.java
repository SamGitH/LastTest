package com.samTest.BDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Олег on 29.05.2017.
 */
public class MantisSite  {
    public static LoginPage loginPage;

    public static IssuePage issuePage;

    public static MainPage mainPage;

    public static CheckIssue checkIssue;

    public static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.loginPage     = PageFactory.initElements(driver, LoginPage.class);
        MantisSite.issuePage     = PageFactory.initElements(driver, IssuePage.class);
        MantisSite.mainPage      = PageFactory.initElements(driver, MainPage.class);
        MantisSite.checkIssue = PageFactory.initElements(driver, CheckIssue.class);
        MantisSite.driver        = driver;

    }
    public static void gotoBugTable() { driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1/view_all_bug_page.php"); }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1");
    }

    public static void logout() { driver.navigate().to("http://127.0.0.1/mantisbt-2.4.1/logout_page.php"); }
}
