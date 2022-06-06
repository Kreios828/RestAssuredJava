package web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleWebTest {


    @Test
    public void checkWebTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Serjo\\IdeaProjects\\RestAssuredJava-master\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cbr-xml-daily.ru/");

        Thread.sleep(2000);

        driver.quit();

    }




}
