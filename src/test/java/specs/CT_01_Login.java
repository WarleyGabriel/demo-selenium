package specs;

import frameworkSelenium.Action;
import frameworkSelenium.FrameworkWeb;
import helpers.LoginLogoutHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import testObjects.DataTest;

public class CT_01_Login {

	@Before
	public void abreSistema() {
		FrameworkWeb.OpenWindowNavigator();
		FrameworkWeb.ToUrl("");

		System.out.println("Teste de login iniciado.");

	}

	@Test
	public void login() throws InterruptedException {
		LoginLogoutHelper.login(DataTest.usuarioAdmin, DataTest.senhaAdmin);

		// Check point após login no sistema
		Action.AssertTextInElements(
				By.xpath("//*[@id=\"main-body\"]/div/div/div[1]/div/h1"),
				"Welcome Back, Warley");
		
		System.out.println("Login realizado.");
		
	}
	
	@After
	public void fechaSistema() {

		System.out.println("Teste de login finalizado.");

	}

}
