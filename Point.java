package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import hello.Main.cell_click_event;
import hello.pages.s1controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public	class	Point	
{	
private	static	Map<String,	Point>	instances	=	new	HashMap<String,	Point>();	
private final int	x,	y;	 //	immutable	
private Point(int	x,	int	y)	
{	 								
	this.x	=	x;	 								
	this.y	=	y;	
}
public	static	Point	getInstance(int	x,	int	y)		
{	
	String	key	=	x	+	",	"	+	y;	
	if	(!instances.containsKey(key))	
	{	 												
		
		instances.put(key,	new	Point(x,	y));	
	}	
	return	instances.get(key);	
}

public static boolean is_Present (int x,int y)
{
	String	key	=	x	+	",	"	+	y;
	return (instances.containsKey(key));

}
	
public	int getX()	{	return	x;	}	
public	int getY()	{	return	y;	}	
public	String	toString()	
{	 								
	return	"("	+	x	+	",	"	+	y	+	")";	
}	
}	