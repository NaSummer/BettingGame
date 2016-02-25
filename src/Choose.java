
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Choose extends Application {
private int initialMoney = 1500;
Button level1Button = new Button("Easy");
Button level2Button = new Button("Normal");
Button level3Button = new Button("Hard");
Button level4Button = new Button("Extreme");
Button level5Button = new Button("Impossible");

	public int getInitialMoney() {
		return initialMoney;
	}
	public void setInitialMoney(int initialMoney) {
		this.initialMoney = initialMoney;
	}
	public Choose() {
	
	}
Label titleLabel = new Label("Select your difficulty level");
Label moneyLabel = new Label("money:"+ initialMoney);
int level = 1;
Group root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Choose"); 
		primaryStage.setResizable(false);
        root = new Group();  
        Canvas canvas = new Canvas(700, 470);
        level1Button = new Button("Easy");
        ImageView imageBack = new ImageView(new Image(getClass() 
                .getResourceAsStream("/1234.jpg"))); 
//		image2.resize(500, 400);
		imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);
		
        // 设置button们
        level1Button.setLayoutX(250);
        level1Button.setLayoutY(50);
        level1Button.setPrefSize(210, 50);
        
        level2Button.setLayoutX(250);
        level2Button.setLayoutY(130);
        level2Button.setPrefSize(210, 50);
        
        level3Button.setLayoutX(250);
        level3Button.setLayoutY(210);
        level3Button.setPrefSize(210, 50);
        
        level4Button.setLayoutX(250);
        level4Button.setLayoutY(290);
        level4Button.setPrefSize(210, 50);
        
        level5Button.setLayoutX(250);
        level5Button.setLayoutY(370);
        level5Button.setPrefSize(210, 50);
        
        titleLabel.setLayoutX(10);
        moneyLabel.setLayoutX(560);
        
        
        level1Button.setOnMouseClicked(new EventHandler<MouseEvent>(){
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
        
        level2Button.setOnMouseClicked(new EventHandler<MouseEvent>(){
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
        
        level3Button.setOnMouseClicked(new EventHandler<MouseEvent>(){
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
        
        level4Button.setOnMouseClicked(new EventHandler<MouseEvent>(){
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
        level5Button.setOnMouseClicked(new EventHandler<MouseEvent>(){
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

        //添加组件到面板
        root.getChildren().add(canvas);
        root.getChildren().add(imageBack);
        root.getChildren().add(level1Button);
        root.getChildren().add(level2Button);
        root.getChildren().add(level3Button);
        root.getChildren().add(level4Button);
        root.getChildren().add(level5Button);
        root.getChildren().add(titleLabel);
        root.getChildren().add(moneyLabel);
        
        
        Scene scene = new Scene(root);
		scene.getStylesheets().add("/Choose.css");
        
        primaryStage.setScene(scene);  
        primaryStage.show(); 

	}
}
