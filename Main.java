package hello;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

 
 
import javafx.event.Event;
import javafx.event.EventHandler;
 
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
 
 
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


class player
{
	int index;
	int num_atom;
	int num_cell;
}


class atom{
	int num;
	int player_index;
	Main ch;
	public Sphere crc;
	public Group molatom;
	public atom(Main ch){
		num=1;
		this.ch=ch;
		player_index=ch.turn;
		crc=new Sphere();
		crc.setRadius(10);
		change_color(crc);
		molatom=new Group();
		molatom.getChildren().add(crc);
	}
	public Group get_atom(){
		return molatom;
	}
	public int get_player_num(){
		return player_index;
	}
	public void change_color(Sphere crc){
		player_index=ch.turn;
		final PhongMaterial redm=new PhongMaterial();
		redm.setDiffuseColor(Color.RED);
		redm.setSpecularColor(Color.BLACK);
		final PhongMaterial greenm=new PhongMaterial();
		greenm.setDiffuseColor(Color.GREEN);
		greenm.setSpecularColor(Color.BLACK);
		final PhongMaterial bluem=new PhongMaterial();
		bluem.setDiffuseColor(Color.BLUE);
		bluem.setSpecularColor(Color.BLACK);
		final PhongMaterial pinkm=new PhongMaterial();
		pinkm.setDiffuseColor(Color.PINK);
		pinkm.setSpecularColor(Color.BLACK);
		final PhongMaterial yellowm=new PhongMaterial();
		yellowm.setDiffuseColor(Color.YELLOW);
		yellowm.setSpecularColor(Color.BLACK);
		final PhongMaterial cyanm=new PhongMaterial();
		cyanm.setDiffuseColor(Color.CYAN);
		cyanm.setSpecularColor(Color.BLACK);
		final PhongMaterial purplem=new PhongMaterial();
		purplem.setDiffuseColor(Color.PURPLE);
		purplem.setSpecularColor(Color.BLACK);
		final PhongMaterial whitem=new PhongMaterial();
		whitem.setDiffuseColor(Color.WHITE);
		whitem.setSpecularColor(Color.BLACK);
		crc.setRadius(10);
		if (ch.turn==0)crc.setMaterial(redm);
		if (ch.turn==1)crc.setMaterial(greenm);
		if (ch.turn==2)crc.setMaterial(bluem);
		if (ch.turn==3)crc.setMaterial(pinkm);
		if (ch.turn==4)crc.setMaterial(yellowm);
		if (ch.turn==5)crc.setMaterial(cyanm);
		if (ch.turn==6)crc.setMaterial(purplem);
		if (ch.turn==7)crc.setMaterial(whitem);
		
	}
}


class atom2 extends atom{
	public Sphere crc2; 
	public atom2(Main ch){
		super(ch);
		num=2;
		crc2=new Sphere();
		crc2.setRadius(10);
		change_color(crc2);
		crc2.setTranslateX(15);
	 
		molatom.getChildren().add(crc2);
	 
	}
	public void change_color(){
		super.change_color(crc);
		super.change_color(crc2);
	}
}

class atom3 extends atom2{
	public Sphere crc3;
	public atom3(Main ch){
		super(ch);
		num=3;
		crc3=new Sphere();
		crc3.setRadius(10);
		change_color(crc3);
		crc3.setTranslateX(8);
		crc3.setTranslateY(15);
		molatom.getChildren().add(crc3);
 
	}
	public void change_color(){
		super.change_color(crc);
		super.change_color(crc2);
		super.change_color(crc3);
	}
}

class cell extends StackPane{
	private Rectangle r;
	private Main ch;
	//private Label l;
	private int value;
	public int gx;
	public int gy;
	public atom a;
	private int threshold;
	public cell(Main ch,int gx,int gy,int x,int y,int width,int height){
		r=new Rectangle(width,height);
		r.setStroke(Color.RED);
		r.setFill(Color.BLACK);
		 
		this.ch=ch;
		value=0;
		this.gx=gx;
		this.gy=gy;
		if ((gx==0)&&(gy==0))threshold=1;
		else if ((gx==5)&&(gy==0))threshold=1;
		else if ((gx==0)&&(gy==8))threshold=1;
		else if ((gx==5)&&(gy==8))threshold=1;
		else if (gx==0)threshold=2;
		else if (gy==0)threshold=2;
		else if (gx==5)threshold=2;
		else if (gy==8)threshold=2;
		else threshold=3;
		setTranslateX(x);
		setTranslateY(y);
		getChildren().addAll(r);
	}
 
	public Rectangle get_rectangle(){
		return r;
	}
	public int get_value(){
		return value;
	}
	public void increase_value(boolean toggle){
		if (value==0){
			a=new atom(ch);
			value++;
			if (toggle==true)ch.turn=(ch.turn+1)%8;
			else {
				System.out.println("neighbour burst");
				a.change_color(a.crc);
			}
			this.getChildren().add(a.molatom);
		}
		else if ((value==1)&&(ch.turn==a.get_player_num())){
			a=new atom2(ch);
			atom2 a1=(atom2)a;
			value++;
			if (toggle==true)ch.turn=(ch.turn+1)%8;
			else{
				System.out.println("neighbour burst");
				a1.change_color();
			}
			this.getChildren().add(a1.molatom);
		}
		else if ((value==2)&&(ch.turn==a.get_player_num())){
			a=new atom3(ch);
			atom3 a1=(atom3)a;
			value++;
			if (toggle==true)ch.turn=(ch.turn+1)%8;
			else{
				System.out.println("neighbour burst");
				a1.change_color();
			}
			this.getChildren().add(a1.molatom);
		}
	}
	public void burst_the_cell(){
		value=0;
		System.out.println("cell burst");
		this.getChildren().remove(a.molatom);
		if ((gx-1>=0)&&(gy>=0))ch.gr[gx-1][gy].change_value(false);
		if ((gx+1<=5)&&(gy>=0))ch.gr[gx+1][gy].change_value(false);
		if ((gx>=0)&&(gy-1>=0))ch.gr[gx][gy-1].change_value(false);
		if ((gx>=0)&&(gy+1<=8))ch.gr[gx][gy+1].change_value(false);
		//a=null;
	}
	public boolean change_value(boolean toggle){
		System.out.println(gx+" "+gy);
		if (value<threshold){
			increase_value(toggle);
			return false;
		}
		else {
			burst_the_cell();
			return true;
		}
	}
 
}


class grid{
	private cell[][] now_grid;
	private Rectangle r;
	public grid(cell[][] now_grid){
		this.now_grid=now_grid;
		r=new Rectangle();
		r.setHeight(550);
		r.setWidth(500);
		r.setFill(Color.TRANSPARENT);
	}
	public Rectangle get_rectangle(){
		return r;
	}
	
	 
	
}
public class Main extends Application 
{	
	
	private Stage primaryStage;
	public static AnchorPane mainLayout;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Chain Reaction Game");
		showMainView();
	     
		
	}
	
	private void showMainView() throws IOException
	{
		FXMLLoader loader =new FXMLLoader();
		loader.setLocation(Main.class.getResource("pages/s1.fxml"));
		mainLayout=loader.load();		
		scene=new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	    
	}
	

	public static int turn=0;
	public cell[][] gr;
	class cell_click_event implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent m){
			System.out.println("cell click");
			cell temp=(cell)m.getSource();
			System.out.println(temp.gx+" "+temp.gy);
			if (temp.get_value()!=0)temp.getChildren().remove(temp.a.get_atom());
			boolean b=temp.change_value(true); 
				if (b==true){
				turn=(turn+1)%8;
			
			}
		 
			System.out.println("click identified");
			for (int i=0;i<6;i++){
				for (int j=0;j<9;j++){
					Rectangle r1=gr[i][j].get_rectangle();
					if (turn==0)r1.setStroke(Color.RED);
					if (turn==1)r1.setStroke(Color.GREEN);
					if (turn==2)r1.setStroke(Color.BLUE);
					if (turn==3)r1.setStroke(Color.PINK);
					if (turn==4)r1.setStroke(Color.YELLOW);
					if (turn==5)r1.setStroke(Color.CYAN);
					if (turn==6)r1.setStroke(Color.PURPLE);
					if (turn==7)r1.setStroke(Color.SNOW);
				}
			}
		}
	}
    
	public void play1(AnchorPane a1) throws IOException
	{
		mainLayout.getChildren().setAll(a1);
		Group root=new Group();
		int n=6;
		int m=9;
		gr=new cell[n][m];
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				cell c=new cell(this,i,j,i*50+50,j*50+70,50,50);
				root.getChildren().add(c);
				gr[i][j]=c;
				c.setOnMouseClicked(new cell_click_event());
				 
			}
		}
//		grid g=new grid(gr);
	//	System.out.println(mainLayout);
		mainLayout.getChildren().add(root);
//		Scene scene=new Scene(root,500,550,Color.BLACK);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
