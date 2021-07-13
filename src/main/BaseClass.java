package main;
import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;




public class BaseClass {
	
	public static String datapath1;
	public static String sheet;
	public static String usergroup;
	public static String baseurl;
	public static String browser;
	

	
	@BeforeSuite(alwaysRun = true)
	@Parameters({"datapath","sheet","usergroup","baseurl","browser"})
	public void configureSuite(String datapath, String sheet, String usergroup, String baseurl,String browser) throws Exception
	{
		BaseClass.datapath1=datapath;
		BaseClass.sheet=sheet;
		BaseClass.usergroup=usergroup;
		BaseClass.baseurl=baseurl;
		BaseClass.browser=browser;
				
	}

	

	@DataProvider(name = "Users")
	public Object[][] createData() throws Exception 
    {
        Object[][] retObjArr=getTable(datapath1,sheet,usergroup);
        return(retObjArr);
    }


	
	public String[][] getTable(String xlsfilepath, String sheetname, String tag){
		String[][] tabArray=null;
        try{
        	boolean b=new File(xlsfilepath).exists();
        	System.out.println(b);
        	Workbook workbook = Workbook.getWorkbook(new File(xlsfilepath));
            Sheet sheet = workbook.getSheet(sheetname);
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tag);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell("End"+tag);                               

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
          
        }
        catch (Exception e)    {
            System.out.println("error in getTableArray()");
        }

        return(tabArray);
    }
	

	

}





