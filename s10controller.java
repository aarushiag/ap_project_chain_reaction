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
		int a1=Integer.parseInt(reds10.getText());
		int a2=Integer.parseInt(greens10.getText());
		int a3=Integer.parseInt(blues10.getText());
		  int counter=0;
			for(int i=0;i<8;i++)
			{
				if(i!=7)
				{
				if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
				{
					 
									counter=-1;
									
									
									reds10.setText(Integer.toString(red10));
									greens10.setText(Integer.toString(green10));
									blues10.setText(Integer.toString(blue10));
									
									JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
									label.setFont(new Font("Arial", Font.BOLD, 18));
									UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
									int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
									if(input==0)
									{
										//System.out.println(reds10.getText());
										AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s10.fxml"));
										Main.mainLayout.getChildren().setAll(a);
									}
									
									break;
							 
					}
				}
			}	
		
		if(counter==0)
		{
		s2controller.red[7]=a1;
		red10=a1;
		
		
		s2controller.green[7]=a2;
		green10=a2;
		
		
		s2controller.blue[7]=a3;
		blue10=a3;
		
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots10.getChildren().setAll(a);
		Main.give_obj();
		}
	}

}
