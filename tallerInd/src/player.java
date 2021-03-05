import processing.core.PApplet;

public class player 
{
	public static int x; 
	int yBig, ySmall;
	int sizeBig, sizeSmallX, sizeSmallY;
	
	public player() 
	{
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
		app.rectMode(app.CENTER);
		app.fill(255, 0, 0);
		app.rect(x, ySmall, sizeSmallX, sizeSmallY);
		app.square(x, yBig, sizeBig);
		

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
}
