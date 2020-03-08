
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class pexcel {
        public static void main(String[] args) throws Exception{
            File file = new File("C:\\New folder\\UserData.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook wb=new XSSFWorkbook(inputStream);
            XSSFSheet sheet1 = wb.getSheetAt(0);
            //for defining headers
            sheet1.getRow(0).createCell(0).setCellValue("Email");
            sheet1.getRow(0).createCell(1).setCellValue("Password");
            //First Record
            sheet1.getRow(1).createCell(0).setCellValue("psbrar2001@gmail.com");
            sheet1.getRow(1).createCell(1).setCellValue("Savetiger123#");

            System.out.println("Writing data in excel");
            FileOutputStream output=new FileOutputStream(file);
            wb.write(output);
            wb.close();
        }
    }
