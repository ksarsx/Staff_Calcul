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
	
	@FXML
	private void clickNumberEight(ActionEvent event){
		String text = resultLabel.getText();
		resultLabel.setText(text + "8");
	}
	
	@FXML
	private void clickNumberNine(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "9");
	}
	
	@FXML
	private void clickNumberSix(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "6");
	}
	
	@FXML
	private void clickNumberThree(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "3");
	}
	
	@FXML
	private void clickNumberFour(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "4");
	}
	
	@FXML
	private void clickNumberFive(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "5");
	}
	
	@FXML
	private void clickNumberTwo(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "2");
	}
	
	@FXML
	private void clickNumberOne(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "1");
	}
	
	@FXML
	private void clickNumberNull(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + "0");
	}
	@FXML
	private void clickDot(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText(text + ".");
	}
	
	@FXML
	private void clickRemoveButton(ActionEvent event) {
		String text = resultLabel.getText();
		resultLabel.setText("");
	}
	
	
	
	
	/*
	 * finish gala code
	 */
	
	
}
