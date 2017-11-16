package hello;

//made by Aarushi Agarwal (2016216) and Arushi Chauhan(2016019)
//import java.nio.file.Path;

//import java.nio.file.Path;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Circle;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

//import chain_test1.atom;
//import chain_test1.atom2;
//import chain_test1.atom3;
//import chain_test1.chain2;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;

//import javafx.event.EventListener;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line ;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.control.Button;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
 
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
//import java.awt.Font;
  
//import java.awt.Font;
//---------------------------------
//ISSUES
//1.need to map players to turn indexes when other players are eliminated--->>done
//2.no splitting animation
//3.convert grid
//4.allow change in number of players--->>done
//5.allow change in size of grid--->>done
//6.allow elimination of players--->>done
//7.serialisation
//8.allow change of colors--->>done
//9.undo option
//---------------------------------
//SOLVED ISSUES
//4.allow change in number of players
//8.allow change of colors
//1.need to map players to turn indexes when other players are eliminated
//5.allow change in size of grid
//6.allow elimination of players
//---------------------------------
class player implements Serializable{
	int index;
	int num_atom;
	int num_cell;
	boolean alive=true;
	int red;
	int green;
	int blue;
	public player(int index,int red,int green,int blue){
		this.index=index;
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	public void kill_player(){
		alive=false;
	}
	public int get_red(){
		return red;
	}
	public int get_green(){
		return green;
	}
	public int get_blue(){
		return blue;
	}
}
class atom implements Serializable{
	int num;
	int player_index;
	Main ch;
	public Sphere crc;
	public Group molatom;
	public int gx;
	public int gy;
	public atom(Main ch,boolean color_sasta,int gx,int gy){
		num=1;
		this.ch=ch;
		this.gx=gx;
		this.gy=gy;
		player_index=ch.turn;
		crc=new Sphere();
		crc.setRadius(10);
		change_color(crc,color_sasta);
		molatom=new Group();
		molatom.getChildren().add(crc);
	}
	public Group get_atom(){
		return molatom;
	}
	public int get_player_num(){
		return player_index;
	}
	public void change_color(Sphere crc,boolean color_sasta){
		//System.out.println("hi :)");
		player_index=ch.turn;
		if (color_sasta==true)player_index=ch.prev_turn;
		player_index=ch.gr1[gx][gy].player_index;
		System.out.println("hi :) "+player_index);
		final PhongMaterial redm=new PhongMaterial();
		redm.setDiffuseColor(Color.rgb(ch.red[0],ch.green[0],ch.blue[0]));
		redm.setSpecularColor(Color.BLACK);
		final PhongMaterial greenm=new PhongMaterial();
		greenm.setDiffuseColor(Color.rgb(ch.red[1],ch.green[1],ch.blue[1]));
		greenm.setSpecularColor(Color.BLACK);
		final PhongMaterial bluem=new PhongMaterial();
		bluem.setDiffuseColor(Color.rgb(ch.red[2],ch.green[2],ch.blue[2]));
		bluem.setSpecularColor(Color.BLACK);
		final PhongMaterial pinkm=new PhongMaterial();
		pinkm.setDiffuseColor(Color.rgb(ch.red[3],ch.green[3],ch.blue[3]));
		pinkm.setSpecularColor(Color.BLACK);
		final PhongMaterial yellowm=new PhongMaterial();
		yellowm.setDiffuseColor(Color.rgb(ch.red[4],ch.green[4],ch.blue[4]));
		yellowm.setSpecularColor(Color.BLACK);
		final PhongMaterial cyanm=new PhongMaterial();
		cyanm.setDiffuseColor(Color.rgb(ch.red[5],ch.green[5],ch.blue[5]));
		cyanm.setSpecularColor(Color.BLACK);
		final PhongMaterial purplem=new PhongMaterial();
		purplem.setDiffuseColor(Color.rgb(ch.red[6],ch.green[6],ch.blue[6]));
		purplem.setSpecularColor(Color.BLACK);
		final PhongMaterial whitem=new PhongMaterial();
		whitem.setDiffuseColor(Color.rgb(ch.red[7],ch.green[7],ch.blue[7]));
		whitem.setSpecularColor(Color.BLACK);
		crc.setRadius(10);
		//-------------------------------------------------
		//!!! This part needs to change when players will be eliminated
		if (player_index==0)crc.setMaterial(redm);
		if (player_index==1)crc.setMaterial(greenm);
		if (player_index==2)crc.setMaterial(bluem);
		if (player_index==3)crc.setMaterial(pinkm);
		if (player_index==4)crc.setMaterial(yellowm);
		if (player_index==5)crc.setMaterial(cyanm);
		if (player_index==6)crc.setMaterial(purplem);
		if (player_index==7)crc.setMaterial(whitem);
		//-------------------------------------------------
		
	}
}
class atom2 extends atom implements Serializable{
	public Sphere crc2;
	//public Group diatom;
	public atom2(Main ch,boolean color_sasta,int gx,int gy){
		super(ch,color_sasta,gx,gy);
		num=2;
		crc2=new Sphere();
		crc2.setRadius(10);
		change_color(crc2,color_sasta);
		crc2.setTranslateX(15);
		//diatom=new Group();
		//diatom.getChildren().add(crc);
		molatom.getChildren().add(crc2);
		/*Rotate rotate=new Rotate();
		rotate.setAngle(20);
		rotate.setPivotX(150);
		rotate.setPivotY(225);
		molatom.getTransforms().addAll(rotate);*/
	}
	public void change_color(boolean color_sasta){
		super.change_color(crc,color_sasta);
		super.change_color(crc2,color_sasta);
	}
}
class atom3 extends atom2 implements Serializable{
	public Sphere crc3;
	public atom3(Main ch,boolean color_sasta,int gx,int gy){
		super(ch,color_sasta,gx,gy);
		num=3;
		crc3=new Sphere();
		crc3.setRadius(10);
		change_color(crc3,color_sasta);
		crc3.setTranslateX(8);
		crc3.setTranslateY(15);
		molatom.getChildren().add(crc3);
		/*Rotate rotate=new Rotate();
		rotate.setAngle(20);
		rotate.setPivotX(150);
		rotate.setPivotY(225);
		molatom.getTransforms().addAll(rotate);*/
	}
	public void change_color(boolean color_sasta){
		super.change_color(crc,color_sasta);
		super.change_color(crc2,color_sasta);
		super.change_color(crc3,color_sasta);
	}
}
class cell extends Pane implements Serializable{
	private Rectangle r;
	private Main ch;
	//private Label l;
	public int value;
	public int gx;
	public int gy;
	public int x;
	public int y;
	public atom a1;
	public atom2 a2;
	public atom3 a3;
	public Group molatom;
	public Group animate;
	private int threshold;
	//public int player_index;
	public cell(Main ch,int gx,int gy,int x,int y,int width,int height){
		r=new Rectangle(width,height);
		r.setStroke(Color.rgb(ch.red[ch.turn],ch.green[ch.turn],ch.blue[ch.turn]));
		r.setFill(Color.TRANSPARENT);
		//Label l=new Label(new String("0"));
		//this.setOnMouseClicked(new cell_click_event());
		this.ch=ch;
		value=0;
		this.gx=gx;
		this.gy=gy;
		this.x=x;
		this.y=y;
		//hor and ver change here--->>done
		if ((gx==0)&&(gy==0))threshold=1;
		else if ((gx==ch.hor-1)&&(gy==0))threshold=1;
		else if ((gx==0)&&(gy==ch.ver-1))threshold=1;
		else if ((gx==ch.hor-1)&&(gy==ch.ver-1))threshold=1;
		else if (gx==0)threshold=2;
		else if (gy==0)threshold=2;
		else if (gx==ch.hor-1)threshold=2;
		else if (gy==ch.ver-1)threshold=2;
		else threshold=3;
		setTranslateX(x);
		setTranslateY(y);
		animate=new Group();
		getChildren().addAll(r);
		//System.out.println(r.getX()+" "+r.getY());
	}
	/*class cell_click_event implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent m){
			System.out.println("cell click");
			if (ch.turn!=10)r.setFill(Color.BROWN);
		}
	}*/
	public Rectangle get_rectangle(){
		return r;
	}
	public int get_player_index(){
		System.out.println(a1+" "+a2+" "+a3);
		if (value==1)return a1.player_index;
		else if (value==2)return a2.player_index;
		else if (value==3)return a3.player_index;
		else return 0;
	}
	public int get_value(){
		return value;
	}
	public void value_plus(){
		value++;
	}
	public void compute_increase_value(boolean toggle){
		if ((value==0)&&(toggle==false)){
			value++;
		}
		else if ((value==1)&&(ch.turn==a1.get_player_num())){
			value++;
		}
		else if ((value==1)&&(toggle==false)){
			value++;
		}
		else if ((value==2)&&(ch.turn==a2.get_player_num())){
			value++;
		}
		else if ((value==2)&&(toggle==false)){
			value++;
		}
		
	}
	public void increase_value(boolean toggle){
		if ((value==0)&&(toggle==false)){
			a1=new atom(ch,true,gx,gy);
			//System.out.println(a1.get_player_num()+"[]");
			value++;
			molatom=a1.molatom;
			if (((gx==0)&&(gy==0))||((gx==0)&&(gy==ch.hor-1))||((gx==ch.ver-1)&&(gy==ch.hor-1))||((gx==ch.ver-1)&&(gy==0))){
				//System.out.println("I rotate");
				RotateTransition rt=new RotateTransition();
				rt.setNode(a1.crc);
				rt.setAxis(Rotate.Y_AXIS);
				rt.setByAngle(360);
				rt.setDuration(Duration.millis(500));
				rt.setCycleCount(Animation.INDEFINITE);
				rt.setInterpolator(Interpolator.LINEAR);
				rt.play();
			}
			this.getChildren().add(molatom);
			molatom.setLayoutX(25);
			molatom.setLayoutY(25);
		}
		else if ((value==1)&&(ch.turn==a1.get_player_num())){
			this.getChildren().remove(molatom);
			a2=new atom2(ch,false,gx,gy);
			molatom=a2.molatom;
			value++;
			//this.getChildren().add(a2.molatom);
			//RotateTransition rt=new RotateTransition();
			//RotateTransition rt2=new RotateTransition();
			//Ellipse crc_path=new Ellipse(3,7);
			//Circle crc2_path=new Circle(20);
			/*PathTransition pt=new PathTransition();
			pt.setNode(a2.crc);
			pt.setPath(crc_path);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(3000));
			if ((gx==0)||(gy==0)||(gx==ch.hor-1)||(gy==ch.ver-1))pt.setDuration(Duration.millis(2000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);*/
			PathTransition p1=new PathTransition();
			p1.setPath(new Circle(10));
			p1.setNode(a2.crc);
			p1.setDuration(Duration.millis(2000));
			p1.setCycleCount(Timeline.INDEFINITE);
			p1.setInterpolator(Interpolator.LINEAR);
			PathTransition p2=new PathTransition();
			p2.setPath(new Circle(1.5));
			p2.setNode(a2.crc2);
			p2.setDuration(Duration.millis(2000));
			p2.setCycleCount(Timeline.INDEFINITE);
			p2.setInterpolator(Interpolator.LINEAR);
			p1.play();
			p2.play();
			/*PathTransition pt2=new PathTransition();
			pt2.setNode(a2.crc2);
			pt2.setPath(crc2_path);
			pt2.setInterpolator(Interpolator.LINEAR);
			
			pt2.setDuration(Duration.millis(10000));
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setCycleCount(Timeline.INDEFINITE);*/
			//rt.setNode(a2.crc);
			//rt2.setNode(a2.crc2);
			//rt.setDuration(Duration.millis(9000));
			//rt2.setDuration(Duration.millis(9000));
			//rt.setAxis(Rotate.Y_AXIS);
			//rt2.setAxis(Rotate.Y_AXIS);
			//rt.setByAngle(360);
			//rt2.setByAngle(360);
			//rt.setCycleCount(Animation.INDEFINITE);
			//rt2.setCycleCount(Animation.INDEFINITE);
			//rt.setInterpolator(Interpolator.LINEAR);
			//rt2.setInterpolator(Interpolator.LINEAR);
			//rt.play();
			//rt2.play();
			//crc_path.setVisible(false);
			//crc2_path.setVisible(false);
			//pt.play();
			//pt2.play();
			//StackPane r1=new StackPane();
			//this.getChildren().add(a2.crc2);
			//StackPane r2=new StackPane();
			this.getChildren().add(molatom);
			molatom.setLayoutX(25);
			molatom.setLayoutY(25);
			//r2.getChildren().add(a2.crc2);
			//this.getChildren().add(crc_path);
			//r2.getChildren().add(crc2_path);
			//this.getChildren().add(r1);
			//this.getChildren().add(a2.molatom);
			//if (toggle==true)ch.turn=(ch.turn+1)%8;
			/*if (toggle==false){
				System.out.println("neighbour burst");
				a2.change_color();
			}*/
			//this.getChildren().add(a2.molatom);
		}
		else if ((value==1)&&(toggle==false)){
			//this.getChildren().remove(a2.molatom);
			this.getChildren().remove(molatom);
			a2=new atom2(ch,true,gx,gy);
			a2.change_color(true);
			molatom=a2.molatom;
			value++;
			//this.getChildren().add(a2.molatom);
			//RotateTransition rt=new RotateTransition();
			//RotateTransition rt2=new RotateTransition();
			//rt.setNode(a2.crc);
			//rt2.setNode(a2.crc2);
			//rt.setDuration(Duration.millis(9000));
			//rt2.setDuration(Duration.millis(9000));
			//rt.setAxis(Rotate.Y_AXIS);
			//rt2.setAxis(Rotate.Y_AXIS);
			//rt.setByAngle(360);
			//rt2.setByAngle(360);
			//rt.setCycleCount(Animation.INDEFINITE);
			//rt2.setCycleCount(Animation.INDEFINITE);
			//rt.setInterpolator(Interpolator.LINEAR);
			//rt2.setInterpolator(Interpolator.LINEAR);
			//rt.play();
			//rt2.play();
			/*Ellipse crc_path=new Ellipse(3,7);
			//Circle crc2_path=new Circle(20);
			PathTransition pt=new PathTransition();
			pt.setNode(a2.crc);
			pt.setPath(crc_path);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(3000));
			if ((gx==0)||(gy==0)||(gx==ch.hor-1)||(gy==ch.ver-1))pt.setDuration(Duration.millis(2000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);*/
			PathTransition p1=new PathTransition();
			p1.setPath(new Circle(10));
			p1.setNode(a2.crc);
			p1.setDuration(Duration.millis(2000));
			p1.setCycleCount(Timeline.INDEFINITE);
			p1.setInterpolator(Interpolator.LINEAR);
			PathTransition p2=new PathTransition();
			p2.setPath(new Circle(1.5));
			p2.setNode(a2.crc2);
			p2.setDuration(Duration.millis(2000));
			p2.setCycleCount(Timeline.INDEFINITE);
			p2.setInterpolator(Interpolator.LINEAR);
			p1.play();
			p2.play();
			/*PathTransition pt2=new PathTransition();
			pt2.setNode(a2.crc2);
			pt2.setPath(crc2_path);
			pt2.setInterpolator(Interpolator.LINEAR);
			pt2.setDuration(Duration.millis(10000));
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setCycleCount(Timeline.INDEFINITE);
			crc_path.setVisible(false);
			crc2_path.setVisible(false);*/
			//pt.play();
			//crc_path.setVisible(false);
			//pt2.play();
			//StackPane r1=new StackPane();
			//this.getChildren().add(a2.crc2);
			this.getChildren().add(molatom);
			molatom.setLayoutX(25);
			molatom.setLayoutY(25);
			//r1.getChildren().add(a2.crc2);
			//this.getChildren().add(crc_path);
			//r1.getChildren().add(crc2_path);
			//this.getChildren().add(r1);
			//this.getChildren().add(a2.molatom);
			
		}
		else if ((value==2)&&(ch.turn==a2.get_player_num())){
			this.getChildren().remove(molatom);
			a3=new atom3(ch,false,gx,gy);
			molatom=a3.molatom;
			value++;
			//this.getChildren().add(a3.molatom);
			/*RotateTransition rt=new RotateTransition();
			RotateTransition rt2=new RotateTransition();
			RotateTransition rt3=new RotateTransition();
			rt.setNode(a3.crc);
			rt2.setNode(a3.crc2);
			rt3.setNode(a3.crc3);
			rt.setDuration(Duration.millis(9000));
			rt2.setDuration(Duration.millis(9000));
			rt3.setDuration(Duration.millis(9000));
			rt.setAxis(Rotate.Y_AXIS);
			rt2.setAxis(Rotate.Y_AXIS);
			rt3.setAxis(Rotate.Y_AXIS);
			rt.setByAngle(360);
			rt2.setByAngle(360);
			rt3.setByAngle(360);
			rt.setCycleCount(Animation.INDEFINITE);
			rt2.setCycleCount(Animation.INDEFINITE);
			rt3.setCycleCount(Animation.INDEFINITE);
			rt.setInterpolator(Interpolator.LINEAR);
			rt2.setInterpolator(Interpolator.LINEAR);
			rt3.setInterpolator(Interpolator.LINEAR);
			rt.play();
			rt2.play();
			rt3.play();*/
			/*Ellipse crc_path=new Ellipse(3,4);
			Ellipse crc_path2=new Ellipse(5,7);
			crc_path2.setCenterX(15);
			crc_path2.setCenterY(5);
			crc_path.setCenterX(5);
			crc_path.setCenterY(5);
			crc_path.setRotationAxis(Rotate.Y_AXIS);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			PathTransition pt=new PathTransition();
			PathTransition pt2=new PathTransition();
			pt.setNode(a3.crc);
			pt2.setNode(a3.crc2);
			pt.setPath(crc_path);
			pt2.setPath(crc_path2);
			pt.setInterpolator(Interpolator.LINEAR);
			pt2.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(1000));
			pt2.setDuration(Duration.millis(1000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
			pt2.setCycleCount(Timeline.INDEFINITE);*/
			RotateTransition r2=new RotateTransition();
			r2.setNode(molatom);
			r2.setAxis(Rotate.Z_AXIS);
			r2.setDuration(Duration.millis(2000));
			r2.setCycleCount(Timeline.INDEFINITE);
			r2.setInterpolator(Interpolator.LINEAR);
			r2.setToAngle(360);
			r2.play();
			//PathTransition pt2=new PathTransition();
			//pt2.setNode(a3.crc2);
			//pt2.setPath(crc2_path);
			//pt2.setInterpolator(Interpolator.LINEAR);
			//pt2.setDuration(Duration.millis(10000));
			//pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//pt2.setCycleCount(Timeline.INDEFINITE);
			//PathTransition pt3=new PathTransition();
			//pt3.setNode(a3.crc3);
			//pt3.setPath(crc3_path);
			//pt3.setInterpolator(Interpolator.LINEAR);
			//pt3.setDuration(Duration.millis(10000));
			//pt3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//pt3.setCycleCount(Timeline.INDEFINITE);
			//crc_path.setVisible(false);
			//crc_path2.setVisible(false);
			//crc2_path.setVisible(false);
			//crc3_path.setVisible(false);
			//pt.play();
			//ParallelTransition p=new ParallelTransition(pt,pt2);
			//p.play();
			//pt2.play();
			//pt3.play();
			//StackPane r1=new StackPane();
			//r1.getChildren().add(a3.crc);
			//r1.getChildren().add(a3.crc2);
			//r1.getChildren().add(a3.crc3);
			//r1.getChildren().add(crc_path);
			//r1.getChildren().add(crc2_path);
			//r1.getChildren().add(crc3_path);
			this.getChildren().add(molatom);
			molatom.setLayoutX(17);
			molatom.setLayoutY(17);
			//if (toggle==true)ch.turn=(ch.turn+1)%8;
			/*if (toggle==false){
				System.out.println("neighbour burst");
				a3.change_color();
			}*/
			
		}
		else if ((value==2)&&(toggle==false)){
			this.getChildren().remove(molatom);
			a3=new atom3(ch,true,gx,gy);
			a3.change_color(true);
			molatom=a3.molatom;
			value++;
			//this.getChildren().add(molatom);
			/*RotateTransition rt=new RotateTransition();
			RotateTransition rt2=new RotateTransition();
			RotateTransition rt3=new RotateTransition();
			rt.setNode(a3.crc);
			rt2.setNode(a3.crc2);
			rt3.setNode(a3.crc3);
			rt.setDuration(Duration.millis(9000));
			rt2.setDuration(Duration.millis(9000));
			rt3.setDuration(Duration.millis(9000));
			rt.setAxis(Rotate.Y_AXIS);
			rt2.setAxis(Rotate.Y_AXIS);
			rt3.setAxis(Rotate.Y_AXIS);
			rt.setByAngle(360);
			rt2.setByAngle(360);
			rt3.setByAngle(360);
			rt.setCycleCount(Animation.INDEFINITE);
			rt2.setCycleCount(Animation.INDEFINITE);
			rt3.setCycleCount(Animation.INDEFINITE);
			rt.setInterpolator(Interpolator.LINEAR);
			rt2.setInterpolator(Interpolator.LINEAR);
			rt3.setInterpolator(Interpolator.LINEAR);
			rt.play();
			rt2.play();
			rt3.play();*/
			/*Ellipse crc_path=new Ellipse(3,4);
			Ellipse crc_path2=new Ellipse(5,7);
			crc_path2.setCenterX(15);
			crc_path2.setCenterY(5);
			crc_path.setCenterX(5);
			crc_path.setCenterY(5);
			crc_path.setRotationAxis(Rotate.Y_AXIS);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			PathTransition pt=new PathTransition();
			PathTransition pt2=new PathTransition();
			pt.setNode(a3.crc);
			pt2.setNode(a3.crc2);
			pt.setPath(crc_path);
			pt2.setPath(crc_path2);
			pt.setInterpolator(Interpolator.LINEAR);
			pt2.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(1000));
			pt2.setDuration(Duration.millis(1000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
			pt2.setCycleCount(Timeline.INDEFINITE);*/
			RotateTransition r2=new RotateTransition();
			r2.setNode(molatom);
			r2.setAxis(Rotate.Z_AXIS);
			r2.setDuration(Duration.millis(2000));
			r2.setCycleCount(Timeline.INDEFINITE);
			r2.setInterpolator(Interpolator.LINEAR);
			r2.setToAngle(360);
			r2.play();
			//PathTransition pt2=new PathTransition();
			//pt2.setNode(a3.crc2);
			//pt2.setPath(crc2_path);
			//pt2.setInterpolator(Interpolator.LINEAR);
			//pt2.setDuration(Duration.millis(10000));
			//pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//pt2.setCycleCount(Timeline.INDEFINITE);
			//PathTransition pt3=new PathTransition();
			//pt3.setNode(a3.crc3);
			//pt3.setPath(crc3_path);
			//pt3.setInterpolator(Interpolator.LINEAR);
			//pt3.setDuration(Duration.millis(10000));
			//pt3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//pt3.setCycleCount(Timeline.INDEFINITE);
			//crc_path.setVisible(false);
			//crc_path2.setVisible(false);
			//crc3_path.setVisible(false);
			//ParallelTransition p=new ParallelTransition(pt,pt2);
			//p.play();
			//pt.play();
			//pt2.play();
			//pt3.play();
			//StackPane r1=new StackPane();.
			//r1.getChildren().add(a3.crc);
			//r1.getChildren().add(a3.crc2);
			//r1.getChildren().add(a3.crc3);
			//r1.getChildren().add(crc_path);
			//r1.getChildren().add(crc2_path);
			//r1.getChildren().add(crc3_path);
			this.getChildren().add(molatom);
			molatom.setLayoutX(17);
			molatom.setLayoutY(17);
			
		}
		/*PointLight light=new PointLight(Color.WHITE);
		light.setTranslateX(-1000);
		light.setTranslateY(100);
		light.setTranslateZ(-1000);
		this.getChildren().add(light);*/
	}
	public void set_color(Sphere crc,boolean color_sasta){
		int temp=ch.turn;
		if (color_sasta==true)temp=ch.prev_turn;
		temp=ch.gr1[gx][gy].player_index;
		System.out.println("hi :( "+temp+" "+gx+" "+gy);
		final PhongMaterial redm=new PhongMaterial();
		redm.setDiffuseColor(Color.rgb(ch.red[0],ch.green[0],ch.blue[0]));
		redm.setSpecularColor(Color.BLACK);
		final PhongMaterial greenm=new PhongMaterial();
		greenm.setDiffuseColor(Color.rgb(ch.red[1],ch.green[1],ch.blue[1]));
		greenm.setSpecularColor(Color.BLACK);
		final PhongMaterial bluem=new PhongMaterial();
		bluem.setDiffuseColor(Color.rgb(ch.red[2],ch.green[2],ch.blue[2]));
		bluem.setSpecularColor(Color.BLACK);
		final PhongMaterial pinkm=new PhongMaterial();
		pinkm.setDiffuseColor(Color.rgb(ch.red[3],ch.green[3],ch.blue[3]));
		pinkm.setSpecularColor(Color.BLACK);
		final PhongMaterial yellowm=new PhongMaterial();
		yellowm.setDiffuseColor(Color.rgb(ch.red[4],ch.green[4],ch.blue[4]));
		yellowm.setSpecularColor(Color.BLACK);
		final PhongMaterial cyanm=new PhongMaterial();
		cyanm.setDiffuseColor(Color.rgb(ch.red[5],ch.green[5],ch.blue[5]));
		cyanm.setSpecularColor(Color.BLACK);
		final PhongMaterial purplem=new PhongMaterial();
		purplem.setDiffuseColor(Color.rgb(ch.red[6],ch.green[6],ch.blue[6]));
		purplem.setSpecularColor(Color.BLACK);
		final PhongMaterial whitem=new PhongMaterial();
		whitem.setDiffuseColor(Color.rgb(ch.red[7],ch.green[7],ch.blue[7]));
		whitem.setSpecularColor(Color.BLACK);
		crc.setRadius(10);
		//---------------------------------------------------
		//!!!this part needs to change because when players are eliminated this will not be function properly
		if (temp==0)crc.setMaterial(redm);
		if (temp==1)crc.setMaterial(greenm);
		if (temp==2)crc.setMaterial(bluem);
		if (temp==3)crc.setMaterial(pinkm);
		if (temp==4)crc.setMaterial(yellowm);
		if (temp==5)crc.setMaterial(cyanm);
		if (temp==6)crc.setMaterial(purplem);
		if (temp==7)crc.setMaterial(whitem);
		//----------------------------------------------------
		
	}
	public void clear_sphere(Group s){
		getChildren().remove(s);
	}
	public void burst_the_cell(boolean toggle){
		value=0;
		//System.out.println("cell burst");
		this.getChildren().remove(molatom);
		
		double x1=r.getLayoutX()+25;
		double y1=r.getLayoutY()+25;
		ParallelTransition p=new ParallelTransition();
		if ((gx-1>=0)&&(gy>=0)){
			Sphere s=new Sphere(10);
			if (toggle==true)set_color(s,false);
			else set_color(s,true);
			double x2=x1-50;
			double y2=y1;
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			//s.setTranslateZ(1000);
			//------------------------------------------------------------------!!
			Line l1=new Line(x1,y1,x2,y2);
			l1.setStroke(Color.WHITE);
			PathTransition p1=new PathTransition();
			p1.setPath(l1);
			p1.setNode(s);
			p1.setInterpolator(Interpolator.LINEAR);
			p1.setDuration(Duration.seconds(1));
			p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			p1.setCycleCount(1);
			
			//p1.setOnFinished(e->ch.gr[gx-1][gy].change_value(false));
			//p1.play();
			l1.setVisible(false);
			Group an1=new Group();
			an1.getChildren().add(s);
			an1.getChildren().add(l1);
			ch.gr[gx][gy].getChildren().add(an1);
			p1.setOnFinished(e->clear_sphere(an1));
			p.getChildren().add(p1);
			//p1.setOnFinished(e->ch.gr[gx-1][gy].change_value(false));
			//--------------------------------------------------------------------!!
			//ch.gr[gx-1][gy].getChildren().add(an1);
			//ch.gr[gx-1][gy].getChildren().add(new Group(s));
			/*Bounds b1=this.r.getBoundsInParent();
			Bounds b2=ch.gr[gx-1][gy].r.getBoundsInParent();
			double x1=b1.getMinX()+b1.getWidth()/2;
			double y1=b1.getMinY()+b1.getHeight()/2;
			double x2=b2.getMinX()+b2.getWidth()/2;
			double y2=b2.getMinX()+b2.getHeight()/2;*/
			/*double x1=490+50*gx;
			double x2=490+50*(gx-1);
			double y1=150+50*gy;
			double y2=150+50*gy;*/
			//System.out.println(r.getX()+" "+r.getY()+" "+ch.gr[gx-1][gy].r.getX()+" "+ch.gr[gx-1][gy].r.getY());
			//Line l=new Line(x1,y1,x2,y2);
			//Ellipse crc_path=new Ellipse(3,4);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			/*PathTransition pt=new PathTransition();
			pt.setNode(s);
			pt.setPath(l);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(1000));*/
			//pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//pt.setCycleCount(1);
			//l.setVisible(false);
			//pt.play();
			//this.getChildren().add(s);
			//ch.gr[gx-1][gy].getChildren().add(s);
			/*final PathTransition p1=new PathTransition();
			p1.setDuration(Duration.seconds(10.0));
			//p1.setDelay(Duration.seconds(1.0));
			//final Path path1=new Path();
			//path1.getElements().add(new MoveTo((gx-1)*50+90,gy*50+60));
			Line path1=new Line(gx*50+90,gy*50+60,(gx-1)*50+90,gy*50+60);
			ch.root.getChildren().add(path1);
			p1.setPath(path1);
			p1.setNode(new atom(ch).crc);
			//p1.setOrientation(OrientationType.NONE);
			p1.setCycleCount(1);
			//p1.setAutoReverse(true);
			//new ParallelTransition(p1).play();
			p1.play();*/
			/*Group ps=new Group();
			Sphere s=new Sphere();
			set_color(s);
			ps.getChildren().add(s);
			Path p1=new Path();*/
			//p1.getElements().addAll(new MoveTo((gx-1)*50+90,gy*50+60),new VLineTo(100));
			//-----------------------------ch.gr[gx-1][gy].change_value(false);
			//ch.gr[gx][gy].getChildren().remove(an1);
			/*try{
				Thread.sleep(1000);
				}catch(Exception e){}*/
			//this.getChildren().remove(s);
		}
		if ((gx+1<=ch.hor-1)&&(gy>=0)){
			Sphere s=new Sphere(10);
			if (toggle==true)set_color(s,false);
			else set_color(s,true);
			double x2=x1+50;
			double y2=y1;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			//s.setTranslateZ(1000);
			//-------------------------------------------!!
			Line l1=new Line(x1,y1,x2,y2);
			l1.setStroke(Color.CYAN);
			PathTransition p1=new PathTransition();
			p1.setPath(l1);
			p1.setNode(s);
			p1.setInterpolator(Interpolator.LINEAR);
			p1.setDuration(Duration.seconds(1));
			p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			p1.setCycleCount(1);
			
			//p1.setOnFinished(e->ch.gr[gx+1][gy].change_value(false));
			//p1.play();
			l1.setVisible(false);
			Group an1=new Group();
			an1.getChildren().add(s);
			an1.getChildren().add(l1);
			ch.gr[gx][gy].getChildren().add(an1);
			p1.setOnFinished(e->clear_sphere(an1));
			p.getChildren().add(p1);
			//p1.setOnFinished(e->ch.gr[gx+1][gy].change_value(false));
			//-----------------------------------------------!!
			//Sphere s=new Sphere(10);
			//set_color(s);
			//s.setTranslateZ(1000);
			/*Bounds b1=this.r.getBoundsInLocal();
			Bounds b2=ch.gr[gx+1][gy].r.getBoundsInLocal();
			double x1=b1.getMinX()+b1.getWidth()/2;
			double y1=b1.getMinY()+b1.getHeight()/2;
			double x2=b2.getMinX()+b2.getWidth()/2;
			double y2=b2.getMinX()+b2.getHeight()/2;*/
			/*double x1=490+50*gx;
			double x2=490+50*(gx+1);
			double y1=150+50*gy;
			double y2=150+50*gy;
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
			Line l=new Line(x1,y1,x2,y2);
			l.setStroke(Color.WHITE);
			l.setFill(Color.WHITE);
			l.setTranslateZ(1000);*/
			//Ellipse crc_path=new Ellipse(3,4);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			//----------------------------------
			/*PathTransition pt=new PathTransition();
			pt.setNode(s);
			pt.setPath(l);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(10000));*/
			//----------------------------------
			//pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			//-----------------------------------
			/*pt.setCycleCount(1);
			l.setVisible(false);
			pt.play();*/
			//----------------------------------
			//this.getChildren().add(s);
			//ch.gr[gx+1][gy].getChildren().add(s);
			//final PathTransition p1=new PathTransition();
			//p1.setDuration(Duration.seconds(10.0));
			//p1.setDelay(Duration.seconds(1.0));
			//final Path path1=new Path();
			//path1.getElements().add(new MoveTo((gx+1)*50+90,gy*50+60));
			//Line path1=new Line(gx*50+90,gy*50+60,(gx+1)*50+90,gy*50+60);
			//ch.root.getChildren().add(path1);
			//p1.setPath(path1);
			//p1.setNode(new atom(ch).crc);
			//p1.setOrientation(OrientationType.NONE);
			//p1.setCycleCount(1);
			//p1.setAutoReverse(true);
			//p1.play();
			//new ParallelTransition(p1).play();
			//--------------------------ch.gr[gx+1][gy].change_value(false);
			//ch.gr[gx][gy].getChildren().remove(an1);
			/*try{
				Thread.sleep(1000);
				}catch(Exception e){}*/
			//this.getChildren().remove(s);
		}
		if ((gx>=0)&&(gy-1>=0)){
			Sphere s=new Sphere(10);
			if (toggle==true)set_color(s,false);
			else set_color(s,true);
			double x2=x1;
			double y2=y1-50;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			//s.setTranslateZ(1000);
			//-------------------------------------------!!
			Line l1=new Line(x1,y1,x2,y2);
			l1.setStroke(Color.PURPLE);
			PathTransition p1=new PathTransition();
			p1.setPath(l1);
			p1.setNode(s);
			p1.setInterpolator(Interpolator.LINEAR);
			p1.setDuration(Duration.seconds(1));
			p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			p1.setCycleCount(1);
			//p1.play();
			l1.setVisible(false);
			Group an1=new Group();
			an1.getChildren().add(s);
			an1.getChildren().add(l1);
			ch.gr[gx][gy].getChildren().add(an1);
			p1.setOnFinished(e->clear_sphere(an1));
			p.getChildren().add(p1);
			//p1.setOnFinished(e->ch.gr[gx][gy-1].change_value(false));
			//-------------------------------------------!!
			//Sphere s=new Sphere(10);
			//set_color(s);
			/*Bounds b1=this.r.getBoundsInLocal();
			Bounds b2=ch.gr[gx][gy-1].r.getBoundsInLocal();
			double x1=b1.getMinX()+b1.getWidth()/2;
			double y1=b1.getMinY()+b1.getHeight()/2;
			double x2=b2.getMinX()+b2.getWidth()/2;
			double y2=b2.getMinX()+b2.getHeight()/2;*/
			/*double x1=490+50*gx;
			double x2=490+50*(gx);
			double y1=150+50*gy;
			double y2=150+50*(gy-1);
			Line l=new Line(x1,y1,x2,y2);*/
			//Ellipse crc_path=new Ellipse(3,4);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			/*PathTransition pt=new PathTransition();
			pt.setNode(s);
			pt.setPath(l);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(1000));*/
			//pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			/*pt.setCycleCount(1);
			l.setVisible(false);
			pt.play();
			this.getChildren().add(s);*/
			//ch.gr[gx][gy-1].getChildren().add(s);
			//final PathTransition p1=new PathTransition();
			//p1.setDuration(Duration.seconds(10.0));
			//p1.setDelay(Duration.seconds(1.0));
			//final Path path1=new Path();
			//path1.getElements().add(new MoveTo((gx)*50+90,(gy-1)*50+60));
			//Line path1=new Line(gx*50+90,gy*50+60,(gx)*50+90,(gy-1)*50+60);
			//ch.root.getChildren().add(path1);
			//p1.setPath(path1);
			//p1.setNode(new atom(ch).crc);
			//p1.setOrientation(OrientationType.NONE);
			//p1.setCycleCount(1);
			//p1.setAutoReverse(true);
			//new ParallelTransition(p1).play();
			//p1.play();
			//-----------------------ch.gr[gx][gy-1].change_value(false);
			//ch.gr[gx][gy].getChildren().remove(an1);
			/*try{
				Thread.sleep(1000);
				}catch(Exception e){}*/
			//this.getChildren().remove(s);
		}
		if ((gx>=0)&&(gy+1<=ch.ver-1)){
			Sphere s=new Sphere(10);
			if (toggle==true)set_color(s,false);
			else set_color(s,true);
			double x2=x1;
			double y2=y1+50;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			//s.setTranslateZ(1000);
			//-----------------------------------!!
			Line l1=new Line(x1,y1,x2,y2);
			l1.setStroke(Color.YELLOW);
			PathTransition p1=new PathTransition();
			p1.setPath(l1);
			p1.setNode(s);
			p1.setInterpolator(Interpolator.LINEAR);
			p1.setDuration(Duration.seconds(1));
			p1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			p1.setCycleCount(1);
			//p1.setOnFinished(e->ch.gr[gx][gy+1].change_value(false));
			p1.play();
			l1.setVisible(false);
			Group an1=new Group();
			an1.getChildren().add(s);
			an1.getChildren().add(l1);
			ch.gr[gx][gy].getChildren().add(an1);
			p1.setOnFinished(e->clear_sphere(an1));
			p.getChildren().add(p1);
			//p1.setOnFinished(e->ch.gr[gx][gy+1].change_value(false));
			//---------------------------------------!!
			/*Sphere s=new Sphere(10);
			set_color(s);*/
			/*Bounds b1=this.r.getBoundsInLocal();
			Bounds b2=ch.gr[gx][gy+1].r.getBoundsInLocal();
			double x1=b1.getMinX()+b1.getWidth()/2;
			double y1=b1.getMinY()+b1.getHeight()/2;
			double x2=b2.getMinX()+b2.getWidth()/2;
			double y2=b2.getMinX()+b2.getHeight()/2;*/
			/*double x1=490+50*gx;
			double x2=490+50*(gx);
			double y1=150+50*gy;
			double y2=150+50*(gy+1);
			Line l=new Line(x1,y1,x2,y2);*/
			//Ellipse crc_path=new Ellipse(3,4);
			//Circle crc2_path=new Circle(20);
			//Circle crc3_path=new Circle(20);
			/*PathTransition pt=new PathTransition();
			pt.setNode(s);
			pt.setPath(l);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(1000));*/
			//pt.setOrientation(PathTransitiwon.OrientationType.ORTHOGONAL_TO_TANGENT);
			/*pt.setCycleCount(1);
			l.setVisible(false);
			pt.play();
			this.getChildren().add(s);*/
			//ch.gr[gx][gy+1].getChildren().add(s);
			//final PathTransition p1=new PathTransition();
			//p1.setDuration(Duration.seconds(10.0));
			//p1.setDelay(Duration.seconds(1.0));
			//final Path path1=new Path();
			//path1.getElements().add(new MoveTo((gx)*50+90,(gy+1)*50+60));
			//Line path1=new Line(gx*50+90,gy*50+60,(gx)*50+90,(gy+1)*50+60);
			//ch.root.getChildren().add(path1);
			//p1.setPath(path1);
			//p1.setNode(new atom(ch).crc);
			//p1.setOrientation(OrientationType.NONE);
			//p1.setCycleCount(1);
			//p1.setAutoReverse(true);
			//p1.play();
			//new ParallelTransition(p1).play();
			//-----------------ch.gr[gx][gy+1].change_value(false);
			//ch.gr[gx][gy].getChildren().remove(an1);
			/*try{
				Thread.sleep(1000);
				}catch(Exception e){}*/
			//this.getChildren().remove(s);
		}
		//a=null;
		//p.play();
		p.setOnFinished(e->if_for_change_value());
		//if_for_change_value();
		ParallelTransition p2=new ParallelTransition(p);
		//System.out.println(ch.turn+" -");
		//if (toggle==true)p2.setOnFinished(e->ch.increment_turn());
		p2.play();
		//System.out.println(ch.turn+" -");
		/*if ((gx-1>=0)&&(gy>=0)){
			ch.gr[gx-1][gy].change_value(false);
		}
		if ((gx+1<=ch.hor-1)&&(gy>=0)){
			ch.gr[gx+1][gy].change_value(false);
		}
		if ((gx>=0)&&(gy-1>=0)){
			ch.gr[gx][gy-1].change_value(false);
		}
		if ((gx>=0)&&(gy+1<=ch.ver-1)){
			ch.gr[gx][gy+1].change_value(false);
		}*/
	}
	public void if_for_change_value(){
		if ((gx-1>=0)&&(gy>=0)){
			ch.gr[gx-1][gy].change_value(false);
		}
		if ((gx+1<=ch.hor-1)&&(gy>=0)){
			ch.gr[gx+1][gy].change_value(false);
		}
		if ((gx>=0)&&(gy-1>=0)){
			ch.gr[gx][gy-1].change_value(false);
		}
		if ((gx>=0)&&(gy+1<=ch.ver-1)){
			ch.gr[gx][gy+1].change_value(false);
		}
	}
	public boolean compute_change_value(boolean toggle){
		if (value<threshold){
			increase_value(toggle);
			return false;
		}
		else{
			burst_the_cell(toggle);
			return true;
		}
	}
	public boolean change_value(boolean toggle){
		//System.out.println(gx+" "+gy);
		if (value<threshold){
			increase_value(toggle);
			return false;
		}
		else {
			burst_the_cell(toggle);
			return true;
		}
	}
	/*public void change_color_of_grid(int turn){
		r.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent t){
				if (turn==0)r.setStroke(Color.RED);
				if (turn==1)r.setStroke(Color.GREEN);
				if (turn==2)r.setStroke(Color.BLUE);
				if (turn==3)r.setStroke(Color.PINK);
				if (turn==4)r.setStroke(Color.YELLOW);
				if (turn==5)r.setStroke(Color.CYAN);
				if (turn==6)r.setStroke(Color.MEDIUMPURPLE);
				if (turn==7)r.setStroke(Color.SNOW);
			}
		});
	}*/
}
class compute_cell implements Serializable{
	public int value;
	public int player_index;
	public transient Main ch;
	public int gx;
	public int gy;
	public int threshold;
	public compute_cell(Main ch,int gx,int gy){
		value=0;
		player_index=-1;
		this.ch=ch;
		this.gy=gy;
		this.gx=gx;
		if ((gx==0)&&(gy==0))threshold=1;
		else if ((gx==ch.hor-1)&&(gy==0))threshold=1;
		else if ((gx==0)&&(gy==ch.ver-1))threshold=1;
		else if ((gx==ch.hor-1)&&(gy==ch.ver-1))threshold=1;
		else if (gx==0)threshold=2;
		else if (gy==0)threshold=2;
		else if (gx==ch.hor-1)threshold=2;
		else if (gy==ch.ver-1)threshold=2;
		else threshold=3;
	}
	public void if_for_change_value(){
		if ((gx-1>=0)&&(gy>=0)){
			ch.gr1[gx-1][gy].compute_change_value(false);
		}
		if ((gx+1<=ch.hor-1)&&(gy>=0)){
			ch.gr1[gx+1][gy].compute_change_value(false);
		}
		if ((gx>=0)&&(gy-1>=0)){
			ch.gr1[gx][gy-1].compute_change_value(false);
		}
		if ((gx>=0)&&(gy+1<=ch.ver-1)){
			ch.gr1[gx][gy+1].compute_change_value(false);
		}
	}
	public boolean compute_change_value(boolean toggle){
		if (value<threshold){
			compute_increase_value(toggle);
			return false;
		}
		else{
			compute_burst_the_cell(toggle);
			return true;
		}
	}
	public void compute_increase_value(boolean toggle){
		System.out.println(gx+" "+gy+" :p");
		if ((value==0)&&(toggle==false)){
			value++;
		}
		else if ((value==1)&&(ch.turn==ch.gr[gx][gy].get_player_index())){
			value++;
		}
		else if ((value==1)&&(toggle==false)){
			value++;
		}
		else if ((value==2)&&(ch.turn==ch.gr[gx][gy].get_player_index())){
			value++;
		}
		else if ((value==2)&&(toggle==false)){
			value++;
		}
		
	}
	public void compute_burst_the_cell(boolean toggle){
		value=0;
		//System.out.println("I burst "+gx+" "+gy);
		if ((gx-1>=0)&&(gy>=0)){
			ch.gr1[gx-1][gy].player_index=player_index;
		}
		if ((gx+1<=ch.hor-1)&&(gy>=0)){
			ch.gr1[gx+1][gy].player_index=player_index;
		}
		if ((gx>=0)&&(gy-1>=0)){
			ch.gr1[gx][gy-1].player_index=player_index;
		}
		if ((gx>=0)&&(gy+1<=ch.ver-1)){
			ch.gr1[gx][gy+1].player_index=player_index;
		}
		if_for_change_value();
	}
}
class grid implements Serializable
{
	
int player_index;
int value;
public  grid(int a,int b)
{
	this.player_index=a;
	this.value=b;}

}
class to_serialize implements Serializable
{
	grid[][] gr1;
	int turn;
	int prev_turn;
	int red[];
	int green[];
	int blue[];
	int hor;
	int ver;
	int num_players;
	
	public int num_turn=0;
	public transient cell[][] gr;
	//public cell[][] inner_gr;
	public  compute_cell[][] norm;
	 
	public player[] all_players;
	 
	public boolean[] alive;
 
	
	public to_serialize(boolean[] alive,int num_turn,cell[][] gr,compute_cell[][] norm,player[] all_players,grid[][] gr1,int turn,int prev_turn,int num_players,int[] red,int []green,int[] blue,int hor,int ver)
	{
		this.gr1=gr1;
		this.turn=turn;
		this.prev_turn=prev_turn;
		this.green=green;
		this.red=red;
		this.blue=blue;this.ver=ver;
		this.hor=hor;
		this.num_players=num_players;
		this.num_turn=num_turn;
		this.gr=gr;
		this.norm=norm;
		this.all_players=all_players;
		this.alive=alive;
	}
	
}
public class Main extends Application implements Serializable
{	
	
	private Stage primaryStage;
	public static AnchorPane mainLayout;
	private Scene scene;	 
	public static int turn=0;
	public static int prev_turn=0;
	public int num_turn=0;
	public cell[][] gr;
	public cell[][] inner_gr;
	public compute_cell[][] gr1;
	public Group root;
	public static int num_players=2;
	public player[] all_players;
	public static  int hor;
	public static int ver;
	public static grid[][] grid;
	ArrayList<Line> arr;
	public static int[] red=  {255,0,0,255,255,0,100,255};
	public static int[] green={0,255,0,255,0,255,100,255};
	public static int[] blue= {0,0,255,0,255,255,100,255};	
	public int status;
	public int winner;
	public compute_cell[][] gr21;
	public static grid[][] old_grid;
	public static grid[][] ret_main(){
		return old_grid;
	}
	//class undo_button implements EventHandler<MouseEvent>{
	public void undobutton()throws IOException{
		grid[][] temp=new grid[hor][ver];
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				temp[i][j]=new grid(old_grid[i][j].player_index,old_grid[i][j].value);
			}
		}
		try{
		this.resumeGame();}
		catch(ClassNotFoundException e){}
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				old_grid[i][j]=new grid(temp[i][j].player_index,temp[i][j].value);
			}
		}
		//@Override
		//public void handle(MouseEvent m){	
		for (int i=0;i<hor;i++){
				for (int j=0;j<ver;j++){
					gr[i][j].getChildren().remove(gr[i][j].molatom);
					//System.out.print(gr2[i][j].value+" h1");
					if (old_grid[i][j].value==1){
						atom a=new atom(Main.this,true,i,j);
						gr[i][j].a1=a;
						gr[i][j].getChildren().add(gr[i][j].a1.get_atom());
						gr[i][j].molatom=a.molatom;
						gr[i][j].molatom.setLayoutX(25);
						gr[i][j].molatom.setLayoutY(25);
					}
					else if (old_grid[i][j].value==2){
						atom2 a2=new atom2(Main.this,true,i,j);
						gr[i][j].molatom=a2.molatom;
						PathTransition p1=new PathTransition();
						p1.setPath(new Circle(10));
						p1.setNode(a2.crc);
						p1.setDuration(Duration.millis(2000));
						p1.setCycleCount(Timeline.INDEFINITE);
						p1.setInterpolator(Interpolator.LINEAR);
						PathTransition p2=new PathTransition();
						p2.setPath(new Circle(1.5));
						p2.setNode(a2.crc2);
						p2.setDuration(Duration.millis(2000));
						p2.setCycleCount(Timeline.INDEFINITE);
						p2.setInterpolator(Interpolator.LINEAR);
						p1.play();
						p2.play();
						gr[i][j].getChildren().add(gr[i][j].molatom);
						gr[i][j].molatom.setLayoutX(25);
						gr[i][j].molatom.setLayoutY(25);
						
					}
					else if (old_grid[i][j].value==3){
						atom3 a3=new atom3(Main.this,true,i,j);
						gr[i][j].molatom=a3.molatom;
						RotateTransition r2=new RotateTransition();
						r2.setNode(a3.molatom);
						r2.setAxis(Rotate.Z_AXIS);
						r2.setDuration(Duration.millis(2000));
						r2.setCycleCount(Timeline.INDEFINITE);
						r2.setInterpolator(Interpolator.LINEAR);
						r2.setToAngle(360);
						r2.play();
						gr[i][j].getChildren().add(gr[i][j].molatom);
						gr[i][j].molatom.setLayoutX(17);
						gr[i][j].molatom.setLayoutY(17);
						
					}
					gr1[i][j].value=old_grid[i][j].value;
					gr1[i][j].player_index=old_grid[i][j].player_index;
					gr[i][j].value=old_grid[i][j].value;
				}
				System.out.println();
			}
			turn=prev_turn;
			for(int i=0;i<hor;i++){
				for(int j=0;j<ver;j++){
					gr[i][j].get_rectangle().setStroke(Color.rgb(red[prev_turn],green[prev_turn],blue[prev_turn]));
					inner_gr[i][j].get_rectangle().setStroke(Color.rgb(red[prev_turn],green[prev_turn],blue[prev_turn]));
				}
			}
			for (int i=0;i<hor+1;i++){
				for (int j=0;j<ver+1;j++){
					Line c=arr.get(i*(ver+1)+j);
					c.setStroke(Color.rgb(red[prev_turn], green[prev_turn], blue[prev_turn]));
				}
			}
			num_turn--;
			if (num_turn>=num_players){
			for (int i=0;i<num_players;i++){
				all_players[i].num_atom=0;
			}
			for (int i=0;i<hor;i++){
				for (int j=0;j<ver;j++){
					int pl=gr1[i][j].player_index;
					if (gr1[i][j].value>0){
						//System.out.print((pl+1)+" ");
						System.out.println(i+" "+j+" "+gr1[i][j].value);
						all_players[pl].num_atom+=gr1[i][j].value;
					}
				}
			}
			for (int i=0;i<num_players;i++){
				if (all_players[i].num_atom==0)alive[i]=false;
				else alive[i]=true;
			}
			}
			
		}
//	}
		//if (new_turn==0)new_turn=num_players-1;
	
	public static void give_obj() throws IOException
	{
		
		to_serialize obj=new to_serialize(null,0,null,null,null,null,0,0,num_players,red,green,blue,0,0);
		serialize(obj, "1");
		//System.out.println("abc");
	}
	
	public static int give_num_player() throws ClassNotFoundException, IOException
	{

		to_serialize obj= deserialize("1");
		return obj.num_players;
		
	}
	public void set_colours(int red[],int green[],int blue[]) 
	{
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	@Override
	public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Chain Reaction Game");
		showMainView();
		//old_grid=new grid[hor][ver];
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				cell c=null;
				if (hor==6 && ver==9)
					{
						c=new cell(this,i,j,i*50+150,j*50+150,50,50);
					}
					
					else
					{
						//System.out.println("abc");
						c=new cell(this,i,j,i*50+50,j*50+70,50,50);
					}
					gr[i][j]=c;
					gr1[i][j]=new compute_cell(this,i,j);
					gr21[i][j]=new compute_cell(this,i,j);
			}
		}
		to_serialize obj= deserialize("1");
		if(obj.red!=null)
		{
		red=obj.red;
		green=obj.green;
		blue=obj.blue;
		}
		if(obj.num_players!=0)
		{
			num_players=obj.num_players;
			//System.out.println(num_players);
		}
		 
	}
	public void set_new_game(int hor,int ver,int num_players,int[] red,int[] green,int[] blue){
		this.hor=hor;
		this.ver=ver;
		this.num_players=num_players;
		this.red=red;
		this.green=green;
		this.blue=blue;
		this.alive=new boolean[num_players];
		for (int i=0;i<num_players;i++){
			alive[i]=true;
		}
		this.turn=0;
		this.num_turn=0;
		this.root=new Group();
	}
	public boolean[] alive;
//	{
//		alive=new boolean[num_players];
//		all_players=new player[num_players];
//		
//		for (int i=0;i<num_players;i++){
//			alive[i]=true;
//			all_players[i]=new player(i,red[i],green[i],blue[i]);
//		}
//	}
	public void kill_player(int index){
		if (index<num_players){
		alive[index]=false;
		}
	}
	public void increment_turn(){
		//System.out.println(turn+" --");
		prev_turn=turn;
		turn=(turn+1)%num_players;
		//System.out.println(alive);
		while(alive[turn]==false){
			turn=(turn+1)%num_players;
		}
		//System.out.println(turn+" --");
	}
	private void showMainView() throws IOException
	{
		FXMLLoader loader =new FXMLLoader();
		loader.setLocation(Main.class.getResource("pages/s1.fxml"));
		mainLayout=loader.load();		
		scene=new Scene(mainLayout,600,850);
		primaryStage.setScene(scene);
		primaryStage.show();
	    
	}
	

	class cell_click_event implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent m){
			if(status==1)
			{
				JLabel label = new JLabel("Player "+(winner)+" won!!");
				label.setFont(new Font("Arial", Font.BOLD, 18));
				//UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,23)));
//				JLabel label1 = new JLabel("Wohoo! Player "+(winner)+" won!!");
//				label.setFont(new Font("Arial", Font.BOLD, 20));
				
				UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
				int input= JOptionPane.showOptionDialog(null, label,"Congratulations",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
			    
				if(input==0)
				{
					 
					try {
						AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
						mainLayout.getChildren().setAll(a1);
						to_serialize obj=new to_serialize(null,0,null,null,null,null,0,0,0,red,green,blue,0,0);
						serialize(obj, "1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				 
			}
			//System.out.println("cell click");
			else
			{
			cell temp=(cell)m.getSource();
			//System.out.println(gr1);
			//System.out.println(temp.gy);
			compute_cell compute_temp=gr1[temp.gx][temp.gy];
			compute_temp.player_index=turn;
			//System.out.println(m.getScreenX()+" "+m.getScreenY()+" "+turn);
			//System.out.println(temp.gx+" "+temp.gy);
			boolean b=false;
			old_grid=new grid[hor][ver];
			for (int i=0;i<hor;i++){
				for (int j=0;j<ver;j++){
					if (gr1[i][j].value>0)System.out.println("***"+i+" "+j+" "+gr1[i][j].value+"***");
					old_grid[i][j]=new grid(gr1[i][j].player_index,gr1[i][j].value);
					gr21[i][j].value=gr1[i][j].value;
					gr21[i][j].player_index=gr1[i][j].player_index;
				}
			}
			if (temp.get_value()==0){
				num_turn++;
				atom a=new atom(Main.this,false,temp.gx,temp.gy);
				temp.a1=a;
				temp.value_plus();
				compute_temp.value++;
				temp.getChildren().add(temp.a1.get_atom());
				if (((temp.gx==0)&&(temp.gy==0))||((temp.gx==0)&&(temp.gy==ver-1))||((temp.gx==hor-1)&&(temp.gy==ver-1))||((temp.gx==hor-1)&&(temp.gy==0))){
					//System.out.println("I rotate");
					RotateTransition rt=new RotateTransition();
					rt.setNode(temp.a1.crc);
					rt.setAxis(Rotate.Y_AXIS);
					rt.setByAngle(360);
					rt.setDuration(Duration.millis(500));
					rt.setCycleCount(Animation.INDEFINITE);
					rt.setInterpolator(Interpolator.LINEAR);
					rt.play();
				}
				temp.molatom=a.molatom;
				temp.molatom.setLayoutX(25);
				temp.molatom.setLayoutY(25);
				if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr1[i][j].player_index;
							if (gr1[i][j].value>0){
								System.out.print((pl+1)+" ");
								//System.out.println(i+" "+j+" "+gr1[i][j].value+" "+pl);
								all_players[pl].num_atom+=gr1[i][j].value;
							}else System.out.print("0 ");
						}
						System.out.println();
					}
					System.out.println("****");
					
					for (int i=0;i<num_players;i++){
						System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}
				//while(alive[turn-1]==false){
				
				/*if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr[i][j].get_player_index();
							if (gr1[i][j].value>0){
							all_players[pl].num_atom+=gr1[i][j].value;
						}
						}
					}
					//System.out.println();
					for (int i=0;i<num_players;i++){
						System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}*/
				increment_turn();
				/*do{
					turn=(turn+1)%num_players;
					}
					while(alive[turn]==false);*/
				//!!!!--------------------------
				/*turn=(turn+1)%num_players;
				while(alive[turn]==false){
					turn=(turn+1)%num_players;
				}*/
				//!!!!!----------------------------
			//num_turn++;
			}else if (((temp.get_value()==1)&&(turn==temp.a1.player_index))||((temp.get_value()==2)&&(turn==temp.a2.player_index))||((temp.get_value()==3)&&(turn==temp.a3.player_index))){
				num_turn++;
				if (temp.value==1)temp.getChildren().remove(temp.a1.get_atom());
				else if (temp.value==2)temp.getChildren().remove(temp.a2.get_atom());
				else if (temp.value==3)temp.getChildren().remove(temp.a3.get_atom());
				//System.out.println(turn+" :)");
				compute_temp.compute_change_value(true);
				temp.change_value(true);
				if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr1[i][j].player_index;
							if (gr1[i][j].value>0){
								System.out.print((pl+1)+" ");
								//System.out.println(i+" "+j+" "+gr1[i][j].value+" "+pl);
								all_players[pl].num_atom+=gr1[i][j].value;
							}else System.out.print("0 ");
						}
						System.out.println();
					}
					System.out.println("****");
					for (int i=0;i<num_players;i++){
						System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}
				//System.out.println(turn+" :)");
				//evaluation of number of atoms should be done after cells have burst
				/*if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr[i][j].get_player_index();
							if (gr[i][j].get_value()>0){
								//System.out.println(gr[i][j].get_value()+" "+gr[i][j].get_player_index());
								System.out.println(i+" "+j+" "+gr[i][j].get_value());
								all_players[pl].num_atom++;
							}
						}
					}
					System.out.println("****");
					for (int i=0;i<num_players;i++){
						//System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}*/
				increment_turn();
				/*do{
					turn=(turn+1)%num_players;
					}
					while(alive[turn]==false);*/
				//!!!----------------------------------
				/*turn=(turn+1)%num_players;
				while(alive[turn]==false){
					turn=(turn+1)%num_players;
				}*/
				//!!----------------------------------
					//num_turn++;
			}
			int ct=0;
			int flag=-1;
			System.out.println(turn);
			
			System.out.println();
			for (int i=0;i<num_players;i++){
				//System.out.println(alive[i]);
				if (alive[i]==true){
					ct++;
					flag=i;
				}
			}
			if (ct==1){
				System.out.println("Player "+(flag+1)+" won");
				status=1;
				winner=flag+1;
				//Platform.exit();
				//System.exit(0);
			}
			//if (temp.get_value()!=0)temp.getChildren().remove(temp.a.get_atom());
			//boolean b=temp.change_value(true);//!!!!!!!!!!!!
			//temp.get_rectangle().setFill(Color.BROWN);
			/*Sphere crc=new Sphere();
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
			if (turn==0)crc.setMaterial(redm);
			if (turn==1)crc.setMaterial(greenm);
			if (turn==2)crc.setMaterial(bluem);
			if (turn==3)crc.setMaterial(pinkm);
			if (turn==4)crc.setMaterial(yellowm);
			if (turn==5)crc.setMaterial(cyanm);
			if (turn==6)crc.setMaterial(purplem);
			if (turn==7)crc.setMaterial(whitem);*/
			//atom a=new atom(chain2.this);
			//if (b==false)temp.getChildren().add(temp.a.get_atom());
			//if (b==true){
				//turn=(turn+1)%8;
				/*
				if ((temp.gx-1>=0)&&(temp.gy>=0)){
					cell temp2=gr[temp.gx-1][temp.gy];
					temp2.change_value();
				}*/
			//}
			//turn=(turn+1)%8;
			//System.out.println("click identified");
			System.out.println("click identified");
			for (int i=0;i<hor;i++){
				for (int j=0;j<ver;j++){
					Rectangle r1=gr[i][j].get_rectangle();
					Rectangle r2=inner_gr[i][j].get_rectangle();
					
					//----------------------------------------
					//!!! Needs to change according to number of players remaining in the game
					if (turn==0)
					{r1.setStroke(Color.rgb(red[0],green[0],blue[0]));
					r2.setStroke(Color.rgb(red[0],green[0],blue[0]));
					for (int k=0;k<hor+1;k++){
						for (int l=0;l<ver+1;l++){
							Line c= arr.get(k*(ver+1)+l);
							c.setStroke(Color.rgb(red[0],green[0],blue[0]));		 
							}
					}
					}
					if (turn==1)
						{r1.setStroke(Color.rgb(red[1],green[1],blue[1]));
						r2.setStroke(Color.rgb(red[1],green[1],blue[1]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[1],green[1],blue[1]));		 
								}
						}						
						}
					if (turn==2)
					{
						r1.setStroke(Color.rgb(red[2],green[2],blue[2]));
						r2.setStroke(Color.rgb(red[2],green[2],blue[2]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[2],green[2],blue[2]));		 
								}
						}	
					}
					if (turn==3)
					{
						r1.setStroke(Color.rgb(red[3],green[3],blue[3]));
						r2.setStroke(Color.rgb(red[3],green[3],blue[3]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[3],green[3],blue[3]));		 
								}
						}	
					}
					if (turn==4)
					{
						 r1.setStroke(Color.rgb(red[4],green[4],blue[4]));
						 r2.setStroke(Color.rgb(red[4],green[4],blue[4]));
							for (int k=0;k<hor+1;k++){
								for (int l=0;l<ver+1;l++){
									Line c= arr.get(k*(ver+1)+l);
									c.setStroke(Color.rgb(red[4],green[4],blue[4]));		 
									}
							}	
					}
					if (turn==5)
					{
						r1.setStroke(Color.rgb(red[5],green[5],blue[5]));
						r2.setStroke(Color.rgb(red[5],green[5],blue[5]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[5],green[5],blue[5]));		 
								}
						}	
					}
					if (turn==6)
					{
						r1.setStroke(Color.rgb(red[6],green[6],blue[6]));
						r2.setStroke(Color.rgb(red[6],green[6],blue[6]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[6],green[6],blue[6]));		 
								}
						}	
					}
					if (turn==7)
					{
						r1.setStroke(Color.rgb(red[7],green[7],blue[7]));
						r2.setStroke(Color.rgb(red[7],green[7],blue[7]));
						for (int k=0;k<hor+1;k++){
							for (int l=0;l<ver+1;l++){
								Line c= arr.get(k*(ver+1)+l);
								c.setStroke(Color.rgb(red[7],green[7],blue[7]));		 
								}
						}
					}
					//----------------------------------------
				}
			}
		
			
			for(int k=0;k<hor;k++)
			{
				for(int l=0;l<ver;l++)
				{
					//System.out.println(grid);
					grid[k][l]=new grid(gr1[k][l].player_index+1,gr1[k][l].value);
					  
					//System.out.print(gr1[k][l].player_index+1);
					// .getClass(System.out.println("abc"+gr1);
					to_serialize obj=new to_serialize(alive,num_turn,gr,gr1,all_players,grid,turn,prev_turn,num_players,red, green, blue,hor,ver);
				  	try {
						serialize(obj,"1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("");
			}
			
		}
			
		}
	}
	
	public	 static void	serialize(to_serialize gr1,String name) throws	IOException	
	{	
		//System.out.println("abc");
		ObjectOutputStream out	=	null;	
		try	
		{	
				out	=	new	ObjectOutputStream	(	
				new FileOutputStream("C:/Users/Arushi Chauhan/workspace/agguchain/src" + name + ".txt"));	
				out.writeObject(gr1);	
		}	
		finally	
		{	
				out.close();	
		
		}			 
									
	}
	
	public	static to_serialize deserialize(String name)		
			throws	IOException,	ClassNotFoundException  
			{	
		//System.out.println("def");
			ObjectInputStream	in	=	null;	
			try	
			{	
				in	=new  ObjectInputStream	(new	FileInputStream("C:/Users/Arushi Chauhan/workspace/agguchain/src" + name + ".txt"));	
				to_serialize gr1	=(to_serialize)in.readObject();					
				return gr1;
			}
			catch(Exception e)
			{
				to_serialize obj=new to_serialize(null,0,null,null,null,null,0,0,0,null,null,null,0,0);
			
				return obj;
				
			}	
			finally
			{  // System.out.println("Raj");
			    if(in!=null)
				in.close();	
				//System.out.print("KKK");
			}			
										
			}				
	public void resumeGame() throws ClassNotFoundException, IOException
	{
		//to_serialize obj=Main.deserialize("1");
		//AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top1.fxml")); 	 
//		s2controller obj1=new s2controller();
//		mainLayout.getChildren().setAll(a1);
	//	Group root=new Group();
		to_serialize gr2=deserialize("1");
		Group root=null;
		
		if(gr2.hor==6)
		{
			AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top.fxml")); 
			mainLayout.getChildren().setAll(a1);
			root=new Group();
		}
		
		else if(gr2.hor==10)
		{
			AnchorPane a1=FXMLLoader.load(Main.class.getResource("pages/top1.fxml")); 
			mainLayout.getChildren().setAll(a1);
			root=new Group();
		}
		
		if(gr2.gr1==null)
		{
			JLabel label = new JLabel("Sorry! No previously saved game.");
			label.setFont(new Font("Arial", Font.BOLD, 18));
			UIManager.put("OptionPane.minimumSize",new Dimension(500,100)); 
			int input= JOptionPane.showOptionDialog(null,label,"Game Status",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null,null);
		    
			if(input==0)
			{
				 
				try {
					AnchorPane a=FXMLLoader.load(Main.class.getResource("pages/s1.fxml"));
					mainLayout.getChildren().setAll(a);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
		grid[][] grid=gr2.gr1;
		
		turn=gr2.turn;
		prev_turn=gr2.prev_turn;
		num_players=gr2.num_players;
		hor=gr2.hor;
		ver=gr2.ver;
		red=gr2.red;
		green=gr2.green;
		blue=gr2.blue;
		this.grid=gr2.gr1;
		gr1=gr2.norm;
		
		 //System.out.println(gr1);
		all_players=gr2.all_players;
		num_turn=gr2.num_turn;
		alive=gr2.alive;
		
		gr21=new compute_cell[hor][ver];
		old_grid=new grid[hor][ver];
		for (int i=0;i<gr2.hor;i++){
			for (int j=0;j<gr2.ver;j++){
				int pl=grid[i][j].value;
				old_grid[i][j]=new grid(gr1[i][j].player_index,gr1[i][j].value);
				gr21[i][j]=new compute_cell(this,i,j);
				gr21[i][j].value=grid[i][j].value;
				gr21[i][j].player_index=grid[i][j].player_index-1;	 
				System.out.print(pl+" ");
			}
			System.out.println("");
		}
		System.out.println("****");
		
		
		gr=new cell[hor][ver];
		inner_gr=new cell[hor][ver];
		arr=new ArrayList<>();
		 
		for (int i=0;i<hor+1;i++)
		{
				for (int j=0;j<ver+1;j++)
				{	
					Line c=null;
					if(hor==6 && ver==9)
					{
						c=new Line(i*50+150, j*50+150,i*(46)+162,j*46+168);
					}
					else
					{
						c=new Line(i*50+50, j*50+70,i*(46)+70,j*46+100);
					}
					c.setStroke(Color.rgb(red[turn],green[turn],blue[turn]));
					arr.add(c);
					root.getChildren().add(c);
					 
			 
				}
		}
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				//cell c=null;
				if(hor==6 && ver==9)
				{inner_gr[i][j]=new cell(this,i,j,i*(46)+162,j*46+168,46,46);}
				else
				{
					inner_gr[i][j]=new cell(this,i,j,i*(46)+70,j*46+100,46,46);
				}
				root.getChildren().add(inner_gr[i][j]);
			 
			}
		}
	
		//gr21=new compute_cell[hor][ver];
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				//cell c=null;
			if (hor==6 && ver==9)
				{
					gr[i][j]=new cell(this,i,j,i*50+150,j*50+150,50,50);
				}
				
				else
				{
					//System.out.println("abc");
					gr[i][j]=new cell(this,i,j,i*50+50,j*50+70,50,50);
				}
				//gr1[i][j]=new compute_cell(this,i,j);
				root.getChildren().add(gr[i][j]);
				gr1[i][j]=new compute_cell(this,i,j);
				gr1[i][j].value=gr21[i][j].value;
				gr1[i][j].player_index=gr21[i][j].player_index;
				gr[i][j].setOnMouseClicked(new cell_click_event());
			}
		}
		//System.out.println();
		//System.out.println(gr[gx]);
		for(int i=0;i<hor;i++)
		{
			for(int j=0;j<ver;j++)
			{
				//if (gr[i][j]==null)System.out.println(i+" :: "+j);
				//System.out.println(gr1);
				if (gr1[i][j].value==1){
					atom a=new atom(this,false,i,j);
					final PhongMaterial temp_color=new PhongMaterial();
					temp_color.setDiffuseColor(Color.rgb(red[gr1[i][j].player_index],green[gr1[i][j].player_index] ,blue[gr1[i][j].player_index]));
					temp_color.setSpecularColor(Color.BLACK);
					a.crc.setMaterial(temp_color);
					gr[i][j].a1=a;
					gr[i][j].molatom=a.molatom;
					gr[i][j].getChildren().add(a.molatom);
					a.molatom.setLayoutX(25);
					a.molatom.setLayoutY(25);
					gr[i][j].value=1;
					gr[i][j].a1.player_index=gr1[i][j].player_index;
				}
				else if (gr1[i][j].value==2){
					atom2 a=new atom2(this,false,i,j);
					final PhongMaterial temp_color=new PhongMaterial();
					temp_color.setDiffuseColor(Color.rgb(red[gr1[i][j].player_index],green[gr1[i][j].player_index] ,blue[gr1[i][j].player_index]));
					temp_color.setSpecularColor(Color.BLACK);
					gr[i][j].a2=a;
					a.crc.setMaterial(temp_color);
					a.crc2.setMaterial(temp_color);
					gr[i][j].molatom=a.molatom;
					PathTransition p1=new PathTransition();
					p1.setPath(new Circle(10));
					p1.setNode(a.crc);
					p1.setDuration(Duration.millis(2000));
					p1.setCycleCount(Timeline.INDEFINITE);
					p1.setInterpolator(Interpolator.LINEAR);
					PathTransition p2=new PathTransition();
					p2.setPath(new Circle(1.5));
					p2.setNode(a.crc2);
					p2.setDuration(Duration.millis(2000));
					p2.setCycleCount(Timeline.INDEFINITE);
					p2.setInterpolator(Interpolator.LINEAR);
					p1.play();
					p2.play();
					gr[i][j].getChildren().add(a.molatom);
					a.molatom.setLayoutX(25);
					a.molatom.setLayoutY(25);
					gr[i][j].value=2;
					gr[i][j].a2.player_index=gr1[i][j].player_index;
				}
				else if (gr1[i][j].value==3) {
					atom3 a=new atom3(this,false,i,j);
					final PhongMaterial temp_color=new PhongMaterial();
					temp_color.setDiffuseColor(Color.rgb(red[gr1[i][j].player_index],green[gr1[i][j].player_index] ,blue[gr1[i][j].player_index]));
					temp_color.setSpecularColor(Color.BLACK);
					gr[i][j].a3=a;
					a.crc.setMaterial(temp_color);
					a.crc2.setMaterial(temp_color);
					a.crc3.setMaterial(temp_color);
					gr[i][j].molatom=a.molatom;
					gr[i][j].getChildren().add(a.molatom);
					RotateTransition r2=new RotateTransition();
					r2.setNode(gr[i][j].molatom);
					r2.setAxis(Rotate.Z_AXIS);
					r2.setDuration(Duration.millis(2000));
					r2.setCycleCount(Timeline.INDEFINITE);
					r2.setInterpolator(Interpolator.LINEAR);
					r2.setToAngle(360);
					r2.play();
					a.molatom.setLayoutX(17);
					a.molatom.setLayoutY(17);
					gr[i][j].value=3;
					gr[i][j].a3.player_index=gr1[i][j].player_index;
				}
			}
		}
		
		mainLayout.getChildren().add(root);
		}
 
	}
    
	public void play1(AnchorPane a1,int n,int red[],int green[],int blue[],int hor,int ver) throws IOException
	{
		mainLayout.getChildren().setAll(a1);
		Group root=new Group();
		//System.out.println(n+2);
		num_players=n+2;
		this.hor=hor;
		this.ver=ver;
	
		//System.out.println(num_players);
		
		this.red=red;
		this.green=green;
		this.blue=blue;
		
		this.alive=new boolean[num_players];
		for (int i=0;i<num_players;i++){
			alive[i]=true;
		}
		this.turn=0;
		this.prev_turn=0;
		this.num_turn=0;
		this.root=new Group();
		
		{
			alive=new boolean[num_players];
			all_players=new player[num_players];
			
			for (int i=0;i<num_players;i++){
				alive[i]=true;
				all_players[i]=new player(i,red[i],green[i],blue[i]);
			}
		}
		
		
		inner_gr=new cell[hor][ver];
		 
		arr=new ArrayList<>();
		
		 
		for (int i=0;i<hor+1;i++){
			for (int j=0;j<ver+1;j++)
			{	
				Line c=null;
				if(hor==6 && ver==9)
				{
					c=new Line(i*50+150, j*50+150,i*(46)+162,j*46+168);
				}
				else
				{
					c=new Line(i*50+50, j*50+70,i*(46)+70,j*46+100);
				}
				c.setStroke(Color.rgb(red[turn],green[turn],blue[turn]));
				arr.add(c);
				root.getChildren().add(c);
				 
		 
			}
		}
		 
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				cell c=null;
				if(hor==6 && ver==9)
				{c=new cell(this,i,j,i*(46)+162,j*46+168,46,46);}
				else
				{
					c=new cell(this,i,j,i*(46)+70,j*46+100,46,46);
				}
				root.getChildren().add(c);
				inner_gr[i][j]=c;
			 
			}
		}
		 
		
		gr=new cell[hor][ver];
		gr1=new compute_cell[hor][ver];
		gr21=new compute_cell[hor][ver];
		grid=new grid[hor][ver];

//		System.out.println(grid);
//		System.out.println(gr);
//		System.out.println(gr1);
		for(int k=0;k<hor;k++)
		{
			for(int l=0;l<ver;l++)
			{
				grid[k][l]=new grid(0,0);
				  
				 
				to_serialize obj=new to_serialize(alive,num_turn,gr,gr1,all_players,grid,turn,prev_turn,num_players,red, green, blue,hor,ver);;
			  	try {
					serialize(obj,"1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("");
		}
		
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				cell c=null;
			if (hor==6 && ver==9)
				{
					c=new cell(this,i,j,i*50+150,j*50+150,50,50);
				}
				
				else
				{
					//System.out.println("abc");
					c=new cell(this,i,j,i*50+50,j*50+70,50,50);
				}
				gr1[i][j]=new compute_cell(this,i,j);
				gr21[i][j]=new compute_cell(this,i,j);
				root.getChildren().add(c);
				gr[i][j]=c;
				c.setOnMouseClicked(new cell_click_event());
				
			 
			}
		}
	 
//		grid g=new grid(gr);
	//	System.out.println(mainLayout);
		mainLayout.getChildren().add(root);
		//System.out.println(mainLayout.getChildren());
//		Scene scene=new Scene(root,500,550,Color.BLACK);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
	}
	 
	public static void main(String[] args) {
		launch(args);
	}
}
