
package test;

import org.junit.FixMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.test.ConfigureAPI;
import test.test.ConfigureUI;
import test.test.ConstantList;
import test.test.UploadUrl;

import java.io.IOException;

import static java.lang.System.setProperty;

@FixMethodOrder

public class TestClass {

    private static WebDriver driver;


    @BeforeClass
    public static void bc() {

//Sets the Browser's driver location for this test
        setProperty(ConstantList.upload1, ConstantList.upload2);

    }


    @Test

    public void Test_01() {

        driver = new ChromeDriver();

        UploadUrl.Upload(driver);
    }

    @Test

    public void Test_02() {

        ConfigureUI.ClickAdvance(driver);


    }


    @Test

    public void Test_03() {

        ConfigureUI.Setinfo(driver);


    }

    @Test

    public void Test_04() {

        ConfigureUI.GenerateClick(driver);


    }


    @Test

    public void Test_05() {

        ConfigureUI.ScrollUp(driver);

    }

    @Test

    public void Test_06() {


        ConfigureAPI.OpenJson(driver);


    }


    @Test

    public void Test_07() {


          ConfigureAPI.PrintJsonUrl(driver);

    }



    @Test
    public void Test_08()throws IOException {

        ConfigureAPI.MyGETRequest(driver);




    }

    @AfterClass
    public void tearDown(){

    }

}

