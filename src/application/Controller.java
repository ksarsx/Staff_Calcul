package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
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
		System.out.println("k1");
	}
	
	@FXML
	private void onBtnHideReleased(MouseEvent event) {
		System.out.println("k2");
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.setIconified(true);
		
	}
	/*
	 * end of title bar buttons
	 */
	
	
	
	/*
	 * title bar drag label settings
	 */
	@FXML
	private Pane titleBar;
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	@FXML
	private void onMouseEnteredToTitleBar(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		
		parent.setOnMousePressed(null);
	}
	
	@FXML
	public void onMousePressedToTitle(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		
		parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
			}
		});
	}
	
	@FXML
	public void onMouseReleasedFromTitle(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
			
		parent.setOnMousePressed(null);
		parent.setOnMouseDragged(null);
	}
	/*
	 * end of title bar drag label
	 */
	
	
	
	/*
	 * drag borders 
	 */
	
	@FXML
	private void onBorderReleased(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		
		parent.setOnMousePressed(null);
		parent.setOnMouseDragged(null);
	}
	
	private double Y = 0;
	private double deltaY = 0;
	private double X = 0;
	private double deltaX = 0;
	
	private double getWidth(Stage stage) {
		return stage.getWidth();
	}
	private double getHeight(Stage stage) {
		return stage.getHeight();
	}
	
	@FXML
	private void onBorderTopLeftPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Y = event.getSceneY();
				X = event.getSceneX();
			}
		});
		
		parent.setOnMouseDragged(new EventHandler<MouseEvent> () {
			@Override 
			public void handle(MouseEvent event) {
				deltaY = (stage.getY() - (event.getScreenY() - Y));
				deltaX = (stage.getX() - (event.getScreenX() - X));
				if ((getHeight(stage) + deltaY >= 600)) {
					
					System.out.println(deltaX);
					stage.setHeight(stage.getHeight() + deltaY);
					
					stage.setY(stage.getY() - deltaY);
					
					//System.out.println(newHeight + "new Height");
				}
				if (getWidth(stage) + deltaX >= 360) {
					stage.setWidth(stage.getWidth() + deltaX);
					stage.setX(stage.getX() - deltaX);
				}
			}
		});
	}
	
	@FXML
	private void onBorderTopPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				Y = event.getSceneY();
			}
		});
		
		parent.setOnMouseDragged(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				deltaY = stage.getY() - (event.getScreenY() - Y);
					if ((getHeight(stage) + deltaY >= 600)) {
						stage.setHeight(stage.getHeight() + deltaY);
						stage.setY(stage.getY() - deltaY);
						//System.out.println(newHeight + "new Height");
				}
			}
		});
	}
	
	@FXML 
	private void onBorderTopRightPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				X = event.getSceneX() - stage.getWidth();
				Y = event.getSceneY();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				deltaY = (stage.getY() - (event.getScreenY() - Y));
				deltaX = -(stage.getX() - (event.getScreenX() - X) + stage.getWidth());
				
				if (getHeight(stage) + deltaY >= 600) {
					stage.setHeight(stage.getHeight() + deltaY);
					stage.setY(stage.getY() - deltaY);
				}
				if (getWidth(stage) + deltaX >= 360) {
					System.out.println(deltaX);
					stage.setWidth(stage.getWidth() + deltaX);
				}
			}
		});
	}
	
	@FXML 
	private void onBorderLeftPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				X = event.getSceneX();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				deltaX = (stage.getX() - (event.getScreenX() - X));
				if (getWidth(stage) + deltaX >= 360) {
					stage.setWidth(stage.getWidth() + deltaX);
					stage.setX(stage.getX() - deltaX);
				}
			}
		});
	}
	
	@FXML
	private void onBorderRightPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				X = event.getSceneX() - stage.getWidth();
				System.out.println(X);
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				deltaX = -(stage.getX() - (event.getScreenX() - X) + stage.getWidth());
				if (getWidth(stage) + deltaX >= 360) {
					System.out.println(deltaX);
					stage.setWidth(stage.getWidth() + deltaX);
					//stage.setX(stage.getX() - deltaX);
				}
			}
		});
	}
	
	@FXML
	private void onBorderBottomLeftPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				X = event.getSceneX();
				Y = event.getSceneY() - stage.getHeight();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				deltaY = -(stage.getY() - (event.getScreenY() - Y) + stage.getHeight());
				deltaX = (stage.getX() - (event.getScreenX() - X));
				
				if (getHeight(stage) + deltaY >= 600) {
					System.out.println(deltaY);
					stage.setHeight(stage.getHeight() + deltaY);
				}
				if (getWidth(stage) + deltaX >= 360) {
					System.out.println(deltaX);
					stage.setWidth(stage.getWidth() + deltaX);
					stage.setX(stage.getX() - deltaX);
				}
			}
		});
	}
	
	@FXML
	private void onBorderBottomPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Y = event.getSceneY() - stage.getHeight();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				deltaY = -(stage.getY() - (event.getScreenY() - Y) + stage.getHeight());
				if (getHeight(stage) + deltaY >= 600) {
					System.out.println(deltaY);
					stage.setHeight(stage.getHeight() + deltaY);
				}
			}
		});
	}
	
	@FXML
	private void onBorderBottomRightPressed(MouseEvent event) {
		Node source = (Node) event.getSource();
		Parent parent = source.getParent();
		Stage stage = (Stage) source.getScene().getWindow();
		
		parent.setOnMousePressed(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				X = event.getSceneX() - stage.getWidth();
				Y = event.getSceneY() - stage.getHeight();
			}
		});
		parent.setOnMouseDragged(new EventHandler<MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				deltaY = -(stage.getY() - (event.getScreenY() - Y) + stage.getHeight());
				deltaX = -(stage.getX() - (event.getScreenX() - X) + stage.getWidth());
				if (getHeight(stage) + deltaY >= 600) {
					System.out.println(deltaY);
					stage.setHeight(stage.getHeight() + deltaY);
					stage.setY(stage.getY());
				}
				if (getWidth(stage) + deltaX >= 360) {
					System.out.println(deltaX);
					stage.setWidth(stage.getWidth() + deltaX);
					
					stage.setX(stage.getX());
				}
			}
		});
	}
	
	
	
	/*
	 * finish of drag borders
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
