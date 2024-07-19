package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import static Driver.DriverFactory.getDriver;


public class Contact_Us_Steps  {

//    private WebDriver driver;

 /*   @Before("@contact-us")
    public void setUp() {
      /* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=+");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);*/
 //       driver = new ChromeDriver();
 //       driver.manage().window().maximize();
 //   }

/*    @After(@contact_us)
    public void tearDown() {
        driver.quit();
    }*/

    private WebDriver driver = getDriver();

    public String generateRandomNumber()
    {
        return RandomString.make(5);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");

    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @And("I enter specific last name {word}")
    public void i_enter_specific_last_name_blogs(String lastName) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @And("I enter a specific email {word}")
    public void i_enter_a_specific_email_joe_blog_mail_com(String email) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }
    @And("I enter a specific comment  {string}")
    public void i_enter_a_specific_comment(String message) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(message);
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        // Write code here that turns the phrase above into concrete actions
       driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber());
    }

    @And("I enter unique last name")
    public void i_enter_unique_last_name() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber());
    }

    @And("I enter a unique email")
    public void i_enter_a_unique_email() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoMail" + generateRandomNumber() + "@gmail.com");
    }

    @And("I enter a comment")
    public void i_enter_a_comment() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test");
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
    }

    @Then("I should get a the successful contact us message")
    public void i_should_get_a_the_successful_contact_us_message() {
        // Write code here that turns the phrase above into concrete actions
        WebElement welcomeMesssage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(welcomeMesssage.getText(), "Thank You for your Message!");
    }

}
