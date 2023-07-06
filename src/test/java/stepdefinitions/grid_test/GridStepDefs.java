package stepdefinitions.grid_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class GridStepDefs {

    WebDriver driver;
    @Given("user goes to app with chrome")
    public void user_goes_to_app_with_chrome() throws MalformedURLException {
        //RemoteDriver objesi oluştur --> new URL (), new ChromeOptions()
        driver = new RemoteWebDriver(new URL(" http://192.168.0.17:4444"), new ChromeOptions());
        //gerisi selenium
        driver.get("https://www.bluerentalcars.com/");
    }
    @When("verify the title is {string}")
    public void verify_the_title_is(String title) {
        assertEquals(title,driver.getTitle());

    }
    @Then("close the driver")
    public void close_the_driver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

    @Given("user goes to app with edge")
    public void userGoesToAppWithEdge() throws MalformedURLException {
        //RemoteDriver objesi oluştur --> new URL (), new EdgeOptions()
        driver = new RemoteWebDriver(new URL(" http://192.168.0.17:4444"), new EdgeOptions());
        //gerisi selenium
        driver.get("https://www.bluerentalcars.com/");
    }
}
