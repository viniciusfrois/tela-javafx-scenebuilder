package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable{

	@FXML
	private TextField txtValor1;
	@FXML
	private TextField txtValor2;
	@FXML
	private Label lblRes;
	@FXML
	private Button botaoSomar;

	@FXML
	public void onBotaoSomarAction() {
		try {
			Locale.setDefault(Locale.US);
			double valor1 = Double.parseDouble(txtValor1.getText());
			double valor2 = Double.parseDouble(txtValor2.getText());
			double soma = valor1 + valor2;
			lblRes.setText(String.format("%.2f", soma));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Erro", null, e.getMessage(), AlertType.ERROR);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtValor1);
		Constraints.setTextFieldDouble(txtValor2);
		Constraints.setTextFieldMaxLength(txtValor1, 10);
		Constraints.setTextFieldMaxLength(txtValor2, 10);		
	}
}
