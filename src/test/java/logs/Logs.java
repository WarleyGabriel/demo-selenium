package logs;

import java.io.File;
import java.io.FileWriter;

public class Logs {

	// Diretorio onde sera gerado os logs de teste.
	private static String CaminhoLog = System.getProperty("user.dir") + "java/logs";

	// Metodo que grava em arquivo .txt as exceções encontradas.
	public static void ErrorLog(String elemento, Exception excecao) {
		StackTraceElement[] stk = Thread.currentThread().getStackTrace();

		String metodoChamador = String.format("LineNumber : %s, ClassName : %s, MethodName : %s, SourceLocation : %s",
				stk[2].getLineNumber(), stk[2].getClassName(), stk[2].getMethodName(), stk[2].getFileName());
		FileWriter arquivo;
		String Text;

		try {

			CreateDirectory(CaminhoLog);

			arquivo = new FileWriter((CaminhoLog + "\\Logs.txt"), true);

			Text = ("EXCECAO: " + excecao.getMessage() + " \r\nELEMENTO: " + elemento + " \r\nMETODO: " + metodoChamador
					+ " \r\n\n");

			arquivo.write(Text);
			arquivo.close();

		} catch (Exception ex) {

			System.out.println("Falha ao acessar os arquivos de log!");

			System.out.println(ex.getMessage());
		}
	}

	// Metodo que cria pasta para os logs serem salvos dentro.
	public static void CreateDirectory(String caminhoPasta) {
		File theDir = new File(caminhoPasta);

		// Se diretorio não existe, o mesmo é criado.
		if (!theDir.exists()) {
			System.out.println("Criando o diretorio: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// Exceção, diretorio não foi criado.
			}
			if (result) {
				System.out.println("Diretorio criado.");
			}
		}
	}

}
