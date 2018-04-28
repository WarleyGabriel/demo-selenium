package frameworkSelenium;

import logs.Logs;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FrameworkWeb {

	// Objeto que possibilita a interação com a janela do navegador.
	protected static WebDriver driver = GetDriver();

	// Flag para verificar se é necessário criar outra instância de Driver.
	protected static boolean fechouJanela = true;

	// Objeto wait utilizado para aguardar que determinadas condições aconteçam.
	// antes de os testes prosseguirem.
	protected static WebDriverWait wait = null;

	// URL do servidor no qual será rodado os testes.
	private static String urlBase = "https://phptravels.org/";

	// Retorna uma instância de driver para interação com o navegador.
	// Cria uma nova instância do driver.
	public static WebDriver GetDriver() {
		if (fechouJanela) {

			String exePath = System.getProperty("user.dir") + "/src/resources/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);

			WebDriver novaInstanciaDriver = new ChromeDriver();

			fechouJanela = false;

			return novaInstanciaDriver;

		}

		return driver;
	}

	// Acessa uma URL da URL base.
	public static void ToUrl(String url) {
		String urlDeAcesso = urlBase + url;

		driver.navigate().to(urlDeAcesso);
	}

	// Cria uma janela do navegador.
	public static void OpenWindowNavigator() {
		try {

			driver = GetDriver();

			GetDriver().manage().window().maximize();

		} catch (IllegalStateException ex) {
			CloseWindow();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex2) {

				ex2.printStackTrace();
			}

			OpenWindowNavigator();

		}
	}

	// Fecha a janela do navegador que foi aberta.
	public static void CloseWindow() {
		GetDriver().quit();

		fechouJanela = true;
	}

	// Aguarda até que todas as requisições Ajax sejam concluídas.
	public static boolean WaitCallAjax() {
		WebDriverWait wait = new WebDriverWait(GetDriver(), 30);

		// Espera até JQuery ser carregado.
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) GetDriver()).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// jQuery não presente.
					return true;
				}
			}
		};

		// Espera até Javascript ser carregado.
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) GetDriver()).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	// Retorna o elemento encontrado pelo localizador informado.
	public static WebElement GetElement(By localizador) {
		WebElement elemento = null;

		WaitCallAjax();

		try {
			GetWaitObject().until(ExpectedConditions.presenceOfElementLocated(localizador));

			elemento = GetDriver().findElement(localizador);
		} catch (Exception excecao) {

			System.err.println(excecao.getMessage());

			Logs.ErrorLog(localizador.toString(), excecao);
		}

		return elemento;

	}

	// Retorna uma instância de wait para definir tempos e condições de espera.
	public static WebDriverWait GetWaitObject() {
		wait = new WebDriverWait(GetDriver(), 8);

		wait.pollingEvery(500, TimeUnit.MILLISECONDS);

		return wait;
	}

	// Aguarda até que um elemento fique visível na tela.
	public static boolean WaitElementVisible(By localizador) {
		try {
			GetWaitObject().until(ExpectedConditions.visibilityOfElementLocated(localizador));

			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	// Aguarda até que um elemento possa ser clicado.
	public static void WaitElementClicable(By localizador) {
		try {
			GetWaitObject().until(ExpectedConditions.elementToBeClickable(localizador));
		} catch (Exception ex) {

		}

	}

	// Atualiza pagina.
	public static void RefreshPage() {
		GetDriver().navigate().refresh();
	}

	// Muda resolução da tela
	public static void ChangeScreemResolution(int largura, int altura) {
		driver.manage().window().setSize(new Dimension(largura, altura));
	}

	// Retorna o Elemento.Text de um elemento.
	public static String GetTextElement(By localizador) {
		WebElement elemento = null;

		try {

			elemento = GetElement(localizador);

			return elemento.getText();

		} catch (Exception excecao) {

			if (excecao instanceof StaleElementReferenceException) {

				elemento = GetElement(localizador);

				return elemento.getText();

			} else {

				Logs.ErrorLog(elemento.toString(), excecao);

				return null;
			}

		}
	}
}
