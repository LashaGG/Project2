package ConfigClasses;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.testng.SoftAsserts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@Listeners({SoftAsserts.class})
public abstract class SelenideConfig {

    protected String browser;
    protected int waitSeconds;
    protected SoftAssert softAssert;

    public SelenideConfig() {
        this(20, "chrome");
    }

    public SelenideConfig(int waitSeconds, String browser) {
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