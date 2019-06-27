package Utilidades;

import com.relevantcodes.extentreports.ExtentReports;

public class reportesext {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "C:/Users/1727151/Documents/Reportes/primerReporte.html";
		extent = new ExtentReports(Path,false);
		extent
	     .addSystemInfo("Selenium Version", "2.48.2")
	     .addSystemInfo("Platform", "Windows");
		

		return extent;
	}

}
