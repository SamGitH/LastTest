package com.samTest.BDD;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

/**
 * Created by Олег on 29.05.2017.
 */
public class Stepdefs {
    private static Issue issue;

    private static User user;

    private void setupIssue(String issue_name){
        Random random = new Random();
        issue = Loader.issues.get(issue_name);
        issue.setOs(System.getProperty("os.name"));
        issue.setOsVersion(System.getProperty("os.version"));
        issue.setPlatform(System.getProperty("os.arch"));

        issue.setDescription(issue.getDescription() + random.nextInt());
        issue.setSummary(issue.getSummary() + random.nextInt());
        issue.setAdditional_info(issue.getAdditional_info() + random.nextInt());
        issue.setSteps_to_reproduce(issue.getSteps_to_reproduce() + random.nextInt());
    }

    @Given("^User logs in as \"([^\"]*)\"$")
    public void userLogsInAs(String arg0) throws Throwable {
        MantisSite.open();
        user = Loader.users.get(arg0);
        MantisSite.loginPage.Login(user);
    }

    @And("^Press CreateButton$")
    public void pressCreateButton() throws Throwable {
        MantisSite.mainPage.clickCreateButton();
    }


    @When("^user fills form \"([^\"]*)\"$")
    public void userFillsForm(String arg0) throws Throwable {
        setupIssue(arg0);
        MantisSite.issuePage.fillFields(issue);
    }

    @And("^Sabmit issue$")
    public void sabmitIssue() throws Throwable {
        MantisSite.issuePage.submitIssue();
    }

    @Then("^user open bug table$")
    public void userOpenBugTable() throws Throwable {
        MantisSite.gotoBugTable();
    }


    @And("^find table \"([^\"]*)\"$")
    public void findTable(String arg0) throws Throwable {
        MantisSite.mainPage.findCreatedIssue(issue,arg0);
    }

    @And("^logout$")
    public void logout() throws Throwable {
        MantisSite.logout();
    }

    @When("^Open task$")
    public void openTask() throws Throwable {
        MantisSite.mainPage.clickNumberTaskButton();
    }

    @And("^check fields in issue$")
    public void checkFieldsInIssue() throws Throwable {
        MantisSite.checkIssue.checkFields(issue, "assigned");
    }

    @And("^make issue resolved$")
    public void makeIssueResolved() throws Throwable {
        MantisSite.checkIssue.resolveIssue("resolved");
    }

    @And("^make issue closed$")
    public void makeIssueClosed() throws Throwable {
        MantisSite.checkIssue.closeIssue("closed");
    }

    @And("^turn off filters$")
    public void turnOffFilters() throws Throwable {
        MantisSite.mainPage.turnOffFilters();
    }
}
