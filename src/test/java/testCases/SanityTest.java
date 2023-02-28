package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pages.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
    public class SanityTest {
        private static WebDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;
        @BeforeClass
        public static void beforeClass() throws ParserConfigurationException, IOException, SAXException {
            System.out.println("baforeClass1");
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.get(getData("URL"));
            /*
            ChromeOptions options = new ChromeOptions();
            //
            options.addArguments("-incognito");
             options.addArguments("--disable-extensions");
             options.addArguments("--profile-directory=Default");
              options.addArguments("--disable-plugins-discovery");
             options.addArguments("--start-maximized");
             //
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            //
              driver.manage().deleteAllCookies();
              */
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.FILE_PATH);
            // attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // name your test and add description
            test = extent.createTest("sanity test", "next");

            // add custom system info
            extent.setSystemInfo("Environment", "Production");
            extent.setSystemInfo("Tester", "Ruchama Pories");

            // log results
            test.log(Status.INFO, "@Before class");

        }


        //כניסה למערכת

        @Test
        public void test1_LPage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
            LogOnPage l1=new LogOnPage(driver);
            test.log(Status.INFO, "enter login test");
            l1.icon_button();
            waiting();
            l1.enter_email(getData("username"));
            waiting();
            l1.enter_password(getData("password"));
            waiting();
            l1.signInBTN();
            waiting();
            driver.navigate().to(Constants.NAVIGATE_L_PAGE);
            // add screenshot
            String currentTime = String.valueOf(System.currentTimeMillis());
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Java Projects\\" + currentTime)).build());
            String get_title_lPage=driver.getTitle();
            // כתיבה ללוג
            if (get_title_lPage.equals(Constants.EXPECTED_TITLE_LOGIN_PAGE))
                test.log(Status.PASS, "Open webpage " + "Webpage opened successfully");
            else
                test.log(Status.FAIL,"Webpage is not opened successfully");
        }

        //    דף הבית
        @Test
        public void test2_HPage() throws InterruptedException, IOException {
            HomePage h1=new HomePage(driver);
            test.log(Status.INFO, "enter home page test");
            driver.navigate().to(Constants.NAVIGATE_HOME_PAGE);
            h1.link_left_side();
            waiting();
           // h1.link_category();
          //  waiting();
            h1.link_banner();
            waiting();
            h1.change_language();
            waiting();
            h1.search_item();
            waiting();
            // add screenshot
            String currentTime = String.valueOf(System.currentTimeMillis());
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Java Projects\\" + currentTime)).build());
            String title_HPage=driver.getTitle();
            // כתיבה ללוג
            if (title_HPage.equals(Constants.EXPECTED_TITLE_HOME_PAGE))
                test.log(Status.PASS, " Test Home page is successfully " + "Webpage is successfully");
            else
                test.log(Status.FAIL,"Test Home page is failed");

        }
        // חיפוש מוצר
    @Ignore
        @Test
        public void test3_SPage() throws InterruptedException {
            SearchPage s1=new SearchPage(driver);
            s1.search_product();
            waiting();
            s1.choose_product();
            waiting();
        }
        // בחירת מוצר
        @Test
        public void test4_PrPage () throws InterruptedException, IOException {
            driver.navigate().to(Constants.NAVIGATE_PRODUCT_PAGE);
            ProductPage pr1=new ProductPage(driver);
            test.log(Status.INFO ,"enter product page test");
            pr1.choose_measure1();
            waiting();
            pr1.fun_choose_color();
            waiting();
            pr1.add_basket();
            waiting();
            driver.navigate().refresh();
            waiting();
            pr1.choose_measure2();
            waiting();
            pr1.add_basket();
            waiting();
            driver.navigate().refresh();
            pr1.basket();
            waiting();
            pr1.go_cash();
            waiting();
            // add screenshot
            String currentTime = String.valueOf(System.currentTimeMillis());
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Java Projects\\" + currentTime)).build());
            String title_PrPage=driver.getTitle();
            String expected_title_PrPage=Constants.EXPECTED_PRODUCT_TITLE_PAGE;
            // כתיבה ללוג
            if (title_PrPage.equals(expected_title_PrPage))
                test.log(Status.PASS, " Test Product page is successfully " + "Webpage is successfully");
            else
                test.log(Status.FAIL,"Test Product page is failed");

        }

        // תשלום
        @Ignore
        @Test
        public void test5_PayPage() throws InterruptedException {
            PaymentPage pay1=new PaymentPage(driver);
            pay1.selectPayment();
            waiting();
            pay1.enterNumberCard();
            waiting();
            pay1.enterMonth();
            waiting();
            pay1.enterYear();
            waiting();
            pay1.SecurityCode();
            waiting();
            pay1.paymentBTNClick();
            waiting();
            pay1.cardGetText();
            waiting();
        }


        @AfterClass
        public static void afterClass() throws InterruptedException {
            System.out.println("afterClass");
            test.log(Status.INFO, "@After test " + "After test method");
            driver.quit();
            // build and flush report
            extent.flush();
            Thread.sleep(5000);

        }
//
public void waiting() throws InterruptedException {
    Thread.sleep(3000);
}
// פונקציה של קריאה מקובץ xml
private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
    File configXmlFile = new File(Constants.CONFIG_FILE);
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
// פונקציה של צילום מסך עבור הקובץ תיעוד
private static String takeScreenShot(String ImagesPath) {
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    File destinationFile = new File(ImagesPath+".png");
    try {
        FileUtils.copyFile(screenShotFile, destinationFile);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    return ImagesPath+".png";
}
}
