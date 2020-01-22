package Library;

import Base.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class utilExcel extends BaseTest {



    public static  String Filepath = propertyReader.readProperty("TestDataPath").toString();
    public static String[] sheetNames = null;
    public class MasterSheetData {
        public String TestMethods;
        public String DataSheets;
        public String Execute;
        public int StartRowId;
        public int Count;

    }

    public MasterSheetData masterSheetData = new MasterSheetData();

    public static Sheet getExcelSheet(String filepath, String sheetName) throws IOException {
        Sheet Sheetname = null;
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheetname = workbook.getSheet(sheetName);
        return Sheetname;
    }

   public static int getNumberOfSheets(String filepath) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        return workbook.getNumberOfSheets();
   }


   public static String[] getSheetNames(String filepath) throws IOException{
       FileInputStream inputStream = new FileInputStream(new File(filepath));
       Workbook workbook = new XSSFWorkbook(inputStream);
       String sheetnames[]= new String[workbook.getNumberOfSheets()];
       for(int i=0;i<=workbook.getNumberOfSheets()-1;i++)
       {
           sheetnames[i] =workbook.getSheetName(i);
       }
       return sheetnames;
   }



    public static Sheet getReportetRowData(String filepath, String sheetName) throws IOException {
        Sheet Sheetname = null;
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheetname = workbook.getSheet(sheetName);
        return Sheetname;
    }

    public static Sheet getSheetName(String sheetName) throws IOException {
        Sheet Sheetname = null;
        FileInputStream inputStream = new FileInputStream(new File(Filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheetname = workbook.getSheet(sheetName);
        return Sheetname;
    }

    public void Set_ValueToExcel(String ExcelSheetName, String ColumnName, String ValueToBeSet, int RowID) throws IOException {
        Sheet Sheetname = getExcelSheet(Filepath, ExcelSheetName);
        int rowCount = Sheetname.getLastRowNum();
        int colCount = Sheetname.getRow(0).getLastCellNum();
        Row FirstRow = Sheetname.getRow(0);
         for (int i = 0; i < colCount; i++) {
            if (ColumnName.contains(FirstRow.getCell(0).getStringCellValue().toString())) {
                Cell cell = Sheetname.getRow(RowID).getCell(i);
                cell.setCellValue(ValueToBeSet);
                break;
            }
        }

    }

    public void Set_ValueToExcel(String ExcelSheetName, int ColumnID, String ValueToBeSet, int RowID) throws IOException {
        Sheet Sheetname = getExcelSheet(Filepath, ExcelSheetName);
        int rowCount = Sheetname.getLastRowNum();
        int colCount = Sheetname.getRow(0).getLastCellNum();
        Row FirstRow = Sheetname.getRow(0);
          Cell cell = Sheetname.getRow(RowID).getCell(ColumnID);
                cell.setCellValue(ValueToBeSet);
    }




    public static Hashtable GetTestData (String dataSheet, int rowNumber)throws IOException
    {
        Sheet Sheetname = getExcelSheet(Filepath, dataSheet);
        int rowCount = Sheetname.getLastRowNum();
        int colCount = Sheetname.getRow(0).getLastCellNum();
        Hashtable<String, String> dictionary = new Hashtable<String, String>();
        Row FirstRow = Sheetname.getRow(0);
        Row Testdatarow = Sheetname.getRow(rowNumber);

        for (int i=0; i<colCount;i++) {
            dictionary.put(FirstRow.getCell(i).toString(),Testdatarow.getCell(i).toString());
            System.out.println(FirstRow.getCell(i).toString());
        }

      return dictionary;
    }
    public static List<Hashtable<String, String>> GetTestData1(String dataSheet, int rowNumber)throws IOException
    {
        Sheet Sheetname = getExcelSheet(Filepath, dataSheet);
        int rowCount = Sheetname.getLastRowNum();
        int colCount = Sheetname.getRow(0).getLastCellNum();
        Row FirstRow = Sheetname.getRow(0);
        Row Testdatarow = Sheetname.getRow(rowNumber);
        List<Hashtable<String, String>> excelTable = new ArrayList<Hashtable<String, String>>();

        for (int j=1; j<rowCount; j++) {
        for (int i = 0; i < colCount; i++) {
        excelTable.get(j-1).put(FirstRow.getCell(i).toString(), Sheetname.getRow(j).getCell(i).toString());
        System.out.println(FirstRow.getCell(i).toString());
    }
}
        return excelTable;
    }




    public static Hashtable GetMasterData (String dataSheet, String Testname1)throws IOException
    {
        Sheet Sheetname = getExcelSheet(Filepath,dataSheet);
        int MasterRowNumber=GetMasterRow(Testname1,Sheetname);
        int colCount = Sheetname.getRow(0).getLastCellNum();
        Hashtable<String, String> dictionary = new Hashtable<String, String>();
        Row FirstRow = Sheetname.getRow(0);
        Row MasterRow = Sheetname.getRow(MasterRowNumber);
        for (int i=0; i<colCount;i++) {
            dictionary.put(FirstRow.getCell(i).toString(),MasterRow.getCell(i).toString());
            System.out.println(FirstRow.getCell(i).toString());
        }

        return dictionary;
    }


    public static Sheet getUrlData (String dataSheet, String excelName)throws IOException
    {
        Sheet Sheetname = getExcelSheet(Filepath,dataSheet);
        return Sheetname;
    }

    public static int GetMasterRow(String TestName,Sheet Sheetname)throws IOException
    {
        int rowCount = Sheetname.getLastRowNum();
        int colCount = Sheetname.getRow(0).getLastCellNum();
        int TestRowNumber=0;
        Hashtable<String, String> dictionary = new Hashtable<String, String>();
        DataFormatter formatter = new DataFormatter();
        for (int i=1; i<rowCount;i++) {
            if(TestName.equalsIgnoreCase(Sheetname.getRow(i).getCell(0).getStringCellValue().toString()))
            {
                TestRowNumber=i;
                break;
            }

        }
        return TestRowNumber;

    }

    public static int GetLastColumn(Sheet Sheetname)throws IOException
    {
        int ColumnNumber=0;
        int rowCount = Sheetname.getRow(0).getLastCellNum();
        Hashtable<String, String> dictionary = new Hashtable<String, String>();
        for (int i=2; i<rowCount;i++) {
            if(Sheetname.getRow(0).getCell(i).getStringCellValue().toString().length()==0)
            {
                ColumnNumber=i;
                break;
            }
        }
        return ColumnNumber;
    }

    public static int GetLastRow(Sheet SheetName)
    {
        return SheetName.getLastRowNum();
    }


    public static Object[][] getSheetData(int sheetNumber) throws IOException {
        Sheet perfSheet = utilExcel.getExcelSheet(Filepath, sheetNames[sheetNumber]);
        int rowCount = perfSheet.getLastRowNum();
        int columnCount = perfSheet.getRow(0).getLastCellNum();
//        String sheetName = perfSheet.getSheetName();
        Object[][] dataSheet = new Object[rowCount - 1][columnCount];
        for (int i = 1; i < rowCount - 1; i++) {
            for(int j=0;j< columnCount-1;j++) {
                dataSheet[i][j] = perfSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return dataSheet;
    }


}
