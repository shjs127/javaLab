package sec07.exam03_chatting.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
/*		primaryStage.setTitle("Client");
		Parent root= FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setWidth(350);       //윈도우의 고정 폭 설정
		primaryStage.setHeight(500);      //윈도우의 고정 높이 설정
		primaryStage.setResizable(false);   //윈도우 크기를 조정할 수 없도록 함
		primaryStage.show();*/
		
		
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> System.exit(0));
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


