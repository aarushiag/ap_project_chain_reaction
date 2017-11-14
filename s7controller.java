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

public class s7controller
{
	public static int red7=s2controller.red[4];
	public static int green7=s2controller.green[4];
	public static int blue7=s2controller.blue[4];
	

	@FXML
	private AnchorPane subroots7;
	

	@FXML
	private Button Backs7;
	
	@FXML
	private TextField reds7;
	
	@FXML
	private TextField greens7;
	
	@FXML
	private TextField blues7;
	
	@FXML
	private void initialize() throws IOException
	{
		reds7.setText(Integer.toString(red7));
		greens7.setText(Integer.toString(green7));
		blues7.setText(Integer.toString(blue7));
	}
//	
//	@FXML
//	private void reds7() throws IOException
//	{
//		//System.out.println("abc");
//		//System.out.println(reds7.getText());
//		int a=Integer.parseInt(reds7.getText());		 
//		s2controller.red[4]=a;
//		red7=a;
//	}
//	
//	@FXML
//	private void greens7() throws IOException
//	{
//		int a=Integer.parseInt(greens7.getText());
//		s2controller.green[4]=a;
//		green7=a;
//	}
//	
//	@FXML
//	private void blues7() throws IOException
//	{
//		int a=Integer.parseInt(blues7.getText());
//		s2controller.blue[4]=a;
//		blue7=a;
//	}
//	
	@FXML
	private void backs7() throws IOException
	{
		int a1=Integer.parseInt(reds7.getText());
		int a2=Integer.parseInt(greens7.getText());
		int a3=Integer.parseInt(blues7.getText());
		
		  int counter=0;
			for(int i=0;i<8;i++)
			{
				if(i!=4)
				{
				if(s2controller.red[i]==a1 && s2controller.green[i]==a2 && s2controller.blue[i]==a3)
				{
					 
									counter=-1;
									
									
									reds7.setText(Integer.toString(red7));
									greens7.setText(Integer.toString(green7));
									blues7.setText(Integer.toString(blue7));
									
									JLabel label = new JLabel("Sorry!This colour belongs to another player.Choose another one.");
									label.setFont(new Font("Arial", Font.BOLD, 18));
									UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
									int input =JOptionPane.showOptionDialog(null, label,"Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
									if(input==0)
									{
										//System.out.println(reds4.getText());
										AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s7.fxml"));
										Main.mainLayout.getChildren().setAll(a);
									}
									
									break;
							 
					}
				}
			}
		if(counter==0)
		{
		s2controller.red[4]=a1;
		red7=a1;
		
		
		s2controller.green[4]=a2;
		green7=a2;
		
		
		s2controller.blue[4]=a3;
		blue7=a3;
		AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s2.fxml"));
		subroots7.getChildren().setAll(a);
		Main.give_obj();
		}
	}
}
