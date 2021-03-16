package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
public class Test12 {
    WebDriver driver;
    SoftAssert softAssert;
    Actions actions;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        actions = new Actions(driver);
    }
    @Test
    public void Test1() throws InterruptedException {

        driver.get("http://icehrm-open.gamonoid.com/login.php?");
        WebElement userName= driver.findElement(By.xpath("//input[@class='form-control']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();
        WebElement switchButton=driver.findElement(By.xpath("//header/nav[1]/div[2]/ul[1]/li[3]/a[1]/i[1]"));
        switchButton.click();
        Thread.sleep(2000);
        WebElement currentText=driver.findElement(By.xpath("//h4[@id='myModalLabel']"));
        String expected="Switch Employee";
        Assert.assertEquals(currentText.getText(),expected);
        Thread.sleep(750);
        WebElement selectText=driver.findElement(By.xpath("//p[text()='Select The Employee to Switch Into']"));
        String expectedSelectText="Select The Employee to Switch Into";
        Assert.assertTrue(selectText.isDisplayed());
        System.out.println(selectText.getText());
        Thread.sleep(1000);
        WebElement searchBox =driver.findElement(By.cssSelector("#s2id_switch_emp"));
        searchBox.click();
        Thread.sleep(1000);
        WebElement lalaLamees = driver.findElement(By.xpath("// li[@class = 'select2-results-dept-0 select2-result select2-result-selectable']" +
                " //*[contains(text(), 'Lala Lamees')]"));
        lalaLamees.click();
        WebElement switchButton2=driver.findElement(By.xpath("//button[.='Switch']"));
        switchButton2.click();
        //Assert.assertTrue(lalaLamees.isDisplayed());
        Thread.sleep(2000);
        WebElement lalaLamees1=driver.findElement(By.xpath("//a[.='Lala Lamees']"));
        Assert.assertTrue(lalaLamees1.isDisplayed());
        Assert.assertEquals(lalaLamees1.getText(),"Lala Lamees");
        WebElement change2=driver.findElement(By.xpath("//body/div[2]/aside[1]/section[1]/div[2]/div[2]/a[1]"));
        String correctText="Changed To";
        Assert.assertEquals(change2.getText(),correctText);
        WebElement color=  driver.findElement(By.xpath("//i[@class='fa fa-circle text-warning']"));
        String colorRgba = color.getCssValue("color");
        String expectedRgba = "rgba(138, 109, 59";
        Assert.assertTrue(colorRgba.contains(expectedRgba));
        sout
            
    }
}



