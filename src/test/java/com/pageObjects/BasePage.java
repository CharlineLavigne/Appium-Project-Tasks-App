package com.pageObjects;

import com.testCases.BaseTest;
import com.utilities.ElementInteractions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BasePage {

    BaseTest baseTest;
    public ElementInteractions interactions;

    @AndroidFindBy(accessibility = "More options")
    private WebElement optionsBtn;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backBtn;

    public BasePage() throws IOException {
        baseTest = new BaseTest();
        PageFactory.initElements(new AppiumFieldDecorator(baseTest.getDriver()), this);
        interactions = new ElementInteractions();
    }

    public void clickSettingsBtn(){
        interactions.click(optionsBtn);
    }

    public void clickBackBtn(){
        interactions.click(backBtn);
    }
}
