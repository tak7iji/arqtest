package test;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
 
    private static final By LOGGED_IN = By.xpath("//li[contains(text(),'Welcome')]");
    private static final By LOGGED_OUT = By.xpath("//li[contains(text(),'Goodbye')]");
 
    private static final By USERNAME_FIELD = By.id("loginForm:username");
    private static final By PASSWORD_FIELD = By.id("loginForm:password");
 
    private static final By LOGIN_BUTTON = By.id("loginForm:login");
    private static final By LOGOUT_BUTTON = By.id("loginForm:logout");
 
    private final WebDriver driver;
    private final URL contextPath;
 
    public LoginPage(WebDriver driver, URL contextPath) {
        this.driver = driver;
        this.contextPath = contextPath;
    }
 
    public void login(String name, String password) {
        System.out.println("Context Path: "+contextPath);
        driver.get(contextPath + "index.html");
        driver.findElement(USERNAME_FIELD).sendKeys(WebDriverTest.USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(WebDriverTest.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        System.out.println(driver.findElement(LOGGED_IN));
    }
 
    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
        System.out.println(driver.findElement(LOGGED_OUT));
    }
}
