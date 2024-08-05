package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
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
	
	
	
}
