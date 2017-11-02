package chain_test1;
//import java.nio.file.Path;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
//import javafx.event.EventListener;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
class player{
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
class atom{
	int num;
	int player_index;
	chain2 ch;
	public Sphere crc;
	public Group molatom;
	public atom(chain2 ch){
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
		System.out.println("hi :)");
		player_index=ch.turn;
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
		if (ch.turn==0)crc.setMaterial(redm);
		if (ch.turn==1)crc.setMaterial(greenm);
		if (ch.turn==2)crc.setMaterial(bluem);
		if (ch.turn==3)crc.setMaterial(pinkm);
		if (ch.turn==4)crc.setMaterial(yellowm);
		if (ch.turn==5)crc.setMaterial(cyanm);
		if (ch.turn==6)crc.setMaterial(purplem);
		if (ch.turn==7)crc.setMaterial(whitem);
		//-------------------------------------------------
		
	}
}
class atom2 extends atom{
	public Sphere crc2;
	//public Group diatom;
	public atom2(chain2 ch){
		super(ch);
		num=2;
		crc2=new Sphere();
		crc2.setRadius(10);
		change_color(crc2);
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
	public void change_color(){
		super.change_color(crc);
		super.change_color(crc2);
	}
}
class atom3 extends atom2{
	public Sphere crc3;
	public atom3(chain2 ch){
		super(ch);
		num=3;
		crc3=new Sphere();
		crc3.setRadius(10);
		change_color(crc3);
		crc3.setTranslateX(8);
		crc3.setTranslateY(15);
		molatom.getChildren().add(crc3);
		/*Rotate rotate=new Rotate();
		rotate.setAngle(20);
		rotate.setPivotX(150);
		rotate.setPivotY(225);
		molatom.getTransforms().addAll(rotate);*/
	}
	public void change_color(){
		super.change_color(crc);
		super.change_color(crc2);
		super.change_color(crc3);
	}
}
class cell extends Pane{
	private Rectangle r;
	private chain2 ch;
	//private Label l;
	private int value;
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
	public cell(chain2 ch,int gx,int gy,int x,int y,int width,int height){
		r=new Rectangle(width,height);
		r.setStroke(Color.rgb(ch.red[0],ch.green[0],ch.blue[0]));
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
	public void increase_value(boolean toggle){
		if ((value==0)&&(toggle==false)){
			a1=new atom(ch);
			System.out.println(a1.get_player_num()+"[]");
			value++;
			molatom=a1.molatom;
			if (((gx==0)&&(gy==0))||((gx==0)&&(gy==ch.hor-1))||((gx==ch.ver-1)&&(gy==ch.hor-1))||((gx==ch.ver-1)&&(gy==0))){
				System.out.println("I rotate");
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
			a2=new atom2(ch);
			molatom=a2.molatom;
			value++;
			//this.getChildren().add(a2.molatom);
			//RotateTransition rt=new RotateTransition();
			//RotateTransition rt2=new RotateTransition();
			Ellipse crc_path=new Ellipse(3,7);
			//Circle crc2_path=new Circle(20);
			PathTransition pt=new PathTransition();
			pt.setNode(a2.crc);
			pt.setPath(crc_path);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(3000));
			if ((gx==0)||(gy==0)||(gx==ch.hor-1)||(gy==ch.ver-1))pt.setDuration(Duration.millis(2000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
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
			crc_path.setVisible(false);
			//crc2_path.setVisible(false);
			pt.play();
			//pt2.play();
			//StackPane r1=new StackPane();
			//this.getChildren().add(a2.crc2);
			//StackPane r2=new StackPane();
			this.getChildren().add(molatom);
			molatom.setLayoutX(15);
			molatom.setLayoutY(23);
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
			a2=new atom2(ch);
			a2.change_color();
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
			Ellipse crc_path=new Ellipse(3,7);
			//Circle crc2_path=new Circle(20);
			PathTransition pt=new PathTransition();
			pt.setNode(a2.crc);
			pt.setPath(crc_path);
			pt.setInterpolator(Interpolator.LINEAR);
			pt.setDuration(Duration.millis(3000));
			if ((gx==0)||(gy==0)||(gx==ch.hor-1)||(gy==ch.ver-1))pt.setDuration(Duration.millis(2000));
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
			/*PathTransition pt2=new PathTransition();
			pt2.setNode(a2.crc2);
			pt2.setPath(crc2_path);
			pt2.setInterpolator(Interpolator.LINEAR);
			pt2.setDuration(Duration.millis(10000));
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setCycleCount(Timeline.INDEFINITE);
			crc_path.setVisible(false);
			crc2_path.setVisible(false);*/
			pt.play();
			crc_path.setVisible(false);
			//pt2.play();
			//StackPane r1=new StackPane();
			//this.getChildren().add(a2.crc2);
			this.getChildren().add(molatom);
			molatom.setLayoutX(15);
			molatom.setLayoutY(23);
			//r1.getChildren().add(a2.crc2);
			//this.getChildren().add(crc_path);
			//r1.getChildren().add(crc2_path);
			//this.getChildren().add(r1);
			//this.getChildren().add(a2.molatom);
			
		}
		else if ((value==2)&&(ch.turn==a2.get_player_num())){
			this.getChildren().remove(molatom);
			a3=new atom3(ch);
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
			Ellipse crc_path=new Ellipse(3,4);
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
			pt2.setCycleCount(Timeline.INDEFINITE);
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
			crc_path.setVisible(false);
			crc_path2.setVisible(false);
			//crc2_path.setVisible(false);
			//crc3_path.setVisible(false);
			//pt.play();
			ParallelTransition p=new ParallelTransition(pt,pt2);
			p.play();
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
			molatom.setLayoutX(15);
			molatom.setLayoutY(15);
			//if (toggle==true)ch.turn=(ch.turn+1)%8;
			/*if (toggle==false){
				System.out.println("neighbour burst");
				a3.change_color();
			}*/
			
		}
		else if ((value==2)&&(toggle==false)){
			this.getChildren().remove(molatom);
			a3=new atom3(ch);
			a3.change_color();
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
			Ellipse crc_path=new Ellipse(3,4);
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
			pt2.setCycleCount(Timeline.INDEFINITE);
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
			crc_path.setVisible(false);
			crc_path2.setVisible(false);
			//crc3_path.setVisible(false);
			ParallelTransition p=new ParallelTransition(pt,pt2);
			p.play();
			//pt.play();
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
			molatom.setLayoutX(15);
			molatom.setLayoutY(15);
			
		}
		/*PointLight light=new PointLight(Color.WHITE);
		light.setTranslateX(-1000);
		light.setTranslateY(100);
		light.setTranslateZ(-1000);
		this.getChildren().add(light);*/
	}
	public void set_color(Sphere crc){
		System.out.println("hi :(");
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
		if (ch.turn==0)crc.setMaterial(redm);
		if (ch.turn==1)crc.setMaterial(greenm);
		if (ch.turn==2)crc.setMaterial(bluem);
		if (ch.turn==3)crc.setMaterial(pinkm);
		if (ch.turn==4)crc.setMaterial(yellowm);
		if (ch.turn==5)crc.setMaterial(cyanm);
		if (ch.turn==6)crc.setMaterial(purplem);
		if (ch.turn==7)crc.setMaterial(whitem);
		//----------------------------------------------------
		
	}
	public void clear_sphere(Group s){
		getChildren().remove(s);
	}
	public void burst_the_cell(boolean toggle){
		value=0;
		System.out.println("cell burst");
		this.getChildren().remove(molatom);
		double x1=r.getLayoutX()+25;
		double y1=r.getLayoutY()+25;
		ParallelTransition p=new ParallelTransition();
		if ((gx-1>=0)&&(gy>=0)){
			Sphere s=new Sphere(10);
			set_color(s);
			double x2=x1-50;
			double y2=y1;
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
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
			set_color(s);
			double x2=x1+50;
			double y2=y1;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
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
			set_color(s);
			double x2=x1;
			double y2=y1-50;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
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
			set_color(s);
			double x2=x1;
			double y2=y1+50;
			//s.setTranslateX(x1);
			//s.setTranslateY(y1);
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
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
			//pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
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
		ParallelTransition p2=new ParallelTransition(p);
		System.out.println(ch.turn+" -");
		//if (toggle==true)p2.setOnFinished(e->ch.increment_turn());
		p2.play();
		System.out.println(ch.turn+" -");
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
	public boolean change_value(boolean toggle){
		System.out.println(gx+" "+gy);
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
	
	/*public void change_color_of_grid(int turn){
		r.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent t){
				System.out.println("click identified");
				for (int i=0;i<6;i++){
					for (int j=0;j<9;j++){
						Rectangle r1=now_grid[i][j].get_rectangle();
						if (turn==0)r1.setStroke(Color.RED);
						if (turn==1)r1.setStroke(Color.GREEN);
						if (turn==2)r1.setStroke(Color.BLUE);
						if (turn==3)r1.setStroke(Color.PINK);
						if (turn==4)r1.setStroke(Color.YELLOW);
						if (turn==5)r1.setStroke(Color.CYAN);
						if (turn==6)r1.setStroke(Color.MEDIUMPURPLE);
						if (turn==7)r1.setStroke(Color.SNOW);
					}
				}
				
			}
		});
	}*/
	
}
public class chain2 extends Application{
	public static int turn=0;
	public int num_turn=0;
	public cell[][] gr;
	public Group root;
	public int num_players=4;
	public player[] all_players;
	public int hor;
	public int ver;
	public int[] red={0,255,0,150,120,10,255,255};
	public int[] green={255,0,0,20,255,255,10,255};
	public int[] blue={0,0,255,190,10,255,255,255};
	public boolean[] alive;
	{
		alive=new boolean[num_players];
		all_players=new player[num_players];
		
		for (int i=0;i<num_players;i++){
			alive[i]=true;
			all_players[i]=new player(i,red[i],green[i],blue[i]);
		}
	}
	public void kill_player(int index){
		if (index<num_players){
		alive[index]=false;
		}
	}
	public void increment_turn(){
		System.out.println(turn+" --");
		turn=(turn+1)%num_players;
		while(alive[turn]==false){
			turn=(turn+1)%num_players;
		}
		System.out.println(turn+" --");
	}
	class cell_click_event implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent m){
			//System.out.println("cell click");
			cell temp=(cell)m.getSource();
			System.out.println(m.getScreenX()+" "+m.getScreenY()+" "+turn);
			System.out.println(temp.gx+" "+temp.gy);
			boolean b=false;
			if (temp.get_value()==0){
				num_turn++;
				atom a=new atom(chain2.this);
				temp.a1=a;
				temp.value_plus();
				temp.getChildren().add(temp.a1.get_atom());
				if (((temp.gx==0)&&(temp.gy==0))||((temp.gx==0)&&(temp.gy==ver-1))||((temp.gx==hor-1)&&(temp.gy==ver-1))||((temp.gx==hor-1)&&(temp.gy==0))){
					System.out.println("I rotate");
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
				//while(alive[turn-1]==false){
				
				if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr[i][j].get_player_index();
							if (gr[i][j].get_value()>0){
							all_players[pl].num_atom++;
						}
						}
					}
					System.out.println();
					for (int i=0;i<num_players;i++){
						System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}
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
				temp.getChildren().remove(temp.a1.get_atom());
				System.out.println(turn+" :)");
				b=temp.change_value(true);
				System.out.println(turn+" :)");
				//evaluation of number of atoms should be done after cells have burst
				if (num_turn>num_players){
					for (int i=0;i<num_players;i++){
						all_players[i].num_atom=0;
					}
					for (int i=0;i<hor;i++){
						for (int j=0;j<ver;j++){
							int pl=gr[i][j].get_player_index();
							if (gr[i][j].get_value()>0){
							all_players[pl].num_atom++;
							}
						}
					}
					System.out.println();
					for (int i=0;i<num_players;i++){
						System.out.print(all_players[i].num_atom+" ");
						if (all_players[i].num_atom==0)alive[i]=false;
					}
				}
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
			for (int i=0;i<num_players;i++){
				if (alive[i]==true){
					ct++;
					flag=i;
				}
			}
			if (ct==1){
				System.out.println("Player "+(flag+1)+" won");
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
			System.out.println("click identified");
			for (int i=0;i<hor;i++){
				for (int j=0;j<ver;j++){
					Rectangle r1=gr[i][j].get_rectangle();
					//----------------------------------------
					//!!! Needs to change according to number of players remaining in the game
					if (turn==0)r1.setStroke(Color.rgb(red[0],green[0],blue[0]));
					if (turn==1)r1.setStroke(Color.rgb(red[1],green[1],blue[1]));
					if (turn==2)r1.setStroke(Color.rgb(red[2],green[2],blue[2]));
					if (turn==3)r1.setStroke(Color.rgb(red[3],green[3],blue[3]));
					if (turn==4)r1.setStroke(Color.rgb(red[4],green[4],blue[4]));
					if (turn==5)r1.setStroke(Color.rgb(red[5],green[5],blue[5]));
					if (turn==6)r1.setStroke(Color.rgb(red[6],green[6],blue[6]));
					if (turn==7)r1.setStroke(Color.rgb(red[7],green[7],blue[7]));
					//----------------------------------------
				}
			}
		}
	}

	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Chain Reaction");
		root=new Group();
		//Line line=new Line(0,45,520,45);
		/*line.setFill(Color.AQUA);
		line.setStroke(Color.AQUA);
		Label l=new Label("Chain Reaction");
		l.setTextFill(Color.WHITE);
		//l.setFont(new Font("Arial",20));
		l.setStyle("-fx-font: 24 arial;-fx-padding: 10;");
		Button b=new Button("Undo");
		//b.setMaxSize(30,200);
		b.setStyle("-fx-background-color: #222222;-fx-font-size: 18; -fx-text-fill: #ffffff;-fx-border-color: #eeeeee;");
		//b.setAlignment(Pos.TOP_RIGHT);
		root.getChildren().add(line);
		root.getChildren().add(l);
		root.getChildren().add(b);*/
		/*Rectangle[][] r=new Rectangle[9][6];
		for (int i=0;i<1;i++){
			for (int j=0;j<1;j++){
				r[i][j]=new Rectangle();
				r[i][j].setX(i+5);
				r[i][j].setY(j+5);
				r[i][j].setWidth(50);
				r[i][j].setWidth(50);
				root.getChildren().add(r[i][j]);
			}
		}*/
		/*Rectangle r=new Rectangle();
		r.setX(50);
		r.setY(50);
		r.setWidth(50);
		r.setHeight(50);
		root.getChildren().add(r);*/
		hor=6;
		ver=9;
		gr=new cell[hor][ver];
		for (int i=0;i<hor;i++){
			for (int j=0;j<ver;j++){
				cell c=new cell(this,i,j,i*50+90,j*50+60,50,50);
				root.getChildren().add(c);
				gr[i][j]=c;
				c.setOnMouseClicked(new cell_click_event());
				/*c.setOnMouseClicked(new EventHandler<MouseEvent>(){
					@Override
					public void handle(MouseEvent t){
						boolean b=c.change_value();
						if (b==true){
							if ((i-1>=0)&&(j>=0))Event.fireEvent(gr[i-1][j], new MouseEvent(MouseEvent.MOUSE_CLICKED, j, j, j, j, null, j, b, b, b, b, b, b, b, b, b, b, null));
							if ((i+1<=5)&&(j>=0))Event.fireEvent(gr[i+1][j], new MouseEvent(MouseEvent.MOUSE_CLICKED, j, j, j, j, null, j, b, b, b, b, b, b, b, b, b, b, null));
							if ((i>=0)&&(j-1>=0))Event.fireEvent(gr[i][j-1], new MouseEvent(MouseEvent.MOUSE_CLICKED, j, j, j, j, null, j, b, b, b, b, b, b, b, b, b, b, null));
							if ((i>=0)&&(j+1<=8))Event.fireEvent(gr[i][j+1], new MouseEvent(MouseEvent.MOUSE_CLICKED, j, j, j, j, null, j, b, b, b, b, b, b, b, b, b, b, null));
						}
					}
				});*/
				//c.setOnMouseClicked(cell_clicked());
			}
		}
		grid g=new grid(gr);
		//root.getChildren().add(g.get_rectangle());
		/*Rectangle r=g.get_rectangle();
		r.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent t){
				turn=(turn+1)%8;
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
						if (turn==6)r1.setStroke(Color.MEDIUMPURPLE);
						if (turn==7)r1.setStroke(Color.SNOW);
					}
				}
				
			}
		});
		root.getChildren().add(r);*/
		Scene scene=new Scene(root,500,550,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
