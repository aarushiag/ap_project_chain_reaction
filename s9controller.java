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
	
//	@FXML
//	private void reds9() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds9.getText());
//		int a=Integer.parseInt(reds9.getText());		 
//		s2controller.red[6]=a;
//		red9=a;
//	}
//	
//	@FXML
//	private void greens9() throws IOException
//	{
//		int a=Integer.parseInt(greens9.getText());
//		s2controller.green[6]=a;
//		green9=a;
//	}
//	
//	@FXML
//	private void blues9() throws IOException
//	{
//		int a=Integer.parseInt(blues9.getText());
//		s2controller.blue[6]=a;
//		blue9=a;
//	}
//	
	@FXML
	private void backs9() throws IOException
	{
		int a1=Integer.parseInt(reds9.getText());
		int a2=Integer.parseInt(greens9.getText());
		int a3=Integer.parseInt(blues9.getText());
		
		  int counter=0;
			for(int i=0;i<8;i++)
			{
				if(i!=6)
				{
				if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
				{
					 
									counter=-1;
									
									
									reds9.setText(Integer.toString(red9));
									greens9.setText(Integer.toString(green9));
									blues9.setText(Integer.toString(blue9));
									
									JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
									label.setFont(new Font("Arial", Font.BOLD, 18));
									UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
									int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
									if(input==0)
									{
										//System.out.println(reds9.getText());
										AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s9.fxml"));
										Main.mainLayout.getChildren().setAll(a);
									}
									
									break;
							 
					}
				}
			}	
		if(counter==0)
		{
		s2controller.red[6]=a1;
		red9=a1;
		
		
		s2controller.green[6]=a2;
		green9=a2;
		
		
		s2controller.blue[6]=a3;
		blue9=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots9.getChildren().setAll(a);
		Main.give_obj();
		}
	}
}
