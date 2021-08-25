import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HomePage {

    public final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }

    public void sendKeysToForenameInputTextField(String forename){
        driver.findElement(By.id("forename")).sendKeys(forename);
    }

    public void clickLoginButton(){
        driver.findElement(By.cssSelector("#loginButton.primary")).click();
    }

    public String getAlertLoginTextMessage(){
        return driver.findElement(By.className("alert-message")).getText();
    }

    public void clickUserIcon(){
        driver.findElement(By.cssSelector("[aria-label=\"users\"]")).click();
    }

    public void clickLoginModalLoginButton(){
        WebElement loginBtn = driver.findElement(By.cssSelector("div.v-card__actions>#loginButton"));
        waitForVisibility(loginBtn);
        loginBtn.click();
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> getValidationWarningText(){
        List<WebElement> validationWarningText = driver.findElements(By.cssSelector("div.v-messages__message"));
        new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(validationWarningText.get(0)));

        return validationWarningText;
    }


}
