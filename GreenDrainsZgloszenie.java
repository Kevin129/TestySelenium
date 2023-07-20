package Testy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GreenDrainsZgloszenie {

    @Test
    public void testPage() {
        for (int i = 0; i < 1; i++) {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.greendrains.pl/");
            driver.manage().window().maximize();

            WebElement kontaktTab = driver.findElement(By.linkText("Kontakt"));
            kontaktTab.click();

            By nameID = By.id("form-field-name");
            WebElement textName = driver.findElement(nameID);
            textName.sendKeys("Jan Kowalski");

            By email = By.id("form-field-email");
            WebElement textEmail = driver.findElement(email);
            textEmail.sendKeys("Jan700460@gmail.com");

            By wiadomosc = By.id("form-field-message");
            WebElement textWiadomosc = driver.findElement(wiadomosc);
            textWiadomosc.sendKeys("Dzień dobry, chciałem państwa pozdrowić serdecznie");

            /*By wyslij = By.className("elementor-button-text");
            WebElement kliknijWyslij = driver.findElement(wyslij);
            kliknijWyslij.click();

            driver.close();*/
        }
    }
}



