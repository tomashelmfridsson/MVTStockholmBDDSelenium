package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisStepdefs {
    @Given("I am on page {string}")
    public void iAmOnPage(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}
