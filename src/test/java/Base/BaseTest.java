package Base;

import com.Base.BasePage;
import com.BidderBoyPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.Base.BasePage.delay;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homepage;
    private String url = "https://demowebshop.tricentis.com/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homepage = new HomePage();


    }

    @AfterClass
    public void tearDown(){
        delay(3000);
        driver.quit();
    }


}

