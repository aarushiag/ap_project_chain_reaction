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
		int a1=Integer.parseInt(reds5.getText());	
		int a2=Integer.parseInt(greens5.getText());
	    int a3=Integer.parseInt(blues5.getText());
	    
	    int counter=0;
		for(int i=0;i<8;i++)
		{
			if(i!=2)
			{
			if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
			{
				 
								counter=-1;
								
								
								reds5.setText(Integer.toString(red5));
								greens5.setText(Integer.toString(green5));
								blues5.setText(Integer.toString(blue5));
								System.out.println(i);
								JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
								label.setFont(new Font("Arial", Font.BOLD, 18));
								UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
								int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
								if(input==0)
								{
									//System.out.println(reds5.getText());
									AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s5.fxml"));
									Main.mainLayout.getChildren().setAll(a);
								}
								
								break;
						 
				}
			}
		}	
		
		if(counter==0)
		{
		s2controller.red[2]=a1;
		red5=a1;
		
		
		s2controller.green[2]=a2;
		green5=a2;
		 

		s2controller.blue[2]=a3;
		blue5=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots5.getChildren().setAll(a);
		Main.give_obj();
		}

	}
}
