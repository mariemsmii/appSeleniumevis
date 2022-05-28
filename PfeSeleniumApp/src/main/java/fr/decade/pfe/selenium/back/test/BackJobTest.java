package fr.decade.pfe.selenium.back.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BackJobTest {
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void jobSel() {
	    // Test name: jobSel
	    // Step # | name | target | value
	    // 1 | open | /backoffice/ | 
	    driver.get("https://localhost:9002/backoffice/");
	    // 2 | setWindowSize | 1848x948 | 
	    driver.manage().window().setSize(new Dimension(1848, 948));
	    // 3 | click | id=gEuPmt0 | 
	    driver.findElement(By.id("gEuPmt0")).click();
	    // 4 | click | id=gEuPn52 | 
	    driver.findElement(By.id("gEuPn52")).click();
	    // 5 | click | id=gEuPm82 | 
	    driver.findElement(By.id("gEuPm82")).click();
	    // 6 | click | id=gEuPa02-cave | 
	    driver.findElement(By.id("gEuPa02-cave")).click();
	    // 7 | runScript | window.scrollTo(0,0) | 
	    js.executeScript("window.scrollTo(0,0)");
	    // 8 | click | id=gEuPce2 | 
	    driver.findElement(By.id("gEuPce2")).click();
	    // 9 | click | id=gEuPgw2 | 
	    driver.findElement(By.id("gEuPgw2")).click();
	    // 10 | click | id=gEuP4n | 
	    driver.findElement(By.id("gEuP4n")).click();
	    // 11 | click | id=gEuPkf2 | 
	    driver.findElement(By.id("gEuPkf2")).click();
	    // 12 | runScript | window.scrollTo(0,0) | 
	    js.executeScript("window.scrollTo(0,0)");
	    Assert.assertEquals(driver.findElement(By.id("eZHQxcl-real")).getText(), "TERMINE");
	    Assert.assertEquals(driver.findElement(By.id("eZHQgdl-real")).getText(), "REUSSI");
	  }

}
