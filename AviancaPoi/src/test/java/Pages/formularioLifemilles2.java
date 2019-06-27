package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class formularioLifemilles2 {
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement inputFisrtname;
	
	@FindBy(xpath="//input[@id='secondName']")
	WebElement inputSecondname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement inputLastname;
	
	@FindBy(xpath="//input[@id='secondLastName']")
	WebElement inputSecondlastname;
			
	@FindBy(xpath="//select[@id='country']")
	WebElement selectPais;
	
	@FindBy(xpath="//select[@placeholder='Mes']")
	WebElement selectMes;
	
	@FindBy(xpath="//select[@placeholder='Día']")
	WebElement selectDia;
	
	@FindBy(xpath="//select[@placeholder='Año']")
	WebElement selectAño;
	
	
	@FindBy(xpath="//input[@id='documentNumber']")
	WebElement inputCedula;
	
	@FindBy(xpath="//select[@placeholder='']")
	WebElement selectPais2;
	
	  
	@FindBy(xpath="//label[@for='normal_term0']")
	WebElement checkBoton1;
	
	@FindBy(xpath="//label[@for='normal_term1']")
	WebElement checkBoton2;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement botonSiguiente;
	
	@FindBy(xpath="//a[@href='/account/overview']")
	WebElement labelNombre;
	
	@FindBy (xpath="//div/p[1]")
	WebElement mensajeError;
	
	@FindBy (xpath = "//button[.='Try again']")
	WebElement botonTry;
	
	@FindBy (xpath = "//div[@class='AccountActivityCard_userId__eyjwS']")
	WebElement lifenumber; 
	
	public formularioLifemilles2(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInputFirtsname(String name, int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		inputFisrtname.click();
		inputFisrtname.sendKeys(name);	
		test.log(LogStatus.INFO, "Escribiendo Nombre");
	}
	
	public void clickInputSecondname(String secondname) {
		inputSecondname.click();
		inputSecondname.sendKeys(secondname);
		test.log(LogStatus.INFO, "Escribiendo segundo Nombre");
	}
	
	public void clickInputLastname(String lastname) {
		inputLastname.click();
		inputLastname.sendKeys(lastname);
		test.log(LogStatus.INFO, "Escribiendo Apellido");
	}
	
	public void clickInputSecondlastname(String secondlastname) {
		inputSecondlastname.click();
		inputSecondlastname.sendKeys(secondlastname);
		test.log(LogStatus.INFO, "Escribiendo Segundo Apellido");
	}
	
	public void llenandoPais(String pais) {
		 Select country = new Select(selectPais);
		 country.selectByVisibleText(pais);
		 test.log(LogStatus.INFO, "Selecionando Pais");
	}
	
	public void llenandoMes(String mont) {
		 Select mes = new Select(selectMes);
		 mes.selectByVisibleText(mont);
		 test.log(LogStatus.INFO, "Selecionando Mes");
	}
	
	public void llenandoDia(String day) {
         Select dia = new Select(selectDia);
		 dia.selectByVisibleText(day);
		 test.log(LogStatus.INFO, "Selecionando Dia");
	}
	
	public void llenandoYear(String año) {
		 Select year = new Select(selectAño);
		 year.selectByVisibleText(año);
		 test.log(LogStatus.INFO, "Selecionando Año");
	}
	
	public void clickInputCedula(String cedula) {
		inputCedula.click();
		inputCedula.sendKeys(cedula);
		test.log(LogStatus.INFO, "Escribiendo Cedula");
	}
	
	public void llenandoPais2(String pais) {
		 Select country2 = new Select(selectPais2);
		 country2.selectByVisibleText(pais);
		 test.log(LogStatus.INFO, "Selecionando Pais");
	}
	
	public void clickCheckButton1() {
		checkBoton1.click();
		test.log(LogStatus.INFO, "Click en checkbutton1");
	}
	
	public void clickCheckButton2() {
		checkBoton2.click();
		test.log(LogStatus.INFO, "Click en checkbutton1");
	}
	
	public void clickBotonSiguiente() {		
		botonSiguiente.click();
		test.log(LogStatus.INFO, "Click en el boton Siguiente");
	}
	
	public String obtenerNombre(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		test.log(LogStatus.INFO, "Obteniendo Nombre");
		return labelNombre.getText();
	}
	
	public String obtenerError(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		test.log(LogStatus.INFO, "Obteniendo Error");
		return mensajeError.getText();
	}
	
	public void clicTryAgaint(){
		botonTry.click();
	}
	
	public String retornaLifeNumber(int RetrasoEnSegundos) throws InterruptedException{
		Thread.sleep(RetrasoEnSegundos*1000);
		String lifeNumber=lifenumber.getText();
		test.log(LogStatus.INFO, "Obteniendo numero de lifemilles");
		return lifeNumber;
		
	}
	
}
