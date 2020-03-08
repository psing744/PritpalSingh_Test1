
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;

    public class readpexcel {
        public static void main(String[] args) throws Exception {

            String email="";
            String password="";

            try {
                File file = new File("C:\\New folder\\UserData.xlsx");
                FileInputStream inputStream = new FileInputStream(file);
                XSSFWorkbook wb = new XSSFWorkbook(inputStream);
                XSSFSheet sheet1 = wb.getSheetAt(0);

                XSSFRow row = sheet1.getRow(1);
                email=row.getCell(0).toString();
                password=row.getCell(1).toString();

                inputStream.close();
                wb.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }

            Write(email,password);
        }

        public static  void Write(String txtEmail,String txtPassword) throws Exception{
            System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            String baseUrl = "http://demo.guru99.com/test/login.html";
            driver.get(baseUrl);
            WebElement emailElement = driver.findElement(By.id("email"));
            WebElement passwordElement = driver.findElement(By.id("passwd"));
            emailElement.sendKeys(txtEmail);
            passwordElement.sendKeys(txtPassword);
            WebElement login = driver.findElement(By.id("SubmitLogin"));
            login.submit();
            //driver.close();
        }
    }
