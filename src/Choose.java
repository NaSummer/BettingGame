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

	Choose choose;
	Stage primaryStage;
	
	private int money = 1500;
	Button btn_level1 = new Button("Easy");
	Button btn_level2 = new Button("Normal");
	Button btn_level3 = new Button("Hard");
	Button btn_level4 = new Button("Extreme");
	Button btn_level5 = new Button("Impossible");
	Button btn_explanation = new Button("Explanation");
	Label titleLabel = new Label("Select your difficulty level");
	Label moneyLabel = new Label("money:" + money);
	Group root = new Group();
	
	// === Constructor ===
	public Choose() {
		this.choose = this;
	}
	
	public Choose(int money) {
		this.choose = this;
		this.money = money;
	}
	
	// === main ===
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
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
		
		btn_explanation.setLayoutX(560);
		btn_explanation.setLayoutY(420);

		titleLabel.setLayoutX(10);
		moneyLabel.setLayoutX(560);

		btn_level1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startGame(1);
			}
		});
		btn_level2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startGame(2);
			}
		});
		btn_level3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startGame(3);
			}
		});
		btn_level4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startGame(4);
			}
		});
		btn_level5.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startGame(5);
			}
		});
		
		btn_explanation.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				openExplanation();
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
		root.getChildren().add(btn_explanation);
		root.getChildren().add(titleLabel);
		root.getChildren().add(moneyLabel);

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/Choose.css");

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void openExplanation() {
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					primaryStage.hide();
					new Explanation(choose).start(new Stage());
				} catch (Exception e) {
					System.err.println("Open new Explanation window fail.");
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void startGame(int level) {
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					primaryStage.hide();
					new Game(choose, level).start(new Stage());
				} catch (Exception e) {
					System.err.println("Open new game window fail (level " + level + ").");
					e.printStackTrace();
				}
			}
		});
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
