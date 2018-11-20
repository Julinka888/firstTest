import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.stream.Collectors;
import java.util.List;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;
import java.time.Duration;
import org.openqa.selenium.By.ByXPath;


public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();//создать объект драйвера для Сhrome, чтобы запустить браузер мн
        //try {
       driver.get("https://www.airportparkingreservations.com/");
       driver.findElement(By.id("blended_searchbox")).findElement(By.name("airport")).sendKeys("LAX");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
               .pollingEvery(Duration.ofSeconds(1))
              .ignoring(NoSuchElementException.class);
       wait.until(new Function<WebDriver, WebElement>() {
         public WebElement apply(WebDriver driver) {
              return driver.findElement(By.id("blended_searchbox")).findElement(By.className("name"));
           }
        });

      driver.findElement(By.id("blended_searchbox")).findElement(By.className("name")).click();
       driver.findElement(By.id("blended_searchbox")).findElement(By.name("checkindate")).click();

        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait1.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("blended_searchbox")).findElement(By.name("checkindate"));
            }
        });

        driver.findElement(By.className("month1")).findElement(By.cssSelector("body > div.date-picker-wrapper.no-gap.two-months.date-picker-date1 > div.month-wrapper > table.month1 > tbody > tr:nth-child(5) > td:nth-child(1) > div")).click();
       Thread.sleep(2000);
       driver.findElement(By.className("month2")).findElement(By.cssSelector("body > div.date-picker-wrapper.no-gap.two-months.date-picker-date2 > div.month-wrapper > table.month2 > tbody > tr:nth-child(2) > td:nth-child(5) > div")).click();
       Thread.sleep(2000);
        driver.findElement(By.id("blended_searchbox")).findElement(By.cssSelector("#blended_searchbox > div.row.inputs > div.col-sm-12.col-xl.p-0.submit > button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("search_results")).findElement(By.xpath("//*[@id=\"search_list_section\"]/div[2]/div/div[1]/div/div[3]/a")).click();
           // List<String> names = driver.findElement(By.id("blended_searchbox")).findElements(By.className("name")).stream().map(WebElement::getText).collect(Collectors.toList()); //найти выпадающий список и преобразовать его в массив
           // System.out.println(names);//должен вывести необходимую строку
            //driver.quit();
           // if (!names.contains("Los Angeles (LAX)")) {
               // throw new NoSuchElementException("Don't work");
           // }
       // } catch (NoSuchElementException e) {
          //  System.out.println("problem");
        //} finally {
           // driver.quit();
            //System.out.println("finally");
        }
    }
//}

