import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchTests extends  TestBase {

  @Test
 public void searchWikiTestJava(){
      typeRequest("java");
    clickGoButton();
    //pause
 }

  @Test
  public void searchWikiTestQA(){
    typeRequest("QA");
    clickGoButton();
    //pause
  }

}
