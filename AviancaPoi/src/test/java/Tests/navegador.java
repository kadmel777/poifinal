package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Tests.extraerDatos;

import Pages.aviancaPage;
import Pages.formularioLifemilles1;
import Pages.formularioLifemilles2;
import Utilidades.reportesext;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class navegador {	
	
	private ChromeDriver driver;
	ExtentTest test;
	ExtentReports reporte;
		
	public String mes = "Mayo";
	public String año = "1992";
	public String cedula = ""+Math.round((Math.random()*Math.pow(10, 10)));
	public String dia = "19";
	public String pais = "Colombia";
	public String nombreLabel="";
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;	
   	
	aviancaPage objetosPage;
	formularioLifemilles1 objetosFormulario1;
	formularioLifemilles2 objetosFormulario2;
	
	String datos[][]= new String[4][6];
	String lifenumeros[][] = new String[4][2];
	public int cont=0;
	
	
  @BeforeMethod
  public void beforeMethod()  {
	        
	  System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
	  reporte = reportesext.getInstance();
	  test = reporte.startTest("hola");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  String URL = "https://www.avianca.com/co/es/descubre-y-compra/destinos/";
	  driver.get(URL);
	  
	  objetosPage = new aviancaPage(driver, test);
	  objetosFormulario1 = new formularioLifemilles1(driver, test);
	  objetosFormulario2 = new formularioLifemilles2(driver, test);
	  
  }

  @Test(dataProvider = "usuarios", priority=1)
  public void registrandoUsuarios(String sname, String ssecondname,String slastname, String ssecondlastname, String scorreo, String contraseña) throws InterruptedException{
	  			
			objetosPage.clickBotonMyAvanca();
			objetosPage.clickBotonRegistrate(5);
			
			cambiarPestaña(40);

			objetosFormulario1.clickBotonAceptar(1);
			
			objetosFormulario1.clickInputEmail(scorreo);
			
			objetosFormulario1.clickInputPassword(contraseña);
			objetosFormulario1.clickInputConfrirmPassword(contraseña);
			
			objetosFormulario1.clickBotonSiguiente();

			objetosFormulario2.clickInputFirtsname(sname, 1);
			
			objetosFormulario2.clickInputSecondname(ssecondname);
			
			objetosFormulario2.clickInputLastname(slastname);
			
			objetosFormulario2.clickInputSecondlastname(ssecondlastname);
			
			objetosFormulario2.llenandoPais(pais);
			objetosFormulario2.llenandoMes(mes);
			objetosFormulario2.llenandoDia(dia);
			objetosFormulario2.llenandoYear(año);
			objetosFormulario2.clickInputCedula(cedula);
			objetosFormulario2.llenandoPais2(pais);
			objetosFormulario2.clickCheckButton1();
			objetosFormulario2.clickCheckButton2();
			objetosFormulario2.clickBotonSiguiente();
			compararNombres(sname,2);
			System.out.println(objetosFormulario2.retornaLifeNumber(2));
			
			lifenumeros[cont][0]=objetosFormulario2.retornaLifeNumber(2);
			lifenumeros[cont][1]=contraseña;
  }
  
  
  @Test (dataProvider = "usuarios2", priority=2)
  public void iniciandoSencionConUsuarioIncorrecto(String usuario, String contraseña) throws InterruptedException {
	  objetosPage.clickBotonMyAvanca();
	  objetosPage.clickInpuntLiemilles(usuario,1);
	  objetosPage.clickInputPassword(contraseña);
	  objetosPage.clickBotonIniciarSecion();
	  
	  compararNombres2(usuario,2);
	 
  }
  
  @DataProvider (name = "usuarios")
  public Object[][] getData() throws IOException {
	 String[][] Object = null;
	 File src=new File("D:\\test2.xlsx");   
	 FileInputStream fis = new FileInputStream(src);
	 workbook = new XSSFWorkbook(fis);
	 sheet= workbook.getSheetAt(0);
	 System.out.println("data provider");
	 System.out.println("tamaño: "+sheet.getLastRowNum());
	 for(int i=1; i<=sheet.getLastRowNum(); i++){
	  for(int j=0;j<6;j++){
		  cell = sheet.getRow(i).getCell(j);
		  datos[(i-1)][j]="atr"+cell.getStringCellValue();
	  }
	 }	
	 return  Object=datos;
  }
  
  @DataProvider (name = "usuarios2")
  public Object[][] getData2() throws IOException {
	 String[][] Object = null;
	 
	 return  Object=lifenumeros;
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  reporte.endTest(test);
	  reporte.flush();
		
  }
  
  
  public void cambiarPestaña(int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);	 
	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs2.get(0));
	  driver.close();
	  driver.switchTo().window(tabs2.get(1));
  }
  
  public void compararNombres(String snombre,int retrasoEnSegundos) throws InterruptedException {
	  nombreLabel = objetosFormulario2.obtenerNombre(retrasoEnSegundos);
	  snombre = (snombre.substring(0, 1).toUpperCase() + snombre.substring(1).toLowerCase());
	  Assert.assertEquals(nombreLabel, snombre);
  }
  
  public void compararNombres2(String snombre,int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);
	  nombreLabel = objetosPage.obtenerUsuario();
	  snombre = (snombre.toLowerCase());
	  Assert.assertEquals(nombreLabel, snombre);
  }
  
  public void comparandoMensajeError(int retrasoEnSegundos) throws InterruptedException {
	  String error= objetosFormulario2.obtenerError(retrasoEnSegundos);
	  boolean resultadoComparacion= false;
	  System.out.println(error);
	  if(error.contains("code: 2175")) {
		  resultadoComparacion=true;
	  }
	  Assert.assertEquals(resultadoComparacion, true);
  }
  
  public void comparandoMensajeUsuarioInvalido(int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);
	  String error = objetosPage.obtenerError();
	  boolean resultado = false;
	  if(error.contains("Número de cuenta LifeMiles inválido")) {
		  resultado = true;
	  }
	  Assert.assertEquals(resultado, true);
  }  
 
}
