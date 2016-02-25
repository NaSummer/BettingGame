import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game extends Application {
	
	Group root;
	int level;

	public Game(int level) {
		this.level = level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// TODO Auto-generated method stub
		primaryStage.setTitle("Gaming now");
		primaryStage.setResizable(false);
		root = new Group();
		Canvas canvas = new Canvas(700, 470);
		Button[] buttons = new Button[level + 1];
		ImageView imageBack = new ImageView(new Image(getClass().getResourceAsStream("/background.png")));
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);

		root.getChildren().add(imageBack);
		root.getChildren().add(canvas);
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

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/game.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
