package hello.pages;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
	
//	@FXML
//	private void reds4() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds4.getText());
//		int a=Integer.parseInt(reds4.getText());		 
//		s2controller.red[1]=a;
//		red4=a;
//	}
//	
//	@FXML
//	private void greens4() throws IOException
//	{
//		int a=Integer.parseInt(greens4.getText());
//		s2controller.green[1]=a;
//		green4=a;
//	}
//	
//	@FXML
//	private void blues4() throws IOException
//	{
//		int a=Integer.parseInt(blues4.getText());
//		s2controller.blue[1]=a;
//		blue4=a;
//	}
	
	@FXML
	private void backs4() throws IOException
	{
		int a1=Integer.parseInt(reds4.getText());	
		int a2=Integer.parseInt(greens4.getText());
	    int a3=Integer.parseInt(blues4.getText());
	    
	    int counter=0;
		for(int i=0;i<8;i++)
		{
			if(i!=1)
			{
			if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
			{
				 
								counter=-1;
								
								
								reds4.setText(Integer.toString(red4));
								greens4.setText(Integer.toString(green4));
								blues4.setText(Integer.toString(blue4));
								
								JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
								label.setFont(new Font("Arial", Font.BOLD, 18));
								UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
								int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
								if(input==0)
								{
									//System.out.println(reds4.getText());
									AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s4.fxml"));
									Main.mainLayout.getChildren().setAll(a);
								}
								
								break;
						 
				}
			}
		}	
		
		if(counter==0)
		{
		s2controller.red[1]=a1;
		red4=a1;
		
		
		s2controller.green[1]=a2;
		green4=a2;
		 

		s2controller.blue[1]=a3;
		blue4=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots4.getChildren().setAll(a);
		Main.give_obj();
		}
	}

}
