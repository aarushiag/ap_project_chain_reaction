package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s9controller 
{
	public static int red9=s2controller.red[6];
	public static int green9=s2controller.green[6];
	public static int blue9=s2controller.blue[6];
	

	@FXML
	private AnchorPane subroots9;
	

	@FXML
	private Button Backs9;
	
	@FXML
	private TextField reds9;
	
	@FXML
	private TextField greens9;
	
	@FXML
	private TextField blues9;
	
	@FXML
	private void initialize() throws IOException
	{
		reds9.setText(Integer.toString(red9));
		greens9.setText(Integer.toString(green9));
		blues9.setText(Integer.toString(blue9));
	}
	
	@FXML
	private void reds9() throws IOException
	{
		//System.out.println("abc");
		//System.out.println(reds9.getText());
		int a=Integer.parseInt(reds9.getText());		 
		s2controller.red[6]=a;
		red9=a;
	}
	
	@FXML
	private void greens9() throws IOException
	{
		int a=Integer.parseInt(greens9.getText());
		s2controller.green[6]=a;
		green9=a;
	}
	
	@FXML
	private void blues9() throws IOException
	{
		int a=Integer.parseInt(blues9.getText());
		s2controller.blue[6]=a;
		blue9=a;
	}
	
	@FXML
	private void backs9() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots9.getChildren().setAll(a1);
	}
}
