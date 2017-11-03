package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s6controller {
	public static int red6=s2controller.red[3];
	public static int green6=s2controller.green[3];
	public static int blue6=s2controller.blue[3];
	

	@FXML
	private AnchorPane subroots6;
	

	@FXML
	private Button Backs6;
	
	@FXML
	private TextField reds6;
	
	@FXML
	private TextField greens6;
	
	@FXML
	private TextField blues6;
	
	@FXML
	private void initialize() throws IOException
	{
		reds6.setText(Integer.toString(red6));
		greens6.setText(Integer.toString(green6));
		blues6.setText(Integer.toString(blue6));
	}
	
	@FXML
	private void reds6() throws IOException
	{
		//System.out.println("abc");
		//System.out.println(reds6.getText());
		int a=Integer.parseInt(reds6.getText());		 
		s2controller.red[3]=a;
		red6=a;
	}
	
	@FXML
	private void greens6() throws IOException
	{
		int a=Integer.parseInt(greens6.getText());
		s2controller.green[3]=a;
		green6=a;
	}
	
	@FXML
	private void blues6() throws IOException
	{
		int a=Integer.parseInt(blues6.getText());
		s2controller.blue[3]=a;
		blue6=a;
	}
	
	@FXML
	private void backs6() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots6.getChildren().setAll(a1);
	}

}
