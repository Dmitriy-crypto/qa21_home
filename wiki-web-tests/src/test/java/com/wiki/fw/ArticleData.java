package com.wiki.fw;

public class ArticleData {
  private  String request;

  public ArticleData setRequest(String request) {
    this.request = request;
    return this;
  }

  public String getRequest() {
    return request;
  }

  @Override
  public String toString() {
    return "ArticleData{" +
            "request='" + request + '\'' +
            '}';
  }
}
