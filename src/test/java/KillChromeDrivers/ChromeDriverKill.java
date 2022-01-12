package KillChromeDrivers;

import org.testng.annotations.Test;

import java.io.IOException;

public class ChromeDriverKill {


    @Test
    public void kill() throws IOException {
        Process chromeProcess = (Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f"));
    }
}
