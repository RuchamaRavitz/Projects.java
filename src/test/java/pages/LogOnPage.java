package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LogOnPage {

    WebDriver driver;

    // constructor of this page
    public LogOnPage(WebDriver driver){
        this.driver=driver;
    }
    //locator
    By iconAccount=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[3]/div[2]/div/a/img");
    By enteredEmail=By.xpath("//*[@id=\"EmailOrAccountNumber\"]");
    By enteredPassword=By.xpath("//*[@id=\"Password\"]");
    By clickSignIn=By.xpath("//*[@id=\"SignInNow\"]");

    //method

    //method to go to account
    public void icon_button(){
        driver.findElement(iconAccount).click();
    }
    // method to enter email
    public void enter_email(String email) throws ParserConfigurationException, IOException, SAXException {
        // שם משתמש דרך קליטה מקובץ קבועים
      //  driver.findElement(enteredEmail).sendKeys(Constants.emailAddress);
        // שם משתמש דרך קליטה מקובץ חיצוני
    driver.findElement(enteredEmail).sendKeys(email);
    }
    // method to enter password
    public void enter_password(String password) throws ParserConfigurationException, IOException, SAXException {

      //  driver.findElement(enteredPassword).sendKeys(Constants.password);
        driver.findElement(enteredPassword).sendKeys(password);
    }
    // method to click on sign in button
    public void signInBTN(){
        driver.findElement(clickSignIn).click();
    }
    // פונקציה של קריאה מקובץ xml
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Java Projects\\progectselenium\\urlData.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}
