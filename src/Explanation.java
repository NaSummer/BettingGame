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

/**
 * @author Qiufan(Andy) Xu
 * @date CreateTime: Feb 27, 2016 6:22:13 PM
 * @version 1.0
 * @param
 */

public class Explanation extends Application {

	Choose choose;
	Stage primaryStage;
	
	private Label lab_gameName = new Label("Expanation");
	private Label lab_explanation = new Label();
	private Button btn_back = new Button("Back");

	public Explanation(Choose choose) {
		this.choose = choose;
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		
		lab_explanation.setMaxWidth(600);
		lab_explanation.setWrapText(true);
		lab_explanation.setText("\tThis game has 5 difficulties. The number of buttons will change with the gaming level. "
				+ "\n\tEach round of the game has one correct button, and you need to choose three times, and the right button keeps change. "
				+ "\n\tPlayer has $1500 when he first entered this game. After each round of the game, the player gets or loses his fund. "
				+ "\n\tFund is important in the game. Player need enough money to start the game, (and player can buy tools to help him get a better score)."
				+ "\n     Win"
				+ "\n    Time\tEasy\tNormal\tHard\t  Extreme   Impossible"
				+ "\n       0\t-$200\t-$711\t-$1350\t  -$2048     -$2778"
				+ "\n       1\t+$0\t+$0\t+$0\t  +$0\t     +$0"
				+ "\n       2\t+$27\t+$90\t+$213\t  +$417\t     +$720"
				+ "\n       3\t+$160\t+$810\t+$2560\t  +$6250    +$12960");
		
		
		primaryStage.setTitle("Game Explanation");
		primaryStage.setResizable(false);
		Canvas canvas = new Canvas(700, 470);
		ImageView imageBack = new ImageView(new Image(getClass().getResourceAsStream("/background.png")));
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);

		lab_gameName.setLayoutX(290);
		lab_gameName.setLayoutY(20);
		lab_explanation.setLayoutX(50);
		lab_explanation.setLayoutY(60);
		btn_back.setLayoutX(615);
		btn_back.setLayoutY(420);

		Group root = new Group();
		root.getChildren().add(imageBack);
		root.getChildren().add(canvas);
		root.getChildren().add(lab_explanation);
		root.getChildren().add(lab_gameName);
		root.getChildren().add(btn_back);

		btn_back.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				choose.primaryStage.show();
				primaryStage.close();
			}
		});

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/game.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
