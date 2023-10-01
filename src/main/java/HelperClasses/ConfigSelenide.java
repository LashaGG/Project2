package HelperClasses;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@Listeners({SoftAsserts.class})
public abstract class ConfigSelenide implements ITestListener {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot(Selenide.webdriver().object());
    }

    protected String browser;
    protected int waitSeconds;
    protected SoftAssert softAssert;

    public ConfigSelenide() {
        this(20, "chrome");
    }

    public ConfigSelenide(int waitSeconds, String browser) {
        this.waitSeconds = waitSeconds;
        this.browser = browser;
    }

    @BeforeSuite(alwaysRun = true)
    public void configureSelenide() {
        Configuration.timeout = waitSeconds * 1000L;
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.reopenBrowserOnFail = true;
        Configuration.fastSetValue = true;
        Configuration.reportsFolder = "src/main/resources/Reports";
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.browserSize = "1920x1080";


        setUpWebDriver(browser);
    }

    protected void setUpWebDriver(String browser) {
        switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver().setup();
            case "firefox" -> WebDriverManager.firefoxdriver().setup();
            case "edge" -> WebDriverManager.edgedriver().setup();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        Configuration.browser = browser;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        softAssert = new SoftAssert();
        setUpWebDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }


}