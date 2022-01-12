import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

public class SmokeTests {

    @Test
    public void smokeTest1() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement adv = driver.findElement(By.id("interstitial-mega-wrapper"));
        JavascriptExecutor jseDisplay = driver;
        jseDisplay.executeScript("arguments[0].style='display: none';",adv);


        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        JavascriptExecutor jselenghtRoom = driver;
        jselenghtRoom.executeScript("arguments[0].value='6';", lengthRoom);


        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));
        JavascriptExecutor jsewidthRoom = (JavascriptExecutor) driver;
        jsewidthRoom.executeScript("arguments[0].value='4';", widthRoom);

        WebElement lengthLaminate = driver.findElement(By.name("calc_lamwidth"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='2000';", lengthLaminate);

        WebElement widthLaminate = driver.findElement(By.name("calc_lamheight"));
        JavascriptExecutor jsewl = (JavascriptExecutor) driver;
        jsewl.executeScript("arguments[0].value='200';", widthLaminate);

        WebElement packing = driver.findElement(By.name("calc_inpack"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='8';", packing);

        WebElement price = driver.findElement(By.name("calc_price"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='10';", price);

        WebElement layingDirectionOfLaminate = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirectionOfLaminate);
        select.selectByValue("toh");

        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        JavascriptExecutor jseoffsetRows = (JavascriptExecutor) driver;
        jseoffsetRows.executeScript("arguments[0].value= '400';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.name("calc_walldist"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '8';", indentFromTheWall);

        WebElement btn = driver.findElement(By.className("tocalc"));
        btn.click();

        WebElement square = driver.findElement(By.id("s_lam"));
        Assert.assertEquals(square.getText(), "23.84 м2.", "Площадь укладки отображается не верно.");

        WebElement countLaminate = driver.findElement(By.id("l_count"));
        Assert.assertEquals(countLaminate.getText(), "62 шт.", "Количество панелей отображается не верно.");

        WebElement countPack = driver.findElement(By.id("l_packs"));
        Assert.assertEquals(countPack.getText(), "8 шт.", "Количество упаковок отображается не верно.");

        WebElement priceLaminate = driver.findElement(By.id("l_price"));
        Assert.assertEquals(priceLaminate.getText(), "256 руб.", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.id("l_over"));
        Assert.assertEquals(remains.getText(), "2 шт.", "Остатки отображаются не верно.");

        WebElement segment = driver.findElement(By.id("l_trash"));
        Assert.assertEquals(segment.getText(), "10 шт.", "Отрезки отображаются не верно.");

        driver.quit();
    }
}
