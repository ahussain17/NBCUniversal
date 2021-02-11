package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestPage {
    WebDriver driver;
    private Select pizza1;
    private Select pizza1Toppings1;
    private Select pizza1Toppings2;
    private WebElement pizza1Quantity;
    private WebElement pizza1Cost;
    private WebElement radioCreditCard;
    private WebElement radioCash;
    private WebElement email;
    private WebElement name;
    private WebElement phone;
    private WebElement placeOrderButton;
    private WebElement resetButton;
    private WebElement dialog;
    private WebElement dialogText;
    private WebElement dialogueWindow;

    public TestPage(WebDriver driver) {
        this.driver = driver;

        pizza1=new Select(driver.findElement(By.id("pizza1Pizza")));
        pizza1Toppings1=new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")));
        pizza1Toppings2=new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")));
        pizza1Quantity=driver.findElement(By.id("pizza1Qty"));
        pizza1Cost=driver.findElement(By.id("pizza1Cost"));
        radioCreditCard=driver.findElement(By.id("ccpayment"));
        radioCash=driver.findElement(By.id("cashpayment"));
        email=driver.findElement(By.id("email"));
        name=driver.findElement(By.id("name"));
        phone=driver.findElement(By.id("phone"));
        placeOrderButton=driver.findElement(By.id("placeOrder"));
        resetButton=driver.findElement(By.id("reset"));
        dialog=driver.findElement(By.id("dialog"));
        dialogText=driver.findElement(By.xpath("//div[@id='dialog']/p"));
        dialogueWindow=driver.findElement(By.xpath("//div[@id='dialog']"));
    }

    public void enterName(String name) {
        this.name.sendKeys(new CharSequence[]{name});
    }
    public String getName() {
        return this.name.getText();
    }
    public void enterEmail(String email) {
        this.email.sendKeys(new CharSequence[]{email});
    }
    public String getEmail() {
        return this.email.getText();
    }
    public void enterPhone(String phone) {
        this.phone.sendKeys(new CharSequence[]{phone});
    }
    public String getPhone() {
        return this.phone.getText();
    }
    public void setPizza1(String dropDownValue) {
        this.pizza1.selectByValue(dropDownValue);
    }
    public String getPizza1() {
        return this.pizza1.getFirstSelectedOption().getText();
    }
    public void setPizza1Toppings1(String dropDownValue) {
        this.pizza1Toppings1.selectByValue(dropDownValue);
    }
    public String getPizza1Toppings1() {
        return this.pizza1Toppings1.getFirstSelectedOption().getText();
    }
    public void setPizza1Toppings2(String dropDownValue) {
        this.pizza1Toppings2.selectByValue(dropDownValue);
    }
    public String getPizza1Toppings2() {
        return this.pizza1Toppings2.getFirstSelectedOption().getText();
    }
    public void setRadioCreditCard() {
        this.radioCreditCard.click();
    }
    public boolean getRadioCreditCardStatus() {
        return this.radioCreditCard.isSelected();
    }
    public void setRadioCash() {
        this.radioCash.click();
    }
    public boolean getRadioCashStatus() {
        return this.radioCash.isSelected();
    }
    public String getDialogText()
    {
        return this.dialogText.getText();
    }
    public String getPizzaCostText()
    {
        return this.pizza1Cost.getAttribute("value");
    }
    public void enterPizza1Quantity(String quantity) {
        this.pizza1Quantity.sendKeys(new CharSequence[]{quantity});
    }
    public String getPizza1Quantity() {
        return this.pizza1Quantity.getText();
    }
    public void pressOrderButton() {
        this.placeOrderButton.click();
    }
    public void pressResetButton() {
        this.resetButton.click();
    }
    public boolean getDialogueStatus() {
        return this.dialogueWindow.isDisplayed();
    }
    public void waitAfterSubmit()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
