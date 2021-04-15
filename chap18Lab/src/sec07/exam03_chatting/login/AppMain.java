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
		primaryStage.setWidth(350);       //�������� ���� �� ����
		primaryStage.setHeight(500);      //�������� ���� ���� ����
		primaryStage.setResizable(false);   //������ ũ�⸦ ������ �� ������ ��
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


