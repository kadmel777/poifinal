package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class formularioLifemilles1 {
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//button[.='Aceptar']")
	WebElement botonAceptar;
		
	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement inputPassword; 
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement inputConfirmPassword;
	
	@FindBy(xpath="//button[.='Siguiente']")
	WebElement botonSiguiente;
	
	public formularioLifemilles1(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBotonAceptar(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		botonAceptar.click();
		test.log(LogStatus.INFO, "Click en Aceptar cookie");
	}
	
	public void clickInputEmail(String email) {
		inputEmail.click();
		inputEmail.sendKeys(email);
		test.log(LogStatus.INFO, "Escribiendo Email");
	}
	
	public void clickInputPassword(String password) {
		inputPassword.click();
		inputPassword.sendKeys(password);
		test.log(LogStatus.INFO, "Escribiendo Password");
	}
	
	public void clickInputConfrirmPassword( String password) {
		inputConfirmPassword.click();
		inputConfirmPassword.sendKeys(password);
		test.log(LogStatus.INFO, "Confirmando Password");
	}
	
	public void clickBotonSiguiente() {
		inputEmail.click();
		botonSiguiente.click();
		test.log(LogStatus.INFO, "Click boton siguiente");
	}

}
