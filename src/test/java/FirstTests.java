import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FirstTests {
    @Test
    public void smokeTest1() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
        Thread.sleep(3000);
        WebElement height = driver.findElement(By.id("bmiVar1"));
        height.sendKeys("183");
        WebElement weight = driver.findElement(By.name("bmiVar2"));
        weight.sendKeys("58");
        WebElement calcBtn = driver.findElement(By.className("btn-calculate"));
        calcBtn.click();
        WebElement bmiNum = driver.findElement(By.id("AnswerBMI"));
        String bmiNumText = bmiNum.getText();

        WebElement status = driver.findElement(By.id("AnswerBMI1"));
        String statusText = status.getText();

        Assert.assertEquals(bmiNumText, "17.32", "Ваш индекс массы тела отображает неверное значение");
        Assert.assertEquals(statusText, "Недостаточной массе тела", "Не корректный статус");

        System.out.println(status.getTagName());
        System.out.println(status.getAttribute("id"));
        System.out.println(calcBtn.isDisplayed());
        System.out.println(calcBtn.isEnabled());
        System.out.println(calcBtn.isSelected());
        System.out.println(driver.findElementById("vk_comments").isDisplayed());

        driver.quit();
    }

    @Test
    public void smokeTest2() throws InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(3000);
        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select layingMethodLaminate = new Select(selectWebElement);
        layingMethodLaminate.selectByIndex(0);
        layingMethodLaminate.selectByValue("1");
        layingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");

        List<WebElement> list = driver.findElements(By.name("direction-laminate"));
        for (WebElement option : list) {
            if (option.getAttribute("value").equals("1")) {
                option.click();
            }
        }

        WebElement lengthOfRoom = driver.findElementById("ln_room_id");
        lengthOfRoom.clear();
        lengthOfRoom.sendKeys("500");

        WebElement wightOfRoom = driver.findElementById("wd_room_id");
        wightOfRoom.clear();
        wightOfRoom.sendKeys("400");

        WebElement lengthOfLaminate = driver.findElementById("ln_lam_id");
        lengthOfLaminate.clear();
        lengthOfLaminate.sendKeys("2000");

        WebElement widthOfLaminate = driver.findElementById("wd_lam_id");
        widthOfLaminate.clear();
        widthOfLaminate.sendKeys("200");

        WebElement calcBtn = driver.findElement(By.linkText("Рассчитать"));
        calcBtn.click();
        Thread.sleep(2000);
        WebElement resultLaminate = driver.findElement(By.xpath("//span[text() = '53']"));
        String resultLaminateText = resultLaminate.getText();
        WebElement resultPackage = driver.findElement(By.xpath("//span[text() = '8']"));
        String resultPackageText = resultPackage.getText();
        System.out.println(resultLaminateText);


        Assert.assertEquals(resultLaminateText, "53", "Требуемое количество досок ламината отображается не верно.");
        Assert.assertEquals(resultPackageText, "7", "‘Количество упаковок ламината отображается не верно.");


        driver.quit();
    }
}
