import processing.core.PApplet;
import processing.core.PImage;

public class weakEnemies 
{
	private int posX, posY, moveRate;
	PImage weakEnemy;

	public weakEnemies(int posX, int posY, int size, PApplet app) 
	{
		weakEnemy = app.loadImage("alien_green.png");
		
		this.posX = posX;
		this.posY = posY;
		
		moveRate = 1;
	}
	
	public void mov()
	{
		posY += moveRate;
	}
	
	@SuppressWarnings("static-access")
	public void draw(PApplet app)
	{
		app.imageMode(app.CENTER);
		app.image(weakEnemy, posX, posY);
		mov();
	}
	
	public int getPosX() 
	{
		return posX;
	}
	
	public void setPosX(int posX) 
	{
		this.posX = posX;
	}
	
	public int getPosY() 
	{
		return posY;
	}
	
	public void setPosY(int posY) 
	{
		this.posY = posY;
	}
	

}
