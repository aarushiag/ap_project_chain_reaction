package hello.pages;

 
import java.io.IOException;

import hello.ExceptionClass;
import hello.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import hello.pages.s1controller;
public class topcontroller extends AnchorPane
{
	
	 
	 
	
	@FXML
	private AnchorPane top; 
	 
 
	
	@FXML
	private Button Undo;
	
	@FXML
	private ComboBox<String> options;
	
	 
	
	ObservableList<String> lst =FXCollections.observableArrayList("New Game","Settings","Back");
	@FXML
	private void initialize() throws IOException
	{
		 
		options.setItems(lst);
		s1controller.undo=Undo;
		  
	}
	
//	@FXML
//	public void disable(boolean a) throws IOException
//	{
//		//System.out.println(Undo);
//		Undo.setDisable(a);
//		 
//		  
//	}
	
	@FXML
	private void undo() throws IOException, ClassNotFoundException
	{
		 
		Main obj=new Main();
		try {
			obj.undobutton();
		} catch (ExceptionClass e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		  
	}
	
	
	
	@FXML
	private void options() throws IOException
	{
		 
		 String a=options.getSelectionModel().getSelectedItem();
		 //System.out.println(a);
		 if (a.equals("New Game"))
		 {
			// AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
			 s1controller obj=new s1controller();
			  
			 obj.play1();
		 }
		 
		 if (a.equals("Settings"))
		 {
			 AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
			 Main.mainLayout.getChildren().setAll(a1);
		 }
		 
		 if (a.equals("Back"))
		 {
			 AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
			 Main.mainLayout.getChildren().setAll(a1);
		 }
		 
	}
	
	@FXML
	private void options1() throws IOException
	{
		 
		 String a=options.getSelectionModel().getSelectedItem();
		 //System.out.println(a);
		 if (a.equals("New Game"))
		 {
			// AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
			 s1controller obj=new s1controller();
			 
			 obj.play2();
		 }
		 
		 if (a.equals("Settings"))
		 {
			 AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
			 Main.mainLayout.getChildren().setAll(a1);
		 }
		 
		 if (a.equals("Back"))
		 {
			 AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
			 Main.mainLayout.getChildren().setAll(a1);
		 }
		 
	}
	 
 
}
