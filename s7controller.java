package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s7controller
{
	public static int red7=s2controller.red[4];
	public static int green7=s2controller.green[4];
	public static int blue7=s2controller.blue[4];
	

	@FXML
	private AnchorPane subroots7;
	

	@FXML
	private Button Backs7;
	
	@FXML
	private TextField reds7;
	
	@FXML
	private TextField greens7;
	
	@FXML
	private TextField blues7;
	
	@FXML
	private void initialize() throws IOException
	{
		reds7.setText(Integer.toString(red7));
		greens7.setText(Integer.toString(green7));
		blues7.setText(Integer.toString(blue7));
	}
//	
//	@FXML
//	private void reds7() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds7.getText());
//		int a=Integer.parseInt(reds7.getText());		 
//		s2controller.red[4]=a;
//		red7=a;
//	}
//	
//	@FXML
//	private void greens7() throws IOException
//	{
//		int a=Integer.parseInt(greens7.getText());
//		s2controller.green[4]=a;
//		green7=a;
//	}
//	
//	@FXML
//	private void blues7() throws IOException
//	{
//		int a=Integer.parseInt(blues7.getText());
//		s2controller.blue[4]=a;
//		blue7=a;
//	}
//	
	@FXML
	private void backs7() throws IOException
	{
		int a=Integer.parseInt(reds7.getText());		 
		s2controller.red[4]=a;
		red7=a;
		
		a=Integer.parseInt(greens7.getText());
		s2controller.green[4]=a;
		green7=a;
		
		a=Integer.parseInt(blues7.getText());
		s2controller.blue[4]=a;
		blue7=a;
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots7.getChildren().setAll(a1);
	}
}
