package specs;

import frameworkSelenium.Action;
import frameworkSelenium.FrameworkWeb;
import helpers.ContactHelper;
import helpers.LoginLogoutHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import testObjects.DataTest;

public class cadastrarContato {

	@Before
	public void abrirSistema() {
		FrameworkWeb.OpenWindowNavigator();
		FrameworkWeb.ToUrl("");
		LoginLogoutHelper.fazerLogin(DataTest.usuarioAdmin, DataTest.senhaAdmin);
	}

	@Test
	public void cadastrarContato() throws InterruptedException {
		ContactHelper.CadastrarContato("First Name", "Last Name", "Rua da Automação", "numero 01", "Apple", "Goiânia",
				"testesautomatizados@selenium.com", "Centro-Oeste", "6299913131313", "74000000");

		Action.AssertTextInElements(By.xpath("//*[@id=\"main-body\"]/div/div/div[3]/div[1]"),
				"Changes Saved Successfully!");
	}

	@After
	public void fecharSistema() {
		FrameworkWeb.CloseWindow();
	}
}
