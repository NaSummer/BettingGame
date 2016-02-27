import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Choose extends Application {

	private int initialMoney = 1500;
	Button btn_level1 = new Button("Easy");
	Button btn_level2 = new Button("Normal");
	Button btn_level3 = new Button("Hard");
	Button btn_level4 = new Button("Extreme");
	Button btn_level5 = new Button("Impossible");
	Label titleLabel = new Label("Select your difficulty level");
	Label moneyLabel = new Label("money:" + initialMoney);
	int level = 1;
	Group root = new Group();
	
	// === Constructor ===
	public Choose() {
	}
	// === main ===
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Choose");
		primaryStage.setResizable(false);

		Canvas canvas = new Canvas(700, 470);
		ImageView imageBack = new ImageView(new Image(getClass().getResourceAsStream("/1234.jpg")));

		// image2.resize(500, 400);
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);

		// set buttons
		btn_level1.setLayoutX(250);
		btn_level1.setLayoutY(50);
		btn_level1.setPrefSize(210, 50);

		btn_level2.setLayoutX(250);
		btn_level2.setLayoutY(130);
		btn_level2.setPrefSize(210, 50);

		btn_level3.setLayoutX(250);
		btn_level3.setLayoutY(210);
		btn_level3.setPrefSize(210, 50);

		btn_level4.setLayoutX(250);
		btn_level4.setLayoutY(290);
		btn_level4.setPrefSize(210, 50);

		btn_level5.setLayoutX(250);
		btn_level5.setLayoutY(370);
		btn_level5.setPrefSize(210, 50);

		titleLabel.setLayoutX(10);
		moneyLabel.setLayoutX(560);

		btn_level1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				level = 1;
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new Game(level).start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});

		btn_level2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				level = 2;
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new Game(level).start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});

		btn_level3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				level = 3;
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new Game(level).start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});

		btn_level4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				level = 4;
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new Game(level).start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});
		btn_level5.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				level = 5;
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new Game(level).start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});

		// 添加组件到面板
		root.getChildren().add(canvas);
		root.getChildren().add(imageBack);
		root.getChildren().add(btn_level1);
		root.getChildren().add(btn_level2);
		root.getChildren().add(btn_level3);
		root.getChildren().add(btn_level4);
		root.getChildren().add(btn_level5);
		root.getChildren().add(titleLabel);
		root.getChildren().add(moneyLabel);

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/Choose.css");

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public int getInitialMoney() {
		return initialMoney;
	}
	
	public void setInitialMoney(int initialMoney) {
		this.initialMoney = initialMoney;
	}
	
}
