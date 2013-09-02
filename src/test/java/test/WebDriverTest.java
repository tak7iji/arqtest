package test;

import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class WebDriverTest {
 
    protected static final String USERNAME = "demo";
    protected static final String PASSWORD = "demo";
 
    @ArquillianResource
    URL contextPath;
 
    @Drone
    WebDriver driver;
 
    /**
     * Creates a testing WAR of using ShrinkWrap
     *
     * @return WebArchive to be tested
     */
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createDeployment();
    }
 
    @Test
    @InSequence(1)
    public void login() {
        Assert.assertNotNull(driver);
        System.out.println("Driver: "+driver);
        System.out.println("Context Path: "+contextPath);
        LoginPage page = new LoginPage(driver, contextPath);
        page.login(USERNAME, PASSWORD);
    }
 
    @Test
    @InSequence(2)
    public void logout() {
        Assert.assertNotNull(driver);
        LoginPage page = new LoginPage(driver, contextPath);
        page.logout();
    }
}
