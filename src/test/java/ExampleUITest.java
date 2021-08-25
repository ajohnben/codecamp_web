import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;



public class ExampleUITest {

    private WebDriver driver;

    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void AddStringToForename(){
        var homepage = new HomePage(driver);
        homepage.getWebDriver().get("https://d1iw6mb9di5l9r.cloudfront.net/");
        homepage.sendKeysToForenameInputTextField("John");
    }

    @Test
    public void CheckMainMenuLinks(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links);
        for(int i = 0; i<links.size(); i++){
            System.out.println();
            if(links.get(i).getAttribute("aria-label") != null){

            }
//            driver.navigate().to();
        }
    }

    @Test
    public void CheckIfLoginButtonAlertWorksTest(){
        var homepage = new HomePage(driver);
        homepage.getWebDriver().get("https://d1iw6mb9di5l9r.cloudfront.net/");
        homepage.clickLoginButton();
    }

    @Test
    public void CheckFormValidationStatusTest(){

        var homepage = new HomePage(driver);
        homepage.getWebDriver().get("https://d1iw6mb9di5l9r.cloudfront.net/");
        homepage.clickUserIcon();
        homepage.clickLoginModalLoginButton();
        var warningTexts = homepage.getValidationWarningText();
        for(var messageElement: warningTexts){
            Assertions.assertEquals("Invalid user and password", messageElement.getText());
        }
    }
}
