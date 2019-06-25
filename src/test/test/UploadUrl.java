package test.test;

import org.openqa.selenium.WebDriver;

//Uploading the Chrome Driver

public class UploadUrl {

    public static void Upload(WebDriver driver) {


        driver.get(ConstantList.URL);
        driver.manage().window().maximize();
    }


}

