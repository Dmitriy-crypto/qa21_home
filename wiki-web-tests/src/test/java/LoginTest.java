import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

  @Test
  public void loginTest() {
    //init login
    click(By.id("pt-login"));
    //fill login form
    click(By.id("wpName1"));
    driver.findElement(By.id("wpName1")).clear();
    driver.findElement(By.id("wpName1")).sendKeys("ghjhgjgjh@jhjhjhk.com");

    click(By.id("wpPassword1"));
    driver.findElement(By.id("wpPassword1")).clear();
    driver.findElement(By.id("wpPassword1")).sendKeys("123455678G");
    //confirm login

    click(By.name("wploginattempt"));
  }


}
