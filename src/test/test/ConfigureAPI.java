package test.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ConfigureAPI {

//Clicking on the Generated result link

    public static void OpenJson(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@target=\"blank\"]")).click();

        driver.getWindowHandle();

//Switching back to first tab so it will be possible to get the Url link Address of the new tab.
        driver.switchTo().window(driver.getWindowHandle());

    }

    public static void PrintJsonUrl(WebDriver driver) {

//Prints the Json URL link Address.
        System.out.println(driver.findElement(By.xpath("//a[@target=\"blank\"]")).getText());


    }

    //API GET request to the server:

    public static void MyGETRequest(WebDriver driver) throws IOException {

        String JsonUrlLink;
       JsonUrlLink = driver.findElement(By.xpath("//a[@target=\"blank\"]")).getText();

       driver.get(JsonUrlLink);


//Establish a connection
     URL urlForGetRequest = new URL(JsonUrlLink);

        String readLine = null;

        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

        conection.setRequestMethod("GET"); //Get method

        conection.setRequestProperty("userId", "a1bcdef"); // Request values from Json .

        int responseCode = conection.getResponseCode();
//Set a condition of success or failed result
        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader in = new BufferedReader(

                    new InputStreamReader(conection.getInputStream()));

            StringBuffer response = new StringBuffer();

            while ((readLine = in.readLine()) != null) {

                response.append(readLine);

            }
            in.close();

            // print result

            System.out.println("JSON String Result " + response.toString());



//Creating new Log with API Response from the server.

            Logger logger = Logger.getLogger("API_Log");
            FileHandler fh;

            try {

                // This block configure the logger with handler and formatter
                fh = new FileHandler(ConstantList.Log);
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);

                // the following statement is used to log any messages
                logger.info("Print this Log");

            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


//Prints the Log:

            logger.info(response.toString());


        } else {

            System.out.println("GET NOT WORKED");






        }

    }
}



