package org.BaseClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static void createExcelFile(int creTheRow, int creTheCell, String data) throws IOException {
		File f=new File("C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\datadriven\\dataDriven\\excel\\newfile.xlsx");
		Workbook wb=new XSSFWorkbook();
		Sheet newSheet=wb.createSheet("sample datas");
		Row newRow=newSheet.createRow(creTheRow);
		Cell newCell=newRow.createCell(creTheCell);
		newCell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		System.out.println();
		
	}

	public static void createRowonly(int creTheRow, int creTheCell, String data) throws IOException {
		File f=new File("C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\datadriven\\dataDriven\\excel\\newfile.xlsx");
		Workbook wb=new XSSFWorkbook();
		Sheet newSheet=wb.getSheet("sample datas");
		Row newRow=newSheet.createRow(creTheRow);
		Cell newCell=newRow.createCell(creTheCell);
		newCell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		System.out.println();
		
	}
	public static void createCellonly(int getTheRow, int creTheCell, String data) throws IOException {
		File f=new File("C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\datadriven\\dataDriven\\excel\\newfile.xlsx");
		Workbook wb=new XSSFWorkbook();
		Sheet newSheet=wb.getSheet("sample datas");
		Row newRow=newSheet.getRow(getTheRow);
		Cell newCell=newRow.createCell(creTheCell);
		newCell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		System.out.println();
		
	}
	public static WebDriver driver;
	public static Actions a;
	public static void browserLaunch(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}	
		else if(browserName.equals("Edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	}
	}
		public static void maxWindow() {
		driver.manage().window().maximize();

	}
	public static void  launchUrl(String url) {
		driver.get(url);
		
	}
	public static void  getThePageTitle() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	public static void  getTheUrl() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}
	public static void passText(WebElement txtElement,String txt) {
		txtElement.sendKeys(txt);
	}
	public static void clickWebElement(WebElement btnElement) {
		btnElement.click();
	}
	public static void takeTheScreenshot(String imgName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\ProjectMaven\\images\\"+imgName+".png");
		FileUtils.copyFile(src, des);
	}
		
	public static void moveThecursor(WebElement targetWebElement){
		a=new Actions(driver);
		a.moveToElement(targetWebElement).perform();
		
	}
	public static void contextClick(WebElement targetWebElement){
		a=new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragAndDropTheWebElement(WebElement src, WebElement des) {
		a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	static Select s;
	public static void selectByIndex(int i,WebElement a) {
		s=new Select(a);
		s.selectByIndex(i);
	}
	public static void selectByVisibleText(WebElement a, String b) {
		s=new Select(a);
		s.selectByVisibleText(b);
	}
	public static void selectByValue(String value, WebElement a) {
		s=new Select(a);
		s.selectByValue(value);
	}
	static JavascriptExecutor j;
	public static void javaScript(String a, WebElement e) {
	j= (JavascriptExecutor)driver;
	j.executeScript("arguments[0].setAttribute('value','a')", e);
	}
	public static void javaClick(WebElement click) {
		j= (JavascriptExecutor)driver;
		j.executeScript("arguments[0]",click);	
	}
	public static void getAttr() {
		j= (JavascriptExecutor)driver;
		j.executeScript("arguments[0].getAttribute('value')");
	}
	public static void Scroll(WebElement e) {
		j= (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(True)",e);
	}

	public static void robot() throws AWTException {
		Robot r=new Robot();
		for(int i=0;i<1;i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
				
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void framework() throws IOException {
		File f=new File("C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\ProjectMaven\\excel\\sample.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet("sample datas");
		for (int i=0;i<s.getPhysicalNumberOfRows();i++) {
			Row r=s.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c= r.getCell(j);
				int cellType=c.getCellType();
				if(cellType==1) {
					String value=c.getStringCellValue();
					System.out.println(value);
				}
					else if(DateUtil.isCellDateFormatted(c)){
						java.util.Date d = c.getDateCellValue();
			SimpleDateFormat Sim=new SimpleDateFormat("dd-MM-YYYY")	;		
					String value=Sim.format(d)	;
					System.out.println(value);
					}
						
					else {
						double d=c.getNumericCellValue();
						long l=(long)d;
						String Value=String.valueOf(l);
						System.out.println(Value);
					}
			}}}	
	public static void getText(WebElement b) {
		b.getText();
		System.out.println(b);
	}

	public class LoginPojo {
		private final SearchContext driver = null;

		public  LoginPojo() {
		PageFactory.initElements(driver,this);
		}
		
		WebElement email=driver.findElement(By.id("attribute value"));
		@FindBy(id="email")
		public WebElement emailTxt;
		@FindBy(id="passContainer")
		public WebElement passwordTxt;
		@FindBy(name="login")
		public  WebElement loginBtn;

		public SearchContext getDriver() {
			return driver;
		}
		public WebElement getEmailTxt() {
			return emailTxt;
		}
		public WebElement getPasswordTxt() {
			return passwordTxt;
		}
		public WebElement getLoginBtn() {
			return loginBtn;
		}

		}
		public static void closeTheBrowser() {
			driver.quit();
		}
		public static String jdbcConnection() {
			Connection con=null;
			
			String snameClmn= " ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			String query="select sname from student where sname='Raj'";
			PreparedStatement ps=con.prepareCall(query);
			ResultSet ex=ps.executeQuery();
			while(ex.next()) {
				snameClmn=ex.getString("sname");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
					
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
						}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			
		return snameClmn;
}
		}

