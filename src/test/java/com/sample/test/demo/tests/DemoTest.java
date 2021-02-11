package com.sample.test.demo.tests;

import com.sample.test.demo.constants.CustomerConstant;
import com.sample.test.demo.constants.OrderConstants;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoTest extends TestBase{

    //Happy path
    @Test(testName = "Proper Order")
    public void submitProperOrder(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_MIN_PIZZA.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        Assert.assertEquals(dialogueText.replaceAll("\\s",""),OrderConstants.MESSAGE_SUCCESSFUL_MASHROOM_OLIVES_NO_TOPPING.getDisplayName().replaceAll("\\s",""));
    }

    //Boundary check MAx
    @Test(testName = "Maximum Quantity Order")
    public void submitMaximumOrder(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_MAX_PIZZA.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        Assert.assertEquals(dialogueText.replaceAll("\\s",""),OrderConstants.MESSAGE_SUCCESSFUL_MASHROOM_OLIVES_NO_TOPPING.getDisplayName().replaceAll("\\s",""));
    }
    //Boundary Check Minimum
    @Test(testName = "No Quantity Order")
    public void submitNoQuantityOrder(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_NO_PIZZA.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        //As there is no quantity the order should not be submitted as a successful order.
        Assert.assertFalse(dialogueText.replaceAll("\\s","").contains(OrderConstants.MESSAGE_SUCCESSFUL_ORDER.getDisplayName().replaceAll("\\s","")));
    }

    //Boundary Check Random Qty
    @Test(testName = "RANDOM QUANTITY ORDER")
    public void submitRandomQtyOrder(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_RAND_QTY.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        Assert.assertTrue(dialogueText.replaceAll("\\s","").contains(OrderConstants.MESSAGE_SUCCESSFUL_ORDER.getDisplayName().replaceAll("\\s","")));
    }

    //Unhappy path
    @Test(testName = "Nothing Selected Order")
    public void submitWithoutSelectingAnything()
    {
        TestPage webPage = new TestPage(super.driver);
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        Assert.assertEquals(dialogueText.replaceAll("\\s", ""),OrderConstants.MESSAGE_NO_SELECT_ERROR.getDisplayName().replaceAll("\\s", ""));
    }
    //Unhappy path
    @Test(testName = "Payment Method Select Both While ordering")
    public void submitBothPaymentMethodSelected(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_MIN_PIZZA.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.setRadioCash();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        //Both the payment method can not be selected for a successful order
        Assert.assertFalse(dialogueText.replaceAll("\\s","").contains(OrderConstants.MESSAGE_SUCCESSFUL_ORDER.getDisplayName().replaceAll("\\s","")));
    }
    @Test(testName = "Press Reset to Clear")
    public void submitReset(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_RAND_QTY.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.setRadioCash();
        webPage.pressResetButton();
        //Check the fields did reset or not
        Assert.assertEquals(webPage.getPizza1().trim(),OrderConstants.DDL_PIZZA1_DEFAULT.getDisplayName());
        Assert.assertEquals(webPage.getPizza1Toppings1().trim(),OrderConstants.DDL_PIZZA_TOP1_DEFAULT.getDisplayName());
        Assert.assertEquals(webPage.getPizza1Toppings2().trim(),OrderConstants.DDL_PIZZA_TOP2_DEFAULT.getDisplayName());
        Assert.assertEquals(webPage.getPizza1Quantity().trim(),OrderConstants.QTY_NO_PIZZA.getDisplayName());
        Assert.assertEquals(webPage.getPizzaCostText().trim(),OrderConstants.QTY_NO_PRICE.getDisplayName());
        Assert.assertEquals(webPage.getName().trim(),"");
        Assert.assertEquals(webPage.getEmail().trim(),"");
        Assert.assertEquals(webPage.getPhone().trim(),"");
        Assert.assertFalse(webPage.getRadioCashStatus());
        Assert.assertFalse(webPage.getRadioCreditCardStatus());
        Assert.assertFalse(webPage.getDialogueStatus());
    }
    @Test(testName = "Order with puting Character in Quantity")
    public void submitCharacterQuantity(){
        TestPage webPage = new TestPage(super.driver);
        webPage.setPizza1(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName());
        webPage.setPizza1Toppings1(PizzaToppings.OLIVES.getDisplayName());
        webPage.setPizza1Toppings2(PizzaToppings.MUSHROOMS.getDisplayName());
        webPage.enterPizza1Quantity(OrderConstants.QTY_CHARACTER.getDisplayName());
        webPage.enterName(CustomerConstant.CUSTOMER_NAME.getDisplayName());
        webPage.enterEmail(CustomerConstant.CUSTOMER_EMAIL.getDisplayName());
        webPage.enterPhone(CustomerConstant.CUSTOMER_PHONE.getDisplayName());
        webPage.setRadioCreditCard();
        webPage.pressOrderButton();
        String dialogueText=webPage.getDialogText();
        Assert.assertFalse(dialogueText.replaceAll("\\s","").contains(OrderConstants.MESSAGE_SUCCESSFUL_ORDER.getDisplayName().replaceAll("\\s","")));
    }


}
