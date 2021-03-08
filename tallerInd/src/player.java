import processing.core.PApplet;
import processing.core.PImage;

public class player 
{
	public static int x; 
	int yBig, ySmall;
	int sizeBig, sizeSmallX, sizeSmallY;
	PImage spaceship;
	
	@SuppressWarnings("static-access")
	public player(PApplet app) 
	{
		spaceship = app.loadImage("spaceship_v2.png");
		
		this.x = 240;
		this.yBig = 430;
		this.sizeBig = 50;
		
		this.ySmall = 400;
		this.sizeSmallX = 20;
		this.sizeSmallY = 50;
	}
	
	@SuppressWarnings("static-access")
	public void paint(PApplet app)
	{
		app.imageMode(app.CENTER);
		app.image(spaceship, x, yBig);

	}
	
	public void move(PApplet app)
	{	
		if(app.keyPressed)
		{
			switch(app.key)
			{
			case 'a':
				x -= 4;
				break;
			case 'A':
				x -= 4;
				break;
			case 'd':
				x += 4;
				break;
			case 'D':
				x += 4;
				break;
			default:
				
				break;
			}
		}
	}
	
	public void walls(PApplet app)
	{
		if(x > 475)
		{
			x = 474;
		}
		if(x < 24)
		{
			x = 25;
		}
	}
	
	public int getyBig()
	{
		return yBig;
	}
	
	public void setyBig(int yBig) 
	{
		this.yBig = yBig;
	}
}
