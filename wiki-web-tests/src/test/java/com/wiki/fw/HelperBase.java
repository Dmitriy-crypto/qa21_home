package com.wiki.fw;

import com.google.common.io.Files;
import com.wiki.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {
  WebDriver driver;
  Logger logger = LoggerFactory.getLogger(HelperBase.class);
  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void waitForElementAndType(By locator, int time, String text) {
    waitForElementAndClick(locator, time);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void waitForElementAndClick(By locator, int time) {
    new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size()>0;
  }
public void takeScreenshot() throws IOException {
  File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File screenshot = new File("screenshot"+ System.currentTimeMillis()+".png");
  Files.copy(tmp, screenshot);
  logger.info("screenshot is: " + screenshot);
}
}
