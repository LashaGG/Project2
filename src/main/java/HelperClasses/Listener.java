package HelperClasses;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public abstract class Listener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        System.out.println("Screenshot was taken");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot(Selenide.webdriver().object());
    }


}
