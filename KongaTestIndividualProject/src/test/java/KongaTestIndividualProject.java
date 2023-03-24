import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaTestIndividualProject {
    private By ModalButton = By.xpath("//]/div/div[2]/div[3]/div[2]/div/button");
    private By ModalCardbutton = By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div/span[1]");
    private By ModalCardNumber = By.id("card-number");
    private By ModalDate = By.id("expiry");
    private By ModalCVV = By.id("id=\"cvv\"");
    private By ModalPayNowButton = By.id("validateCardForm");
    private By CloseIframe = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");

    //import the Konga webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        //1. Open the Chrome browser
        driver = new ChromeDriver(option);
        //2. Input the Konga Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        // Test1. Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains(" https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Login/ Signup button to open the Login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void PositiveLogin() throws InterruptedException {
        //Test2. Verify that user can Log In successfully
        //1. Input email address on the email address field
        driver.findElement(By.id("username")).sendKeys("tosin.mo@proton.me");
        //2. Locate the password field and input password on the password field
        driver.findElement(By.id("password")).sendKeys("password");
        //3. Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void ClickOnComputersAndAccessories() throws InterruptedException {
        //Test 3. Verify that when user clicks on the Laptop button, the user is directed to the Computer and accessories page
        //4. From the categories, click on the computers and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct Computer and Accessories Page");
        else
            //Fail
            System.out.println("Wrong Computer and Accessories Page");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void LaptopSubcategory() throws InterruptedException {
        //Test 4. Verify that user can click on the laptop subcategory
        //5. Click on the Laptop Subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct Category");
        else
            //Fail
            System.out.println("Wrong Category");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void AppleMacbook() throws InterruptedException {
        //Test 5. Verify that when User clicks on AppleMacbook, different options come up
        //6. Click on the Apple Macbooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct Selection");
        else
            //Fail
            System.out.println("Wrong Selection");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void AddItemToCart() throws InterruptedException {
        //Test 6. Verify that user can add an item to the cart
        //7. Add an Item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[3]/div/div/div[2]/form/div[3]/button")).click();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct Item");
        else
            //Fail
            System.out.println("Wrong Item");
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void ClickOnMyCart() throws InterruptedException {
        //Test 7. Verify that user can click on My Cart button
        //8. Click on my cart to view order
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct CartOverview");
        else
            //Fail
            System.out.println("Wrong CartOverview");
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void clickOnCheckout() throws InterruptedException {
        //9. Click on the Checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void ChangeAddress() throws InterruptedException {
        //Test 8. Verify that user can click on the "Change" button and proceed to the next page
        //10. Click on the Change Button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void AddDeliveryAddress() throws InterruptedException {
        //Test 9. Verify that user can click on "Add Delivery Address" and click on "Select Address"
        //11. Click on the Add Delivery Address Button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        // 12. Click on Select Address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void UseThisAddress() throws InterruptedException {
        //Test 10. Verify that user can click on the Use This Address button
        //13. Click on Use This Address Button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 10)
    public void clickonPayNow() throws InterruptedException {
        //Test 11. Verify that user can click on Pay Now button
        // 14 From the Payment Options, click on "Pay Now" to enable "Continue to Payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 11)
    public void ContinueToPayment() throws InterruptedException {
        //Test 12. Verify that user can click on the continue to payment button
        // 15 Click on Continue to Payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 12)
    public void ClickCard() throws InterruptedException {
        //Test 13. Verify that user can select the card option
        // 16 click card
        click(ModalButton);

    }

    @Test(priority = 13)
    public void InputInvalidCardDetails() throws InterruptedException {
        //Test 14. From the Payment Options, click on "Pay Now" to enable "Continue to Payment" button
        //17 Input invalid Card Number
        setText(ModalCardNumber, 546356575);
        setText(ModalDate, 92 / 75);
        setText(ModalCVV, 619);
        click(ModalPayNowButton);
        String expectedUrl = "https://www.konga.com/checkout/complete-order";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Invalid Card Number");
        else
            //Fail
            System.out.println("Valid Card Number");
        Thread.sleep(5000);
    }

    @Test(priority = 14)
    public void CloseIFrame() throws InterruptedException {
        //18. close the iframe that displays the input card modal
        click(CloseIframe);
        Thread.sleep(5000);
    }

    private void setText(By modalCardNumber, int i) {
    }

    private void click(By modalButton) {
    }

    @AfterTest
    public void closeBrowser() {
        //Quit browser
        driver.quit();
    }
}