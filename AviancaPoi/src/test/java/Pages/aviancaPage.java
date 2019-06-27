package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class aviancaPage {
	WebDriver driver;
	ExtentTest test;

	
	@FindBy(xpath="//div[@class='my-account-tooltip']/a[@role='link']/span[.='MyAvianca']")
	WebElement botonMyAvianca;
	
	@FindBy(xpath="//a[@role='button' and .='Regístrate']")
	WebElement botonRegistrate;
	
	@FindBy(xpath="//input[@id='lifeMilesNumber']")
	WebElement inputLifemilles;
	
	@FindBy(xpath="//input[@id='lifeMilesPassword']")
	WebElement inputPassword;

	@FindBy(xpath="//input[@title='Inicia sesión']")
	WebElement botonIniciarSecion;
	
	@FindBy(xpath="//span[@class='message-pre']")
	WebElement mensajeError;
	
	@FindBy (xpath="//span[@class='hello-user']")
	WebElement usuarioRegistrado;
	
	public aviancaPage(WebDriver driver, ExtentTest test){		
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBotonMyAvanca(){
		botonMyAvianca.click();		
	}
	
	public void clickBotonRegistrate(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		botonRegistrate.click();
		//test.log(LogStatus.INFO, "Click en boton registrarse");
	}
	
	public void clickInpuntLiemilles(String cedula, int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		inputLifemilles.click();
		inputLifemilles.sendKeys(cedula);
		test.log(LogStatus.INFO, "Escribiendo cedula");
	}
	
	public void clickInputPassword(String password) {
		inputPassword.click();
		inputPassword.sendKeys(password);
		test.log(LogStatus.INFO, "Escribiendo pasword");
	}
	
	public void clickBotonIniciarSecion() {
		botonIniciarSecion.click();
		test.log(LogStatus.INFO, "Click en boton iniciar secion");
	}
	
	public String obtenerError() {
		test.log(LogStatus.INFO, "Obteniendo Error");
		return mensajeError.getText();
		
	}
	public String obtenerUsuario() {
		test.log(LogStatus.INFO, "Obteniendo usuario");
		return usuarioRegistrado.getText();
		
	}
}
