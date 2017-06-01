package com.samTest.BDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 29.05.2017.
 */
public class LoginPage {
    @FindBy(id="username")
    WebElement userName;
    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[2]")
    WebElement LogNamebutton;
    @FindBy(id="password")
    WebElement userPassword;
    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[3]")
    WebElement LogPasswordbutton;
    public void Login(User user){
        this.userName.sendKeys(user.getLogin());
        this.LogNamebutton.click();
        this.userPassword.sendKeys(user.getPassword());
        this.LogPasswordbutton.click();
    }
}
