package TestNgClasses;

import Base.BaseTest;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sampleRunner extends BaseTest {

    public static String moduleName=null;
    public static String[] sheetNames1 = null;
    public static int j=1,testCount=0,classCount;

    public static void main(String[] args) throws IOException {
    sheetNames1=getSheetNames1(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\demo.opencart.xlsx");

    List<XmlClass> classList = new ArrayList<XmlClass>();
        List<XmlClass> classList1 = new ArrayList<XmlClass>();
    List<XmlTest> testList = new ArrayList<XmlTest>();
        HashMap<String,String> ListOfClasses=new HashMap<String, String>();

    //SUITE
        List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
    XmlSuite suiteName = new XmlSuite();
        suiteName.setName("Suite1");
        suiteName.setParallel("flase");

    //TEST
        XmlTest testName  = new XmlTest(suiteName);
        testName.setName("test1");
        testName.setParameters(ListOfClasses);
        testName.addParameter("parameter1","value1");
        testName.addParameter("parameter2","value2");
            XmlClass className1 = new XmlClass("class1");
            classList.add(className1);
            XmlClass className2 = new XmlClass("class2");
            classList.add(className2);
        testName.setXmlClasses(classList);
        testList.add(testName);
//        System.out.println(testList);

        XmlTest testName1  = new XmlTest(suiteName);
        testName1.setName("test2");
        testName1.addParameter("parameter1","value1");
        testName1.addParameter("parameter2","value2");
        XmlClass className3 = new XmlClass("class3");
        classList1.add(className3);
        XmlClass className4 = new XmlClass("class4");
        classList1.add(className4);
        testName1.setXmlClasses(classList1);
        testList.add(testName1);
//        System.out.println(testList);
//        suiteList.add(suiteName);
//        suiteName.set;
        suiteList.add(suiteName);
        System.out.println(suiteList);


//        TestNG testrun = new TestNG();
//       testrun.setXmlSuites(suiteList);
//        testrun.run();
}







    public static int returnHeaderPostion(String headerName)throws IOException
    {
        int i;
        Sheet perfSheet = getExcelSheet1(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\demo.opencart.xlsx", sheetNames1[0]);
        Object[][] dataSheet=getSheetData1(0);
        for(i=0;i<=perfSheet.getRow(0).getLastCellNum()-1;i++)
        {
            if(dataSheet[0][i].toString().toLowerCase().equalsIgnoreCase(headerName.toLowerCase()))
                break;
        }
        return i;
    }

    public static String[] getSheetNames1(String filepath) throws IOException{
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        String sheetnames[]= new String[workbook.getNumberOfSheets()];
        for(int i=0;i<=workbook.getNumberOfSheets()-1;i++)
        {
            sheetnames[i] =workbook.getSheetName(i);
        }
        return sheetnames;
    }

    public static Sheet getExcelSheet1(String filepath, String sheetName) throws IOException {
        Sheet Sheetname = null;
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheetname = workbook.getSheet(sheetName);
        return Sheetname;
    }
    public static Object[][] getSheetData1(int sheetNumber) throws IOException {
        Sheet perfSheet = getExcelSheet1(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\demo.opencart.xlsx", sheetNames1[sheetNumber]);
        int rowCount = perfSheet.getPhysicalNumberOfRows();
        int columnCount = perfSheet.getRow(0).getLastCellNum();
//        String sheetName = perfSheet.getSheetName();
        Object[][] dataSheet = new Object[rowCount][columnCount];
        for (int i = 0; i <=rowCount-1; i++) {
            for(int j=0;j<=columnCount-1;j++) {
                dataSheet[i][j] = perfSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return dataSheet;
    }

}
