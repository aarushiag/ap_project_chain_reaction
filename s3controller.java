package hello.pages;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
import hello.pages.s2controller;

public class s3controller 
{
	 
	public static int red3=s2controller.red[0];
	public static int green3=s2controller.green[0];
	public static int blue3=s2controller.blue[0];
	

	@FXML
	private AnchorPane subroots3;
	

	@FXML
	private Button Backs3;
	
	@FXML
	private TextField reds3;
	
	@FXML
	private TextField greens3;
	
	@FXML
	private TextField blues3;
	
	@FXML
	private void initialize() throws IOException
	{
		reds3.setText(Integer.toString(red3));
		greens3.setText(Integer.toString(green3));
		blues3.setText(Integer.toString(blue3));
	}
	


	
	@FXML
	private void backs3() throws IOException
	{
		int a1=Integer.parseInt(reds3.getText());	
		int a2=Integer.parseInt(greens3.getText());
		int a3=Integer.parseInt(blues3.getText());
		
		int counter=0;
		for(int i=0;i<8;i++)
		{
			if(i!=0)
			{
			if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
			{
				 
								counter=-1;
								
								
								reds3.setText(Integer.toString(red3));
								greens3.setText(Integer.toString(green3));
								blues3.setText(Integer.toString(blue3));
								
								JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one");
								label.setFont(new Font("Arial", Font.BOLD, 18));
								UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
								int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
								if(input==0)
								{
								//	System.out.println(reds3.getText());
									AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s3.fxml"));
									Main.mainLayout.getChildren().setAll(a);
								}
								
								break;
						 
				}
			}
		}		 
	 
		
		if(counter==0)
		{
		
		s2controller.red[0]=a1;
		red3=a1;	
		
		s2controller.green[0]=a2;
		green3=a2;		
		
		s2controller.blue[0]=a3;
		blue3=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots3.getChildren().setAll(a);
		Main.give_obj();
		 
		}
	}
}
