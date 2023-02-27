package clrAutomation;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstAoutomationProcess1 {
    WebDriver driver;

    @BeforeClass
//    public void setDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("/app.taxon.co.il/admin/tests/tomer.php");
        // driver.get("https://taxon.co.il");
        //driver.get("https://www.lambdatest.com/selenium-playground/");
   // }

    @AfterClass
    public void tearDown() {
        //  driver.close();
//        driver.quit();
    }

    @Test(priority = 2)
    public void shidurShaam1stStep() throws InterruptedException {
        //Action Class enables to perform actions with the mouse ore the keyboard.
        Actions actions = new Actions(driver);
        //Soft assert enables to check things without damaging the whole test process
        SoftAssert softAssert = new SoftAssert();



    }
}
