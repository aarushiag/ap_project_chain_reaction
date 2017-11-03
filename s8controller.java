package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s8controller {
	public static int red8=s2controller.red[5];
	public static int green8=s2controller.green[5];
	public static int blue8=s2controller.blue[5];
	

	@FXML
	private AnchorPane subroots8;
	

	@FXML
	private Button Backs8;
	
	@FXML
	private TextField reds8;
	
	@FXML
	private TextField greens8;
	
	@FXML
	private TextField blues8;
	
	@FXML
	private void initialize() throws IOException
	{
		reds8.setText(Integer.toString(red8));
		greens8.setText(Integer.toString(green8));
		blues8.setText(Integer.toString(blue8));
	}
	
	@FXML
	private void reds8() throws IOException
	{
		//System.out.println("abc");
		//System.out.println(reds8.getText());
		int a=Integer.parseInt(reds8.getText());		 
		s2controller.red[5]=a;
		red8=a;
	}
	
	@FXML
	private void greens8() throws IOException
	{
		int a=Integer.parseInt(greens8.getText());
		s2controller.green[5]=a;
		green8=a;
	}
	
	@FXML
	private void blues8() throws IOException
	{
		int a=Integer.parseInt(blues8.getText());
		s2controller.blue[5]=a;
		blue8=a;
	}
	
	@FXML
	private void backs8() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots8.getChildren().setAll(a1);
	}

}
