package com.samTest.BDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by Олег on 29.05.2017.
 */
public class MainPage {
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a/i")
    WebElement CreateButton;

    @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr[1]/td[4]/a")
    WebElement NumberTaskButton;

    @FindBy(id = "hide_status_filter")
    WebElement hideStatusFilter;

    @FindBy(xpath = "//select[@name=\"hide_status[]\"]")
    WebElement hideStatusSelector;

    @FindBy(xpath = "//input[@name=\"filter\"]")
    WebElement applyFilterBtn;

    public void clickCreateButton(){
        CreateButton.click();
    }
    public void clickNumberTaskButton(){
        NumberTaskButton.click();
    }

    public void findCreatedIssue(Issue issue, String assigned) {
        Assert.assertTrue(MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().anyMatch(row ->
                        (row.getText().contains(issue.getSummary()))
                                && (row.getText().contains("block"))
                                && (row.getText().contains(assigned))
                                && (row.getText().contains("General"))));
    }
    public void turnFilterOff() {
        hideStatusFilter.click();
        new Select(hideStatusSelector).selectByVisibleText("[none]");
        applyFilterBtn.click();
    }
}
