package simpleUIApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;



public class planete extends Item {


	private Item objective;
	private int color;
	private int spaceship;

	public planete(double x, double y, int w, int color) {
		super(x, y, w);
		this.color=color;
		objective = this;
	}
	
	
	public planete(double x, double y, int w, int color,int spaceship) {
		super(x, y, w);
		this.color=color;
		this.spaceship=spaceship;
		objective = this;
	}

	public void setObjective(Item o) {
		this.objective = o;
	}

	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		if(color==0) {
			arg0.setColor(Color.white);
		}
		else if(color==1){
			arg0.setColor(Color.blue);
		}
		else {
			arg0.setColor(Color.green);
		}
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean distance(planete p) {
			if((p.getLocation().getX()-this.getLocation().getX()>25 && p.getLocation().getY()-this.getLocation().getY()>25)||(p.getLocation().getX()-this.getLocation().getX()<-25 && p.getLocation().getY()-this.getLocation().getY()<-25)) {
				return true;
			}
			else {
				System.out.println("true");
				return false;
			}
	}
	
	public ArrayList<Item> createSpaceShip(int color){
		Random random = new Random();
		ArrayList<Item> testItemList = new ArrayList<Item>();
		for (int i = 0; i < spaceship; i++) {
			testItemList.add(new SpaceShip(random.nextInt(400), random.nextInt(500), 10,color));
		}
		return testItemList;
		
	}
}