package testObjects;

import org.openqa.selenium.By;

public class UIMap {

	public static class LoginScreen {
		public static By textField_Usuario = By.id("inputEmail");

		public static By textField_Senha = By.id("inputPassword");

		public static By button_Entrar = By.id("login");
	}

	public static class HomeScreen {
		public static By button_NewContact = By.xpath("//*[@id=\"main-body\"]/div/div/div[4]/div[1]/div[3]/a");
	}
	
	public static class AddContactScreem {
		public static By textField_FirstName = By.id("inputFirstName");

		public static By textField_LastName = By.id("inputLastName");

		public static By textField_AdressOne = By.id("inputAddress1");

		public static By textField_AdressTwo = By.id("inputAddress2");
		
		public static By textField_CompanyName = By.id("inputCompanyName");
		
		public static By textField_City = By.id("inputCity");
		
		public static By textField_Email = By.id("inputEmail");
		
		public static By textField_Region = By.id("stateinput");
		
		public static By textField_PhoneNumber = By.id("inputPhone");
		
		public static By textField_ZipCode = By.id("inputPostcode");
		
		public static By button_Save = By.xpath("//*[@id=\"main-body\"]/div/div/div[3]/form/div[4]/input[1]");
	}

}