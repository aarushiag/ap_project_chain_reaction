package hello;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane mainLayout;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Chain Reaction Game");
		showMainView();
	    //showMainPage();
		
	}
	
	private void showMainView() throws IOException
	{
		FXMLLoader loader =new FXMLLoader();
		loader.setLocation(Main.class.getResource("pages/s1.fxml"));
		mainLayout=loader.load();		
		scene=new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	    //primaryStage.setResizable(false);
	}
	
//	private void showMainPage() throws IOException
//	{
//		FXMLLoader loader =new FXMLLoader();
//		loader.setLocation(Main.class.getResource("pages/s2.fxml"));
//		mainLayout.setCenter(loader.load());
//	}
	
//	
//	public void showAboutView() throws IOException
//	{
//		FXMLLoader loader =new FXMLLoader();
//		loader.setLocation(Main.class.getResource("pages/s11.fxml"));
//		BorderPane a1=loader.load();
//		mainLayout.setCenter(a1);
//	}

	public static void main(String[] args) {
		launch(args);
	}
}
