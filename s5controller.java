package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s5controller 
{
	public static int red5=s2controller.red[2];
	public static int green5=s2controller.green[2];
	public static int blue5=s2controller.blue[2];
	

	@FXML
	private AnchorPane subroots5;
	

	@FXML
	private Button Backs5;
	
	@FXML
	private TextField reds5;
	
	@FXML
	private TextField greens5;
	
	@FXML
	private TextField blues5;
	
	@FXML
	private void initialize() throws IOException
	{
		reds5.setText(Integer.toString(red5));
		greens5.setText(Integer.toString(green5));
		blues5.setText(Integer.toString(blue5));
	}
	
//	@FXML
//	private void reds5() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds5.getText());
//		int a=Integer.parseInt(reds5.getText());		 
//		s2controller.red[2]=a;
//		red5=a;
//	}
//	
//	@FXML
//	private void greens5() throws IOException
//	{
//		int a=Integer.parseInt(greens5.getText());
//		s2controller.green[2]=a;
//		green5=a;
//	}
//	
//	@FXML
//	private void blues5() throws IOException
//	{
//		int a=Integer.parseInt(blues5.getText());
//		s2controller.blue[2]=a;
//		blue5=a;
//	}
	
	@FXML
	private void backs5() throws IOException
	{
		int a=Integer.parseInt(reds5.getText());		 
		s2controller.red[2]=a;
		red5=a; 
		
		a=Integer.parseInt(greens5.getText());
		s2controller.green[2]=a;
		green5=a;
		
		a=Integer.parseInt(blues5.getText());
		s2controller.blue[2]=a;
		blue5=a;
		
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots5.getChildren().setAll(a1);
	}

}
