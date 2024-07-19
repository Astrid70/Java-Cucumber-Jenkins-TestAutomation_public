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

public class Login_Steps  {

    private WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("text")).sendKeys(username);
    }
    @And("I enter a password {word}")
    public void i_enter_a_password_webdriver123(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message_validation_succeeded(String expectedMessage) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, expectedMessage);

    }

}
