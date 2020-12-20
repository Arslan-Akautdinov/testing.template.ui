package fixture;


import common.ApplicationManager;
import io.github.bonigarcia.seljup.Options;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageClient;

import java.util.concurrent.TimeUnit;


@ExtendWith(SeleniumJupiter.class)
public class BasicTest {

    protected WebDriver driver;
    protected PageClient pages;

    @Options
    protected ChromeOptions chromeOptions = new ChromeOptions();{
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--ignore-certificate-errors");
    }

    @BeforeEach
    public void setUp(ChromeDriver driver)
    {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.pages = new PageClient(this.driver, new WebDriverWait(this.driver, 10));
        this.driver.get(ApplicationManager.config.url);
    }

}
