package specs;

import frameworkSelenium.Action;
import frameworkSelenium.FrameworkWeb;
import helpers.LoginLogoutHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import testObjects.DataTest;

public class login {

	@Before
	public void abrirSistema() {
		FrameworkWeb.OpenWindowNavigator();
		FrameworkWeb.ToUrl("");
	}

	@Test
	public void fazerLogin() throws InterruptedException {
		LoginLogoutHelper.fazerLogin(DataTest.usuarioAdmin, DataTest.senhaAdmin);

		Action.AssertTextInElements(
				By.xpath("//*[@id=\"main-body\"]/div/div/div[1]/div/h1"),
				"Welcome Back, integration");
	}

	@After
	public void fecharSistema() {
		FrameworkWeb.CloseWindow();
	}
}
