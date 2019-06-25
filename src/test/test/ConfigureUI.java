package test.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ConfigureUI {

    //Clicking the Advance button

    public static void ClickAdvance(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(("window.scrollBy(0,2000)"));
        driver.findElement(By.xpath("//a[contains(text(),'Switch to advanced mode')]")).click();

    }

    //Set the x-ping : value , And text area.

    public static void Setinfo(WebDriver driver) {

        driver.findElement(By.xpath("//input[@class=\"span3\"]")).sendKeys(ConstantList.TextBox1);
        driver.findElement(By.xpath("//input[@class=\"span4\"]")).sendKeys(ConstantList.TextBox2);
        driver.findElement(By.xpath("//textarea[@class='ace_text-input']")).sendKeys(ConstantList.TextBoxJson);

    }

    //Click on the "Generate my http button"

    public static void GenerateClick(WebDriver driver) {

        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();

    }

    //Using Scroll to get back to the upper side of the page

    public static void ScrollUp(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("window.scrollBy(0,-2000)"));

    }
}