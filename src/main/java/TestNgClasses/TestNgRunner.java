package TestNgClasses;

import Base.BaseTest;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNgRunner extends BaseTest {
    public static String moduleName = null;
    public static String[] sheetNames1 = null;
    public static int j = 1,i, testCount = 0, classCount=0;


    public static void main(String[] args) throws IOException {
        sheetNames1=getSheetNames1(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\demo.opencart.xlsx");

        List<XmlTest> testList = new ArrayList<XmlTest>();

        //SUITE
        XmlSuite suiteName = new XmlSuite();
        suiteName.setName(sheetNames1[0].toString());
        suiteName.setParallel("false");
        suiteName.setVerbose(3);
        suiteName.setThreadCount(1);

        Sheet perfSheet = getExcelSheet1(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\demo.opencart.xlsx", sheetNames1[0]);
        Object[][] dataSheet=getSheetData1(0);
        XmlClass [] className;
        className = new XmlClass[perfSheet.getPhysicalNumberOfRows()-1];
        XmlTest testName[];
        testName  = new XmlTest[perfSheet.getPhysicalNumberOfRows()-1];
//        int i;
        for(i=1;i<=perfSheet.getPhysicalNumberOfRows()-1;)
        {
            if(dataSheet[i][returnHeaderPostion("execute")].toString().equalsIgnoreCase("y"))
            {
                moduleName=dataSheet[i][returnHeaderPostion("module")].toString();
                testName[testCount] = new XmlTest(suiteName);
                testName[testCount].setName(moduleName);
                List<XmlClass> classList = new ArrayList<XmlClass>();
                for(j=i;j<=perfSheet.getPhysicalNumberOfRows()-1;j++)//classes
                {
                    if(dataSheet[j][returnHeaderPostion("module")].toString().equalsIgnoreCase(moduleName) && dataSheet[j][returnHeaderPostion("execute")].toString().equalsIgnoreCase("y"))
                    {
                        testName[testCount].addParameter(dataSheet[j][returnHeaderPostion("TestName")].toString()+"Data",dataSheet[j][returnHeaderPostion("DataSheetName")].toString());
                        className[classCount] = new XmlClass(dataSheet[j][returnHeaderPostion("ClassName")].toString());
                        classList.add(className[classCount]);
                        classCount++;
                    }
                    else{
                        break;
                    }
                    i++;
                }

                testName[testCount].setXmlClasses(classList);
//                classList1.clear();
                testList.add(testName[testCount]);
            }
            else{
                i++;
//                break;
            }
            testCount++;
        }
        List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
        suiteList.add(suiteName);
        System.out.println(suiteList);
        TestNG myTestNG = new TestNG();
        myTestNG.setXmlSuites(suiteList);

        List<Class<? extends ITestListener>> listnerList = new ArrayList<>();
//        listnerList.add(TestNgListener.class);
        myTestNG.setListenerClasses(Collections.singletonList(TestNgListener.class));
        myTestNG.run();

    }

        public static int returnHeaderPostion (String headerName)throws IOException
        {
            int i;
            Sheet perfSheet = getExcelSheet1(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\demo.opencart.xlsx", sheetNames1[0]);
            Object[][] dataSheet = getSheetData1(0);
            for (i = 0; i <= perfSheet.getRow(0).getLastCellNum() - 1; i++) {
                if (dataSheet[0][i].toString().toLowerCase().equalsIgnoreCase(headerName.toLowerCase()))
                    break;
            }
            return i;
        }

        public static String[] getSheetNames1 (String filepath) throws IOException {
            FileInputStream inputStream = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            String sheetnames[] = new String[workbook.getNumberOfSheets()];
            for (int i = 0; i <= workbook.getNumberOfSheets() - 1; i++) {
                sheetnames[i] = workbook.getSheetName(i);
            }
            return sheetnames;
        }

        public static Sheet getExcelSheet1 (String filepath, String sheetName) throws IOException {
            Sheet Sheetname = null;
            FileInputStream inputStream = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheetname = workbook.getSheet(sheetName);
            return Sheetname;
        }
        public static Object[][] getSheetData1 ( int sheetNumber) throws IOException {
            Sheet perfSheet = getExcelSheet1(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\demo.opencart.xlsx", sheetNames1[sheetNumber]);
            int rowCount = perfSheet.getPhysicalNumberOfRows();
            int columnCount = perfSheet.getRow(0).getLastCellNum();
            Object[][] dataSheet = new Object[rowCount][columnCount];
            for (int i = 0; i <= rowCount - 1; i++) {
                for (int j = 0; j <= columnCount - 1; j++) {
                    dataSheet[i][j] = perfSheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            return dataSheet;
        }
    }
