package TestNG_Test;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenTest extends BaseTest{

    @DataProvider(name = "DummyData")
    public Object[][] getDummyData(){
        return new Object[][] {{"Username1", "Password1"}, {"Username2", "Password2"}, {"Username3", "Password3"}, {"Username4", "Password4"}};
    }

    @Test(dataProvider = "TestData")
    public void loginShouldSucceed(String username, String password) throws InterruptedException {
        WebElement usernameEl = driver.findElement(By.xpath("//input[@name = \"username\"]"));
        usernameEl.isDisplayed();
        usernameEl.clear();
        usernameEl.sendKeys(username);
        Thread.sleep(1000);

        WebElement passwordEl = driver.findElement(By.xpath("//input[@name = \"password\"]"));
        passwordEl.isDisplayed();
        passwordEl.clear();
        passwordEl.sendKeys(password);
        Thread.sleep(1000);
    }

    @DataProvider(name = "TestData")
    public static Object[][] getTestDataFromExcel() {
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xls";
        Workbook book = null;
        Sheet sheet;
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet("Sheet1");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                System.out.print(data[i][k]);
            }
            System.out.print(" " + "\n");
        }
        return data;

    }



//    public class ReadandWriteCSVFile {
//        public static void main(String[] args) throws FileNotFoundException, IOException {
//            String fName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xls";
////            String fName = "c:\\csv\\myfile.csv";
//            Object obj[][] = null;
//            // Read data from CSV file.
//            String thisLine;
//
//            FileInputStream fis = new FileInputStream(fName);
//            DataInputStream myInput = new DataInputStream(fis);
//            List<String[]> lines = new ArrayList<String[]>();
//            while ((thisLine = myInput.readLine()) != null) {
//                lines.add(thisLine.split(";"));
//            }
//
//// convert our list to a String array.
//            String[][] array = new String[lines.size()][0];
//            lines.toArray(array);
//
//        }
//    }
}

