package hello.pages;
import java.io.IOException;

import hello.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import hello.pages.s1controller;
import hello.pages.s2controller;

public class s3controller 
{
	 
	public static int red3=s2controller.red[0];
	public static int green3=s2controller.green[0];
	public static int blue3=s2controller.blue[0];
	

	@FXML
	private AnchorPane subroots3;
	

	@FXML
	private Button Backs3;
	
	@FXML
	private TextField reds3;
	
	@FXML
	private TextField greens3;
	
	@FXML
	private TextField blues3;
	
	@FXML
	private void initialize() throws IOException
	{
		reds3.setText(Integer.toString(red3));
		greens3.setText(Integer.toString(green3));
		blues3.setText(Integer.toString(blue3));
	}
	


	
	@FXML
	private void backs3() throws IOException
	{
		int a=Integer.parseInt(reds3.getText());		 
		s2controller.red[0]=a;
		red3=a;
		
		a=Integer.parseInt(greens3.getText());
		s2controller.green[0]=a;
		green3=a;
		
		a=Integer.parseInt(blues3.getText());
		s2controller.blue[0]=a;
		blue3=a;
		
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots3.getChildren().setAll(a1);
	}
}
