import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa .selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static io.ous.jtoml.impl.Token.TokenType.Key;


/** 1. Verify the user input the right url and his on the right webpage
 *	2. Verify that when user clicks on the signup button, the user is directed to the
 signup page
 *	3. Verify that user cannot sign up with username less than 3 characters
 *	4. Verify user cannot sign up with invalid email address
 *	5. Verify user cannot log in with password less than or equal to one character
 *	6. Verify user cannot sign up with either/all of the fields blank
 *	7. Verify that user is successfully signed up when valid details are inputted.
 *	8. Verify that User1 item is present on the item list page.
 *	9. Verify that the item searched for on the User1 page is present.
 *	10. Verify that when the user logout, he/she is directed back to the home page
 **/
public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        //1. Open your Chrome browser
        driver = new ChromeDriver(option);

        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test1. Verify the user input the right url and is on the right webpage
        if(driver.getCurrentUrl().contains(" https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7.  Verify that user is successfully signed up when valid details are inputted.
        //Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("tosin63");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("tosin63@gmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9. Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //Test9. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct User1Page");
        else
            //Fail
            System.out.println("Wrong User1Page");
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void logoutSuccessfully(){
        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10: Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(expectedTitle.contains(actualTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
    }
    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3. Verify that user cannot sign up with username less than 3 characters
        //Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("12");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("12@12");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
        @AfterTest
        public void closeBrowser() {
            //Quit the browser
            driver.quit();
    }
}
