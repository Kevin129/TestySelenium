package Testy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class WebsiteTest {
    @Test
    public void testStrony() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();

        //Pobranie adresu strony
        System.out.println(driver.getCurrentUrl());

        //Pobranie tytułu strony
        System.out.println(driver.getTitle());

        //Najechanie kursorem na tytuł strony
        Actions actions = new Actions(driver);
        WebElement tytul = driver.findElement(By.tagName("h1"));
        actions.moveToElement(tytul).perform();

        //Button (Kliknij mnie!)
        WebElement clickMe = driver.findElement(By.id("clickOnMe"));
        clickMe.click();
        //Zaakceptowanie alertu
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        //First name
        WebElement FirstName = driver.findElement(By.id("fname"));
        FirstName.sendKeys("Kevin");

        //Zlokalizowanie linku
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        //Wybór samochodu z selecta
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);

        List<WebElement> options = cars.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        cars.selectByVisibleText("Mercedes");

        //Akceptacja regulaminu
        WebElement akcpetacjaRegulaminu = driver.findElement(By.cssSelector("[type='checkbox']"));
        akcpetacjaRegulaminu.click();

        //Wybór płci
        WebElement wyborPlci = driver.findElement(By.cssSelector("[value='male']"));
        wyborPlci.click();

        //Nazwa użytkownika
        WebElement loginUzytkownika = driver.findElement(By.name("username"));
        loginUzytkownika.clear();
        loginUzytkownika.sendKeys("Man123");

        WebElement hasloUzytkownika = driver.findElement(By.name("password"));
        hasloUzytkownika.clear();
        hasloUzytkownika.sendKeys("Admin123");

        //Submit
        WebElement Submit = driver.findElement(By.cssSelector("[type='submit']"));
        Submit.click();
        //Akceptacja dwóch alertów
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        secondAlert.accept();

        //Pobranie obrazka
        WebElement image = driver.findElement(By.id("smileImage"));
        System.out.println(image);

        // Pobranie wszystkich elementów listy "ul"
        List<WebElement> ulElements = driver.findElements(By.id("container"));

        // Wypisanie zawartości wszystkich elementów listy "ul"
        for (WebElement ulElement : ulElements) {
            System.out.println("Zawartość listy ul:");
            System.out.println(ulElement.getText());

            //Screen
            /*TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("adres folderu ze sceenarmi"));*/

            driver.close();
        }
    }
}


