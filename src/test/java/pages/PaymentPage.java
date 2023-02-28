package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    // constructor of this page
    public PaymentPage (WebDriver driver){
        this.driver=driver;
    }

    //locator
    By selectPayment=By.xpath("//*[@id=\"PaymentId\"]");
    By enteredNumberCard=By.xpath("//*[@id=\"cardNumber\"]");
    By enteredDateMonth=By.xpath("//*[@id=\"expiryMonth\"]");
    By enteredDateYear=By.xpath("//*[@id=\"expiryYear\"]");
    By enteredSecurityCode=By.xpath("//*[@id=\"securityCode\"]");
    By paymentBTN=By.xpath("//*[@id=\"submitButton\"]");
    By cardText=By.xpath("//*[@id=\"cardNumber-hint\"]");

    public int number;
    public PaymentPage(int num){
        this.number=num;
    }

    public void buy(){
        driver.findElement(By.id("EmailOrAccountNumber")).sendKeys(Constants.emailAddress);
    }

    // method

    // method to select payment
    public void selectPayment(){
        driver.findElement(selectPayment).click();
    }

    // method to enter card number
    public void enterNumberCard (){
        driver.findElement(enteredNumberCard).sendKeys(Constants.cardNumber);
    }

    // method to enter month
    public void enterMonth (){
        driver.findElement(enteredDateMonth).sendKeys(Constants.dateMonth);
    }
    // method to enter year
    public void enterYear (){
        driver.findElement(enteredDateYear).sendKeys(Constants.dateYear);
    }
    // method to enter Security Code
    public void SecurityCode (){
        driver.findElement(enteredSecurityCode).sendKeys(Constants.securityCode);
    }
    // method to click payment BTN
    public void paymentBTNClick(){
        driver.findElement(paymentBTN).click();
    }
    // method to get text error
    public void cardGetText (){
        String errorText=driver.findElement(cardText).getText();
        Assert.assertEquals("הזן מספר תקין",errorText);

    }
}
