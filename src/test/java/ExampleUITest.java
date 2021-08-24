import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExampleUITest {

    @Test
    public void AddStringToForename(){
        WebDriver driver = new ChromeDriver();


        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/");

        WebElement forename = driver.findElement(By.id("forename"));

        forename.sendKeys("John");

    }
}
