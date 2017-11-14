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
	
//	@FXML
//	private void reds8() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds8.getText());
//		int a=Integer.parseInt(reds8.getText());		 
//		s2controller.red[5]=a;
//		red8=a;
//	}
//	
//	@FXML
//	private void greens8() throws IOException
//	{
//		int a=Integer.parseInt(greens8.getText());
//		s2controller.green[5]=a;
//		green8=a;
//	}
//	
//	@FXML
//	private void blues8() throws IOException
//	{
//		int a=Integer.parseInt(blues8.getText());
//		s2controller.blue[5]=a;
//		blue8=a;
//	}
	
	@FXML
	private void backs8() throws IOException
	{
		int a1=Integer.parseInt(reds8.getText());	
		int a2=Integer.parseInt(greens8.getText());
		int a3=Integer.parseInt(blues8.getText());
		
		
		  int counter=0;
			for(int i=0;i<8;i++)
			{
				if(i!=5)
				{
				if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
				{
					 
									counter=-1;
									
									
									reds8.setText(Integer.toString(red8));
									greens8.setText(Integer.toString(green8));
									blues8.setText(Integer.toString(blue8));
									
									JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
									label.setFont(new Font("Arial", Font.BOLD, 18));
									UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
									int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
									if(input==0)
									{
										//System.out.println(reds8.getText());
										AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s8.fxml"));
										Main.mainLayout.getChildren().setAll(a);
									}
									
									break;
							 
					}
				}
			}	
			
		if(counter==0)
		{
		s2controller.red[5]=a1;
		red8=a1;
		
		
		s2controller.green[5]=a2;
		green8=a2;
		
		
		s2controller.blue[5]=a3;
		blue8=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots8.getChildren().setAll(a);
		Main.give_obj();
		}
	}

}
