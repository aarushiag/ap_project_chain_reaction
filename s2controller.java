package hello.pages;

 
import java.io.IOException;

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
public class s2controller extends AnchorPane
{
	
	 
	 
	
	
	
	 
	@FXML
	private AnchorPane subroots2;
	
	@FXML
	private AnchorPane subroots3;
	
	@FXML
	private AnchorPane subroots4;
	
	@FXML
	private AnchorPane subroots5;
	
	@FXML
	private AnchorPane subroots6;
	
	@FXML
	private AnchorPane subroots7;
	
	@FXML
	private AnchorPane subroots8;
	
	@FXML
	private AnchorPane subroots9;
	
	@FXML
	private AnchorPane subroots10;
	
	@FXML
	private AnchorPane subroots11;
	 
	 
	
	@FXML
	private Button Backs2;
	
	@FXML
	private Button Backs3;
	@FXML
	private Button Backs4;
	@FXML
	private Button Backs5;
	@FXML
	private Button Backs6;
	@FXML
	private Button Backs7;
	@FXML
	private Button Backs8;
	@FXML
	private Button Backs9;
	@FXML
	private Button Backs10;
	 
	
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
	private void backs3() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots3.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs4() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots4.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs5() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots5.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs6() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots6.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs7() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots7.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs8() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots8.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs9() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots9.getChildren().setAll(a1);
	}
	
	@FXML
	private void backs10() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots10.getChildren().setAll(a1);
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
