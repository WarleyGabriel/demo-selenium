package specs;

import frameworkSelenium.Action;
import frameworkSelenium.FrameworkWeb;
import helpers.ContactHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CT_02_CadastraContato {

	@Before
	public void abreSistema() {

		System.out.println("Teste de cadastro iniciado.");

	}

	@Test
	public void enviaEmail() throws InterruptedException {

		ContactHelper.CadastraContato("First Name", "Last Name", "Rua da Automação", "numero 01", "Apple", "Goiânia",
				"testesautomatizados@selenium.com", "Centro-Oeste", "6299913131313", "74000000");

		// Check point após cadastro ser realizado
		Action.AssertTextInElements(By.xpath("//*[@id=\"main-body\"]/div/div/div[3]/div[1]"),
				"Changes Saved Successfully!");

		System.out.println("Cadastro realizado.");

	}

	@After
	public void fechaSistema() {
		FrameworkWeb.CloseWindow();

		System.out.println("Teste de cadastro finalizado.");

	}

}
