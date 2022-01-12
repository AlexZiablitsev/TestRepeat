package KillChromeDrivers;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChromeDriverKill {


    @Test
    public void kill() throws IOException {

//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("drivers/KillChromeDriver.bat").getFile());
//        String absolutePath = file.getAbsolutePath();
//        String directoryPath =file.getParent();
//        Process p = Runtime.getRuntime().exec(absolutePath,null, new File(directoryPath));
        Process chromeProcess = (Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f"));
    }
}
