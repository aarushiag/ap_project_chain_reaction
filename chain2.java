package chain_test1;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
class cell extends StackPane{
	private Rectangle r;
	private Label l;
	private int value;
	public cell(int gx,int gy,int x,int y,int width,int height){
		r=new Rectangle(width,height);
		r.setStroke(Color.RED);
		r.setFill(Color.BLACK);
		Label l=new Label(new String("0"));
		value=0;
		setTranslateX(x);
		setTranslateY(y);
		getChildren().addAll(r);
	}
	public Rectangle get_rectangle(){
		return r;
	}
	public void increase_value(){
		value++;
	}
	public void burst_the_cell(){
		value=0;
	}
	public boolean change_value(){
		if (value<3){
			increase_value();
			return false;
		}
		else {
			burst_the_cell();
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
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Chain Reaction");
		Group root=new Group();
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
		int n=6;
		int m=9;
		cell[][] gr=new cell[n][m];
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				cell c=new cell(i,j,i*50+90,j*50+60,50,50);
				root.getChildren().add(c);
				gr[i][j]=c;
				c.setOnMouseClicked(new EventHandler<MouseEvent>(){
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
				});
			}
		}
		grid g=new grid(gr);
		//root.getChildren().add(g.get_rectangle());
		Rectangle r=g.get_rectangle();
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
		root.getChildren().add(r);
		Scene scene=new Scene(root,500,550,Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
