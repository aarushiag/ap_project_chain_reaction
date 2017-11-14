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
	
//	@FXML
//	private void reds6() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds6.getText());
//		int a=Integer.parseInt(reds6.getText());		 
//		s2controller.red[3]=a;
//		red6=a;
//	}
//	
//	@FXML
//	private void greens6() throws IOException
//	{
//		int a=Integer.parseInt(greens6.getText());
//		s2controller.green[3]=a;
//		green6=a;
//	}
//	
//	@FXML
//	private void blues6() throws IOException
//	{
//		int a=Integer.parseInt(blues6.getText());
//		s2controller.blue[3]=a;
//		blue6=a;
//	}
//	
	@FXML
	private void backs6() throws IOException
	{
		int a1=Integer.parseInt(reds6.getText());	
		int a2=Integer.parseInt(greens6.getText());
	    int a3=Integer.parseInt(blues6.getText());
	    
	    int counter=0;
		for(int i=0;i<8;i++)
		{
			if(i!=3)
			{
			if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
			{
				 
								counter=-1;
								
								
								reds6.setText(Integer.toString(red6));
								greens6.setText(Integer.toString(green6));
								blues6.setText(Integer.toString(blue6));
								
								JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
								label.setFont(new Font("Arial", Font.BOLD, 18));
								UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
								int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
								if(input==0)
								{
									//System.out.println(reds6.getText());
									AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s6.fxml"));
									Main.mainLayout.getChildren().setAll(a);
								}
								
								break;
						 
				}
			}
		}	
		
		if(counter==0)
		{
		s2controller.red[3]=a1;
		red6=a1;
		
		
		s2controller.green[3]=a2;
		green6=a2;
		 

		s2controller.blue[3]=a3;
		blue6=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots6.getChildren().setAll(a);
		
		Main.give_obj();
		}
	}

}
