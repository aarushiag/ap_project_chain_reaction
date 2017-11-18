package hello.pages;

 
import java.io.IOException;

import hello.ExceptionClass;
import hello.Main;
import hello.pages.s2controller;
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
public class s1controller extends AnchorPane
{
	
	 
	ObservableList<String> lst =FXCollections.observableArrayList("2 Player Game","3 Player Game","4 Player Game","5 Player Game","6 Player Game","7 Player Game","8 Player Game");
	static String a =Integer.toString(Main.num_players);	
	static String init=a+" Player Game";
	  
	static int num=0;
	public static Button undo;
	 
	@FXML
	private  AnchorPane subroots1;	
	 
	@FXML
	private ComboBox<String> nplayers;
	
	@FXML
	private Button PLay1;
	
	@FXML
	private Button PLay2;
	
	@FXML
	private Button Resume;
	
	@FXML
	private Button Aboutgame;
	
	@FXML
	private Button Settings;
	
	@FXML
	private Button Oneplayer;
	
 
	
	@FXML
	private void aboutgame() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s11.fxml"));
		subroots1.getChildren().setAll(a1);
	}
	
 
	@FXML
	private void resumegame() throws IOException, ClassNotFoundException, ExceptionClass
	
	{
//		to_serialize obj=Main.deserialize("1");
//		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top1.fxml")); 	 
//		s2controller obj1=new s2controller();
	try
	{
		Main obj=new Main();
		obj.resumeGame();
	}
	catch(ExceptionClass e)
	{
		System.out.println(e.getMessage());
	}
	}
	
	
	@FXML
	public void settings() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots1.getChildren().setAll(a1);
	}
 
	
	@FXML
	private void initialize() throws IOException, ClassNotFoundException
	{
		 int a=Main.give_num_player();
		 if(a!=0)
		 {
			init=Integer.toString(a)+ " Player Game";
			num=a-2;
		 }
		 
		 nplayers.setItems(lst);
		 nplayers.setValue(init);
 
	}
	
	@FXML
	private void todo() throws IOException
	{
		  
		 init=nplayers.getSelectionModel().getSelectedItem();
		// Main obj=new Main();
		 num=nplayers.getSelectionModel().getSelectedIndex();
		// System.out.println(num);
		 Main.num_players=num+2;
		 Main.give_obj();
		
		 
	}
	
	@FXML
	public  void play1() throws IOException
	{
		 
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top.fxml")); 	 
		s2controller obj1=new s2controller();
	
		Main obj=new Main();
		obj.play1(undo,a1,num,obj1.red,obj1.green,obj1.blue,6,9);
		 
	}
	
	@FXML
	public  void play2( ) throws IOException
	{
		 
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top1.fxml")); 	 
		s2controller obj1=new s2controller();
	
		Main obj=new Main();
		obj.play1(undo,a1,num,obj1.red,obj1.green,obj1.blue,10,15);
		 
	}
	
	@FXML
	private void oneplayer() throws IOException
	{
		 Main obj=new Main();
		 obj.oneplayer();
	}
//	@FXML
	
//	public  void play2(AnchorPane a2) throws IOException
//	{
//		 
//		 
//		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top.fxml")); 		 
//		a2.getChildren().setAll(a1);
//		Main obj=new Main();
//		obj.play1(a1);
//	}
}
