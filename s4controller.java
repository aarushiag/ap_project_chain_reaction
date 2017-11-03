package hello.pages;

import java.io.IOException;

import hello.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class s4controller 
{
	public static int red4=s2controller.red[1];
	public static int green4=s2controller.green[1];
	public static int blue4=s2controller.blue[1];
	

	@FXML
	private AnchorPane subroots4;
	

	@FXML
	private Button Backs4;
	
	@FXML
	private TextField reds4;
	
	@FXML
	private TextField greens4;
	
	@FXML
	private TextField blues4;
	
	@FXML
	private void initialize() throws IOException
	{
		reds4.setText(Integer.toString(red4));
		greens4.setText(Integer.toString(green4));
		blues4.setText(Integer.toString(blue4));
	}
	
	@FXML
	private void reds4() throws IOException
	{
		//System.out.println("abc");
		//System.out.println(reds4.getText());
		int a=Integer.parseInt(reds4.getText());		 
		s2controller.red[1]=a;
		red4=a;
	}
	
	@FXML
	private void greens4() throws IOException
	{
		int a=Integer.parseInt(greens4.getText());
		s2controller.green[1]=a;
		green4=a;
	}
	
	@FXML
	private void blues4() throws IOException
	{
		int a=Integer.parseInt(blues4.getText());
		s2controller.blue[1]=a;
		blue4=a;
	}
	
	@FXML
	private void backs4() throws IOException
	{
		AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots4.getChildren().setAll(a1);
	}

}
