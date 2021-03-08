import processing.core.PApplet;
import processing.core.PImage;

public class strongEnemies
{
	private int posX, posY, moveRate;
	PImage strongEnemy;

	public strongEnemies(int posX, int posY, int size, PApplet app) 
	{
		strongEnemy = app.loadImage("blue_alien.png");
		
		this.posX = posX;
		this.posY = posY;
		moveRate = 2;
	}
	
	public void mov()
	{
		posY += moveRate;
	}
	
	@SuppressWarnings("static-access")
	public void draw(PApplet app)
	{
		app.imageMode(app.CENTER);
		app.image(strongEnemy, posX, posY);
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
