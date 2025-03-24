package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TricentisStepdefs {
    WebDriver driver;

    @Given("I am on page {string}")
    public void iAmOnPage(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("I go to menu {string}")
    public void iGoToMenu(String name) {
        driver.findElement(By.cssSelector(".top-menu [href='/"+name.toLowerCase()+"']"))
                .click();
    }

    @Then("I see the book {string}")
    public void iSeeTheBook(String name) {
        WebElement product = driver.findElement(By
                .cssSelector(".product-item .details [href='/"+name.toLowerCase()+"']"));
        assertEquals(name,product.getText());
    }
}
