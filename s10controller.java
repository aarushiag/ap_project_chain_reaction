package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s10controller 
{
	public static int red10=s2controller.red[7];
	public static int green10=s2controller.green[7];
	public static int blue10=s2controller.blue[7];
	

	@FXML
	private AnchorPane subroots10;
	

	@FXML
	private Button Backs10;
	
	@FXML
	private TextField reds10;
	
	@FXML
	private TextField greens10;
	
	@FXML
	private TextField blues10;
	
	@FXML
	private void initialize() throws IOException
	{
		reds10.setText(Integer.toString(red10));
		greens10.setText(Integer.toString(green10));
		blues10.setText(Integer.toString(blue10));
	}
//	
//	@FXML
//	private void reds10() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds10.getText());
//		int a=Integer.parseInt(reds10.getText());		 
//		s2controller.red[7]=a;
//		red10=a;
//	}
//	
//	@FXML
//	private void greens10() throws IOException
//	{
//		int a=Integer.parseInt(greens10.getText());
//		s2controller.green[7]=a;
//		green10=a;
//	}
//	
//	@FXML
//	private void blues10() throws IOException
//	{
//		int a=Integer.parseInt(blues10.getText());
//		s2controller.blue[7]=a;
//		blue10=a;
//	}
	
	@FXML
	private void backs10() throws IOException
	{
		int a=Integer.parseInt(reds10.getText());		 
		s2controller.red[7]=a;
		red10=a;
		
		a=Integer.parseInt(greens10.getText());
		s2controller.green[7]=a;
		green10=a;
		
		a=Integer.parseInt(blues10.getText());
		s2controller.blue[7]=a;
		blue10=a;
		
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots10.getChildren().setAll(a1);
	}

}
