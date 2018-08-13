package helpers;

import frameworkSelenium.Action;
import testObjects.UIMap;

public class LoginLogoutHelper extends Action {

	public static void fazerLogin(String usuario, String senha) {
		TypeField(UIMap.LoginScreen.textField_Usuario, usuario);

		TypeField(UIMap.LoginScreen.textField_Senha, senha);

		ClickElement(UIMap.LoginScreen.button_Entrar);
	}
}
