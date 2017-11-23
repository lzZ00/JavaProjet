package simpleUIApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

class SpaceShip extends Item {

	private Item objective;
	
	
	private int color;
	private int vitesse;
	private int puissance;

	public SpaceShip(double x, double y, int w,int color) {
		super(x, y, w);
		this.color = color;
		objective = this;
	}
	
	public SpaceShip(double x, double y, int w,int color,int vitesse,int puissace) {
		super(x, y, w);
		this.color = color;
		this.vitesse = vitesse;
		this.puissance = 1;
		objective = this;
	}

	public void setObjective(Item o) {
		this.objective = o;
	}

	private static double squareDistance(Point2D p1, Point2D p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return dx * dx + dy * dy;
	}

	@Override
	public boolean contains(Point2D p) {
		return squareDistance(this.center, p) <= (getWidth() / 2) * (getWidth() / 2);
		
	}

	public void move() {

		if (!objective.contains(this.center)) {
			double newx = center.getX();
			double newy = center.getY();
			if (newx > objective.getLocation().getX()) {
				
				newx--;
			} else {
				
				newx++;
			}
			if (newy > objective.getLocation().getY()) {
				newy--;
			} else {
				newy++;
			}
			center.setLocation(newx, newy);
		} else {
			objective = this;
		}
	}

	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		if(color==0) {
			arg0.setColor(Color.red);
		}
		else if(color==1){
			arg0.setColor(Color.blue);
		}
		else {
			arg0.setColor(Color.green);
		}
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
	}
	
	
}
