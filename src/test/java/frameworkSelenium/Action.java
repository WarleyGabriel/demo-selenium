package frameworkSelenium;

import logs.Logs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action extends FrameworkWeb {

	// Método para realiza click em qualquer elemento do sistema.
	public static void ClickElement(By localizador) {
		WebElement element = null;
		Actions actions = null;

		try {
			element = GetElement(localizador);
			WaitElementVisible(localizador);
			actions = new Actions(GetDriver());
			actions.moveToElement(element);
			actions.perform();
			WaitElementClicable(localizador);
			element.click();
			WaitCallAjax();
		} catch (Exception excecao) {
			if (excecao instanceof StaleElementReferenceException) {
				ClickElement(localizador);
			} else {
				Logs.ErrorLog(localizador.toString(), excecao);
			}
		}
	}

	// Digita um texto em um campo.
	public static void TypeField(By localizador, String texto) {
		WebElement field = GetElement(localizador);

		try {
			WaitCallAjax();
			WaitElementVisible(localizador);
			field.clear();
			Thread.sleep(250);
			field.sendKeys(texto);
			WaitCallAjax();
		} catch (Exception excecao) {
			Logs.ErrorLog(localizador.toString(), excecao);
		}
	}

	// Seleciona um elemento em uma lista estática.
	public static void SelectListElement(By localizador, String elemento) {
		WaitCallAjax();
		WaitElementVisible(localizador);
		new Select(GetDriver().findElement(localizador)).selectByVisibleText(elemento);
	}

	// Verifica se um elemento está presente na tela atual.
	public static boolean CheckItemPresent(By localizador) {
		try {
			GetDriver().findElement(localizador);
			return true;
		} catch (ElementNotVisibleException ex) {
			return false;
		}
	}

	// Apaga todos os caracteres em um campo texto.
	public static void ClearFieldText(By localizador) {
		try {
			WebElement element = GetElement(localizador);
			element.clear();
		} catch (Exception ex) {
			Logs.ErrorLog(localizador.toString(), ex);
		}
	}

	public static void AssertTextInElements(By localizador, String texto) {
		String textoNoElemento = GetTextElement(localizador);
		Assert.assertEquals(texto, textoNoElemento);
	}
}
