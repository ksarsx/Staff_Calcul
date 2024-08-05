package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
	
	
	/*
	 * title bar
	 */
	
	@FXML
	private Pane titleBar;
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	/*
	 * title bar buttons
	 */
	@FXML
	private Pane btnClose;
	
	@FXML
	private void onBtnCloseReleased(MouseEvent event) {
		System.out.println("released");
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void onBtnFullReleased(MouseEvent event) {
		
	}
	
	@FXML
	private void onBtnHideReleased(MouseEvent event) {
		
	}
	/*
	 * end of title bar buttons
	 */
	
	
	
	/*
	 * gala code
	 */
	
	
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private void clickNumberSeven(ActionEvent event){
		String text = resultLabel.getText();
		resultLabel.setText(text + "7");
	}
	
	
	
	/*
	 * finish gala code
	 */
	
	
}
