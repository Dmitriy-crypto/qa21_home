package com.wiki.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
  EventFiringWebDriver driver;
  ArticleHelper article;
  SessionHelper session;
  String browser;

public static  class MyListener extends AbstractWebDriverEventListener{
  public MyListener() {
    super();
  }
  Logger logger = LoggerFactory.getLogger(MyListener.class);

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
   // super.beforeFindBy(by, element, driver);
    logger.info("Search element " +by);
  }
  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {
   // super.afterFindBy(by, element, driver);
    System.out.println(by + " found!");
  }
  @Override
  public void onException(Throwable throwable, WebDriver driver) {
   // super.onException(throwable, driver);
    logger.error("\n!!Error!! " + throwable);
  }
}
  public ApplicationManager(String browser) {
    this.browser = browser;
  }
  public void init() {
    if (browser.equals(BrowserType.CHROME)){
      driver = new EventFiringWebDriver(new ChromeDriver());
    } else  if (browser.equals(BrowserType.FIREFOX)){
      driver = new EventFiringWebDriver(new FirefoxDriver());
    } else if(browser.equals(BrowserType.EDGE)){
      driver = new EventFiringWebDriver(new EdgeDriver());
    }

    driver.register(new MyListener());
    //add default wait for WebElement
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    //open site
    session = new SessionHelper(driver);
    driver.get("https://en.wikipedia.org");
    article = new ArticleHelper(driver);
  }

  public void stop() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
  }

  public ArticleHelper getArticle() {
    return article;
  }

  public SessionHelper getSession() {
    return session;
  }
}
