package seleniumpractice1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Readingafilefromexcel {

	public static void main(String[] args) throws IOException {
		 

FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
XSSFWorkbook wbook=new XSSFWorkbook(file);
XSSFSheet sheet=wbook.getSheet("Sheet1");
int totalrows=sheet.getLastRowNum();
int totalcells=sheet.getRow(1).getLastCellNum();
System.out.println(totalrows);
System.out.println(totalcells);

for(int r=0;r<totalrows;r++) 
{
	XSSFRow currentrow=sheet.getRow(r);
	for(int c=0;c<totalcells;c++)
	{
		XSSFCell cellvalues=sheet.getRow(r).getCell(c);
		System.out.print(cellvalues.toString()+ "\t");
		
	}
	System.out.println();
}
wbook.close();
file.close();

	}

}
