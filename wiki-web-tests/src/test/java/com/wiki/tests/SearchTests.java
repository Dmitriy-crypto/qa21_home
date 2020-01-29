package com.wiki.tests;

import com.wiki.fw.ArticleData;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTests extends TestBase {


  @Test(priority = 2)
  public void searchWikiTestJava() {
    app.getArticle().typeRequest(new ArticleData().setRequest("java"));
    app.getArticle().clickGoButton();
 //   Assert.assertEquals(app.getArticle().getArticleTitle().toLowerCase(), "java".toLowerCase());
    //pause
  }

  @Test(priority = 1)
  public void searchWikiTestQA() throws IOException {
    app.getArticle().typeRequest(new ArticleData().setRequest("QA"));
    app.getArticle().clickGoButton();
  //  Assert.assertEquals(app.getArticle().getArticleTitle().toLowerCase(), "QA".toLowerCase());
    //pause
    app.getArticle().takeScreenshot();
  }

}
