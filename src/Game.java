import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game extends Application{
Label levelLabel;
Label rightNum;
Label nowMoney;
Group root;
int level;
int rightAnswer;
int rightCount = 0;
Button[] buttons;

	public Game(int level) {
		this.level = level;
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//随机建一个正确答案
		Choose choose = new Choose();
		rightAnswer = (int)(Math.random()*level);
		System.out.println(rightAnswer);
		System.out.println("l:"+level);
		
		buttons = new Button[level+1];
		levelLabel = new Label("Level: "+level);
		rightNum = new Label("Right: "+rightCount);
		nowMoney = new Label("Money: "+ choose.getInitialMoney());
		
		levelLabel.setLayoutX(10);
		rightNum.setLayoutX(100);
		nowMoney.setLayoutX(560);
		
		primaryStage.setTitle("Gaming now"); 
		primaryStage.setResizable(false);
		root = new Group();  
        Canvas canvas = new Canvas(700, 470);
        ImageView imageBack = new ImageView(new Image(getClass() 
                .getResourceAsStream("/background.png")));
        imageBack.setFitWidth(700);
		imageBack.setFitHeight(470);
		
        root.getChildren().add(imageBack);
        root.getChildren().add(canvas);
        root.getChildren().add(levelLabel);
        root.getChildren().add(rightNum);
        root.getChildren().add(nowMoney);
        // add some buttons
        for(int i=0;i<buttons.length;i++){
        	buttons[i] = new Button(""+(i+1));
        	buttons[i].setPrefSize(100, 50);
        	buttons[i].setLayoutY(200);
        	if(buttons.length==2){
        		buttons[i].setLayoutX(200 + 200*i);
        	}
        	if(buttons.length==3){
        		buttons[i].setLayoutX(150 + 150*i);
        	}
        	if(buttons.length==4){
        		buttons[i].setLayoutX(70 + 150*i);
        	}
        	if(buttons.length==5){
        		buttons[i].setLayoutX(150*i);
        	}
        	if(buttons.length==6){
        		if(i==5){
        			buttons[i].setLayoutX(300);
        			buttons[i].setLayoutY(270);
        		}else{
        			buttons[i].setLayoutX(150*i);
        		}
			}
        	root.getChildren().add(buttons[i]);
        }
        for(int i=0;i<buttons.length;i++){
        	if(i==rightAnswer){
        		buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>(){
        			@Override
        			public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						rightCount++;
						rightNum.setText("Right: "+rightCount);
						rightAnswer = (int)(Math.random()*level);
						System.out.println(rightAnswer);
						System.out.println("right!!");
//						Stage secondWindow=new Stage();
//						Group root = new Group();
//						Scene scene=new Scene(root,300,275);
//						secondWindow.setTitle("secondWindow");
//						secondWindow.setScene(scene);
//						secondWindow.show();
					}
        		});
        	}else{
        		buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>(){
        			@Override
        			public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						rightAnswer = (int)(Math.random()*level);
						System.out.println(rightAnswer);
						System.out.println("wrong!!");
					}
        		});
        	}
        } 
        
        
        Scene scene = new Scene(root);
		scene.getStylesheets().add("/game.css");     
        primaryStage.setScene(scene);  
        primaryStage.show(); 
	}
		

}
