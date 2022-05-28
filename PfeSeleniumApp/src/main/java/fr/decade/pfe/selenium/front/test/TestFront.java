package fr.decade.pfe.selenium.front.test;

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

public class TestFront {
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
	  public void frontTest() {
	    // Test name: FrontTest
	    // Step # | name | target | value
	    // 1 | open | /powertools/en/USD/login | 
	    driver.get("https://powertools.local:9002/powertools/en/USD/login");
	    // 2 | setWindowSize | 1332x912 | 
	    driver.manage().window().setSize(new Dimension(1332, 912));
	    // 3 | click | id=j_username | 
	    driver.findElement(By.id("j_username")).click();
	    // 4 | type | id=j_password | 123456
	    driver.findElement(By.id("j_password")).sendKeys("123456");
	    // 5 | type | id=j_username | william.hunter@rustic-hw.com
	    driver.findElement(By.id("j_username")).sendKeys("william.hunter@rustic-hw.com");
	    // 6 | click | css=.btn-primary | 
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	    // 7 | click | css=.yCmsComponent > .myAccountLinksHeader | 
	    driver.findElement(By.cssSelector(".yCmsComponent > .myAccountLinksHeader")).click();
	    // 8 | click | linkText=Quotes | 
	    driver.findElement(By.linkText("Quotes")).click();
	    // 9 | click | linkText=Quote 23150000 | 
	    driver.findElement(By.linkText("Quote 23150000")).click();
	    // 10 | click | name=action | 
	    driver.findElement(By.name("action")).click();
	    // 11 | click | linkText=23150000 | 
	    driver.findElement(By.linkText("23150000")).click();
	    // 12 | click | linkText=23150000 | 
	    driver.findElement(By.linkText("23150000")).click();
	    // 13 | click | css=.breadcrumb > li:nth-child(2) > a | 
	    driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(2) > a")).click();
	    // 14 | click | linkText=Quote 21310000 | 
	    driver.findElement(By.linkText("Quote 21310000")).click();
	    // 15 | click | name=action | 
	    driver.findElement(By.name("action")).click();
	    // 16 | click | css=.breadcrumb > li:nth-child(2) > a | 
	    driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(2) > a")).click();
	    // 17 | click | css=.btn-primary | 
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	    // 18 | click | linkText=23100000 | 
	    driver.findElement(By.linkText("23100000")).click();
	    // 19 | click | linkText=23100000 | 
	    driver.findElement(By.linkText("23100000")).click();
	    // 20 | click | linkText=23100000 | 
	    driver.findElement(By.linkText("23100000")).click();
	    // 21 | click | css=.yCmsComponent > .myAccountLinksHeader | 
	    driver.findElement(By.cssSelector(".yCmsComponent > .myAccountLinksHeader")).click();
	    // 22 | click | linkText=Quotes | 
	    driver.findElement(By.linkText("Quotes")).click();
	    // 23 | click | css=.responsive-table-item:nth-child(5) .btn | 
	    driver.findElement(By.cssSelector(".responsive-table-item:nth-child(5) .btn")).click();
	    Assert.assertEquals(driver.findElement(By.id("status-23150000")).getText(), "Ordered");
	    Assert.assertEquals(driver.findElement(By.id("status-21310000")).getText(), "buyer Rejected");
	    Assert.assertEquals(driver.findElement(By.id("status-23100000")).getText(), "Ordered");
	    Assert.assertEquals(driver.findElement(By.id("status-21300000")).getText(), "buyer Rejected");
	  }

}
