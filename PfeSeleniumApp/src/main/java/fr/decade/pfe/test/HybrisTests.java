package fr.decade.pfe.test;
/*
 * © 2017, © 2018, © 2019 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.decade.pfe.helper.HttpsHelper;
import fr.decade.pfe.quote.fils.CreateCsvFileForQuotes;

/**
 * These tests check on your progress thru hybris123
 */
@ManagedBean
public class HybrisTests {
	private static final Logger LOG = LoggerFactory.getLogger(HybrisTests.class);
	private WebDriver driver;
	private Map<String, Object> vars;
	private JavascriptExecutor js;
	private static Wait<WebDriver> wait;
	CreateCsvFileForQuotes createCsvFileForQuotes = new CreateCsvFileForQuotes();
	String id5 = createCsvFileForQuotes.getId5();
	String id2 = createCsvFileForQuotes.getId2();
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/mariem/Téléchargements/geckodriver");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		HttpsHelper.allowHttps();
	}

	@After
	public void tearDown() {
		// driver.close();
		driver.quit();
	}

	@Test
	public void backTest() {
		WebDriver driver = getDriver();
		JavascriptExecutor js = getJs();
		// Test name: bk
		// Step # | name | target | value
		// 1 | open | /backoffice/login.zul |
		driver.get("https://localhost:9002/backoffice/login.zul");
		pauseMS(4000);
		// 2 | setWindowSize | 1332x912 |
		driver.manage().window().setSize(new Dimension(1909, 1800));
		pauseMS(4000);
		// 3 | click | id=eNqXn |
		driver.findElement(By.name("j_username")).click();
		// 4 | type | id=eNqXn | admin
		driver.findElement(By.name("j_username")).sendKeys("admin");
		// 5 | click | id=eNqXs |
		driver.findElement(By.name("j_password")).click();
		// 6 | type | id=eNqXs | nimda
		driver.findElement(By.name("j_password")).sendKeys("nimda");
		pauseMS(8000);
		driver.findElement(By.className("z-select")).click();
	    // 8 | select | id=d0IQf | label=English
	    {
	      WebElement dropdown = driver.findElement(By.className("z-select"));
	      dropdown.findElement(By.xpath("//option[. = 'English']")).click();
	    }
	    pauseMS(8000);
		// 7 | click | id=eNqXh |
		driver.findElement(By.className("login_btn")).click();
		pauseMS(8000);
		driver.findElement(By.className("yw-explorerTree-filterTextbox")).click();
		pauseMS(8000);
		driver.findElement(By.className("yw-explorerTree-filterTextbox")).sendKeys("cronjobs");
		pauseMS(10000);
		driver.findElement(By.cssSelector("tr[title=\"CronJobs\"]")).click();
		pauseMS(4000);
		driver.findElement(By.className("z-bandbox-input")).click();
		pauseMS(8000);
		driver.findElement(By.className("z-bandbox-input")).sendKeys("pfe");
		driver.findElement(By.className("yw-textsearch-searchbutton")).click();
		pauseMS(10000);
		driver.findElement(By.className("z-listcell-content")).click();
		pauseMS(6000);
		driver.findElement(By.cssSelector("img[title=\"Run CronJob\"]")).click();
		pauseMS(7000);
		driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
		pauseMS(9000);
		driver.findElement(By.xpath("//button[contains(text(), 'Refresh')]")).click();
		pauseMS(18000);
		//Assert.assertEquals(driver.findElement(By.className("ye-com_hybris_cockpitng_editor_defaultenum")).getText(), "SUCCESS");
		//Assert.assertEquals(driver.findElement(By.id("eZHQgdl-real")).getText(), "REUSSI");
		Assert.assertNotNull(driver.findElement(By.cssSelector("input[value=\"SUCCESS\"]")));
		Assert.assertNotNull(driver.findElement(By.cssSelector("input[value=\"FINISHED\"]")));
	}

	@Test
	public void frontTest() {
		// WebDriver driver = getDriver();
		// Test name: FrontTest
		// Step # | name | target | value
		// 1 | open | /powertools/en/USD/login |
		driver.get("https://powertools.local:9002/powertools/en/USD/login");
		// 2 | setWindowSize | 1332x912 |
		pauseMS(4000);
		driver.manage().window().setSize(new Dimension(1909, 1800));
		// 3 | click | id=j_username |
		pauseMS(4000);
		driver.findElement(By.id("j_username")).click();
		// 4 | type | id=j_password | 123456
		driver.findElement(By.id("j_password")).sendKeys("123456");
		// 5 | type | id=j_username | william.hunter@rustic-hw.com
		driver.findElement(By.id("j_username")).sendKeys("william.hunter@rustic-hw.com");
		// 6 | click | css=.btn-primary |
		pauseMS(2000);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		// 7 | click | css=.yCmsComponent > .myAccountLinksHeader |
		driver.findElement(By.cssSelector(".yCmsComponent > .myAccountLinksHeader")).click();
		// 8 | click | linkText=Quotes |
		pauseMS(2000);
		driver.findElement(By.linkText("Quotes")).click();
		// 9 | click | linkText=Quote 23150000 |
		pauseMS(2000);
		driver.findElement(By.linkText("Quote 23150000")).click();
		// 10 | click | name=action |
		pauseMS(2000);
		driver.findElement(By.name("action")).click();
		// 11 | click | linkText=23150000 |
		pauseMS(4000);
		driver.findElement(By.linkText("79732180")).click();
		pauseMS(4000);
		// 12 | click | linkText=23150000 |
		driver.findElement(By.linkText("79732180")).click();
		pauseMS(2000);
		// 13 | click | css=.breadcrumb > li:nth-child(2) > a |
		driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(2) > a")).click();
		// 14 | click | linkText=Quote 21310000 |
		driver.findElement(By.linkText("Quote 21310000")).click();
		// 15 | click | name=action |
		driver.findElement(By.name("action")).click();
		pauseMS(2000);
		// 16 | click | css=.breadcrumb > li:nth-child(2) > a |
		driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(2) > a")).click();
		pauseMS(2000);
		// 17 | click | css=.btn-primary |
		driver.findElement(By.cssSelector(".btn-primary")).click();
		// 18 | click | linkText=23100000 |
		driver.findElement(By.linkText("56265000")).click();
		// 19 | click | linkText=23100000 |
		driver.findElement(By.linkText("56265000")).click();
		pauseMS(2000);
		// 20 | click | linkText=23100000 |
		driver.findElement(By.linkText("56265000")).click();
		// 21 | click | css=.yCmsComponent > .myAccountLinksHeader |
		driver.findElement(By.cssSelector(".yCmsComponent > .myAccountLinksHeader")).click();
		pauseMS(2000);
		// 22 | click | linkText=Quotes |
		driver.findElement(By.linkText("Quotes")).click();
		// 23 | click | css=.responsive-table-item:nth-child(5) .btn |
		driver.findElement(By.cssSelector(".responsive-table-item:nth-child(5) .btn")).click();
		Assert.assertEquals(driver.findElement(By.id("status-23150000")).getText(), "Ordered");
		Assert.assertEquals(driver.findElement(By.id("status-21310000")).getText(), "buyer Rejected");
		Assert.assertEquals(driver.findElement(By.id("status-23100000")).getText(), "Ordered");
		Assert.assertEquals(driver.findElement(By.id("status-21300000")).getText(), "buyer Rejected");
	}
	public static void pauseMS(long... pause) {
		try {
			if (pause.length == 0) {
				Thread.sleep(6000);
			} else {
				Thread.sleep(pause[0]);
			}
		} catch (InterruptedException e) {
			LOG.error("Thread interrupted.", e);
		}
	}

	public WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "/home/mariem/Téléchargements/geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public JavascriptExecutor getJs() {
		if (js == null) {
			js = (JavascriptExecutor) getDriver();
		}
		return js;
	}

	public void setJs(JavascriptExecutor js) {
		this.js = js;
	}

}