package helpers;

import frameworkSelenium.Action;
import testObjects.UIMap;

public class ContactHelper extends Action {

	// Envia email com os parametros informados
	public static void CadastraContato(String firstName, String lastName, String adressOne, String adressTwo, String companyName,
										String city, String email, String region, String phoneNumber, String zipCode) {
		ClickElement(UIMap.HomeScreen.button_NewContact);

		TypeField(UIMap.AddContactScreem.textField_FirstName, firstName);

		TypeField(UIMap.AddContactScreem.textField_LastName, lastName);

		TypeField(UIMap.AddContactScreem.textField_AdressOne, adressOne);
		
		TypeField(UIMap.AddContactScreem.textField_AdressTwo, adressTwo);
		
		TypeField(UIMap.AddContactScreem.textField_CompanyName, companyName);
		
		TypeField(UIMap.AddContactScreem.textField_City, city);
		
		TypeField(UIMap.AddContactScreem.textField_Email, email);
		
		TypeField(UIMap.AddContactScreem.textField_Region, region);
		
		TypeField(UIMap.AddContactScreem.textField_PhoneNumber, phoneNumber);
		
		TypeField(UIMap.AddContactScreem.textField_ZipCode, zipCode);
		
		ClickElement(UIMap.AddContactScreem.button_Save);
		
	}
}
