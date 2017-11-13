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
public class s2controller extends AnchorPane
{
	
	public static int[] red=  Main.red;
	public static int[] green=Main.green;
	public static int[] blue= Main.blue;	
	 
	
	
 
	@FXML
	private AnchorPane subroots2;	
 
	@FXML
	private AnchorPane subroots11;
	 
	 
	
	@FXML
	private Button Backs2;	 
	
	@FXML
	private Button Backs11;
	
	
	@FXML
	private Button Player1;
	
	@FXML
	private Button Player2;
	
	@FXML
	private Button Player3;
	
	@FXML
	private Button Player4;
	
	@FXML
	private Button Player5;
	
	@FXML
	private Button Player6;
	
	@FXML
	private Button Player7;
	
	@FXML
	private Button Player8;
	
	
	 
	

	

 
 
 
	
	@FXML
	private void backs11() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
		subroots11.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs2() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
 
 
	
	@FXML
	private void player1() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s3.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	@FXML
	private void player2() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s4.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	@FXML
	private void player3() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s5.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	@FXML
	private void player4() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s6.fxml"));
		subroots2.getChildren().setAll(a1);
	}
//	
	
	@FXML
	private void player5() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s7.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	@FXML
	private void player6() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s8.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	

	@FXML
	private void player7() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s9.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
	@FXML
	private void player8() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s10.fxml"));
		subroots2.getChildren().setAll(a1);
	}
	
 
}
