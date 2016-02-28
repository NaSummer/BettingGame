import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Game extends Application {
	
	private final int MAX_TIMES = 3;
	
	Choose choose;
	
	Label lab_level;
	Label lab_rightNum;
	Label lab_nowMoney;
	Label lab_counter;
	Group root = new Group();
	private int money;
	private int level;
	private int counter;
	private int rightAnswer;
	private int rightCount;
	Button[] buttons;
	
	int price[][] = {{-200, -711, -1350, -2048, -2778}, {0, 0, 0, 0, 0}, {27, 90, 213, 417, 720}, {160, 810, 2560, 6250, 12960}}; 

	public Game(Choose choose, int level) {
		this.level = level;
		this.money = choose.getMoney();
		this.counter = 0;
		this.rightAnswer = 0;
		this.rightCount = 0;
		this.choose = choose;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("l:" + level);

		primaryStage.setTitle("Gaming now");
		primaryStage.setResizable(false);
		Canvas canvas = new Canvas(700, 470);
		ImageView imageBack = new ImageView(new Image(getClass().getResourceAsStream("/background.png")));
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);

		buttons = new Button[level + 1];
		lab_level = new Label("Level: " + level);
		lab_rightNum = new Label("Right: " + rightCount);
		lab_counter = new Label("Counter: " + counter);
		lab_nowMoney = new Label("Money: " + money);

		lab_level.setLayoutX(10);
		lab_rightNum.setLayoutX(100);
		lab_nowMoney.setLayoutX(560);
		lab_counter.setLayoutX(190);

		root.getChildren().add(imageBack);
		root.getChildren().add(canvas);
		root.getChildren().add(lab_level);
		root.getChildren().add(lab_rightNum);
		root.getChildren().add(lab_nowMoney);
		root.getChildren().add(lab_counter);

		// add buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button("" + (i + 1));
			buttons[i].setPrefSize(100, 50);
			buttons[i].setLayoutY(200);
			if (buttons.length == 2) {
				buttons[i].setLayoutX(200 + 200 * i);
			}
			if (buttons.length == 3) {
				buttons[i].setLayoutX(150 + 150 * i);
			}
			if (buttons.length == 4) {
				buttons[i].setLayoutX(70 + 150 * i);
			}
			if (buttons.length == 5) {
				buttons[i].setLayoutX(150 * i);
			}
			if (buttons.length == 6) {
				if (i == 5) {
					buttons[i].setLayoutX(300);
					buttons[i].setLayoutY(270);
				} else {
					buttons[i].setLayoutX(150 * i);
				}
			}
			root.getChildren().add(buttons[i]);
		}

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// 随机建一个正确答案
					rightAnswer = (int) (Math.random() * level);
					System.out.println("right" + rightAnswer);
					counter++;
					lab_counter.setText("Counter: " + counter);
					if (event.getSource().equals(buttons[rightAnswer])) {
						rightCount++;
						lab_rightNum.setText("Right: " + rightCount);
						System.out.println("right!!");
					} else {
						System.out.println("wrong!!");
					}
					
					// game over
					if (counter == MAX_TIMES) {
						money += price[rightCount][level];
						choose.setMoney(money);
						choose.moneyLabel.setText("Money: " + money);
						choose.primaryStage.show();
						primaryStage.close();
					}
					// Stage secondWindow=new Stage();
					// Group root = new Group();
					// Scene scene=new Scene(root,300,275);
					// secondWindow.setTitle("secondWindow");
					// secondWindow.setScene(scene);
					// secondWindow.show();
				}
			});
			// buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			// @Override
			// public void handle(MouseEvent event) {
			// rightAnswer = (int) (Math.random() * level);
			// System.out.println(rightAnswer);
			// System.out.println("wrong!!");
			// }
			// });
		}

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/game.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}
