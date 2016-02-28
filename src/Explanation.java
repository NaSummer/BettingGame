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
	
	Label lab_gameName = new Label("Expanation");
	Label lab_explanation = new Label();
	Button btn_back = new Button();
	Group root = new Group();

	public Explanation(Choose choose) {
		this.choose = choose;
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		
		// TODO add explanation
		lab_explanation.setText("aa");

		primaryStage.setTitle("Game Explanation");
		primaryStage.setResizable(false);
		Canvas canvas = new Canvas(700, 470);
		ImageView imageBack = new ImageView(new Image(getClass().getResourceAsStream("/background.png")));
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);

		lab_gameName.setLayoutX(300);
		lab_gameName.setLayoutY(10);
		lab_explanation.setLayoutX(50);
		lab_explanation.setLayoutY(100);
		btn_back.setLayoutX(10);
		btn_back.setLayoutY(450);

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
