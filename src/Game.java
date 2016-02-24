import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game extends Application {
Group root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Gaming now"); 
		primaryStage.setResizable(false);
		root = new Group();  
        Canvas canvas = new Canvas(700, 470);
        
        
	}

}
