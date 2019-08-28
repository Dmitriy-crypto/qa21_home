import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

  @Test
  public void loginTest() {
       initLogin();
      fillLoginForm("ghjhgjgjh@jhjhjhk.com", "123455678G");
      confirmLogin();
  }


}
