package javagame;

import java.util.Observable;
import java.util.Observer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import javagame.Character.Inventory;

public class InventoryView implements Observer, OnScreen{

	// Properties
	Graphics g;
	Inventory inv;
	final int POS_Y = 410;
	final int POS_X = 120;
	final int HEIGHT = 50;
	final int WIDTH = 480;
	final int ITEM_COUNT = 6;
	final int SECTION_WIDTH = WIDTH / ITEM_COUNT;
	boolean noGraphics;
//	Rectangle outer;
	
	Character obj;
	
	public InventoryView(){
		noGraphics = true;
	}
	
	public void setGraphics(Graphics g) {
		if (noGraphics) {
			this.g = g;
			noGraphics = false;
		}
	}
	
	public void draw() throws SlickException  {
		if (g != null){
//			outer = new Rectangle(POS_X, POS_Y, WIDTH, HEIGHT);
			g.drawRect(POS_X, POS_Y, WIDTH, HEIGHT);
//			System.out.println("aha" + g);
			for (int i = 0; i < ITEM_COUNT; i++) {
				g.setLineWidth(3);
				g.drawRect(POS_X+i*SECTION_WIDTH, POS_Y, SECTION_WIDTH, HEIGHT);
				g.drawString((i+1)+"", (float)(POS_X+i*SECTION_WIDTH + SECTION_WIDTH/2), ((float)(POS_Y) + (float)(HEIGHT*1.1)));
				g.resetLineWidth();
			}
			if (obj != null) {
				for (int i = 0; i < obj.inventory.itemList.size(); i++) {
					String img = obj.inventory.itemList.get(i).getName();
					Image icon= new Image("res/"+img+".png");
					g.drawImage(icon, (float)(POS_X+i*SECTION_WIDTH+SECTION_WIDTH/4), ((float)(POS_Y) + (float)(HEIGHT*0.1)));
				}
			}
			
		}

	}
	
	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
//			System.out.println("invntory view updatelendi");
			obj = (Character)obs;
			/*try {
				draw();
			} catch (SlickException error) {
				
			}*/

	}
	
}
