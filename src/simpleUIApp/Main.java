package simpleUIApp;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import fr.ubordeaux.simpleUI.*;

public class Main {
	public static void main(String[] args){
		Random random = new Random();
		ArrayList<Item> testItemList = new ArrayList<Item>();
		/*
		 * Randomly position 25 Ships in the Arena zone (defined afterwards)
		 */
		//for (int i = 0; i < 2; i++) {
			//testItemList.add(new SpaceShip(random.nextInt(400), random.nextInt(500), 10,1));
		//}

		planete planet1=new planete(random.nextInt(400), random.nextInt(500), 50,1,10);
		testItemList.addAll(planet1.createSpaceShip(1));
		planete planet2=null;
		planete planet3=null;
		boolean flag=true;
		int x=random.nextInt(400);
		int y=random.nextInt(500);
		int x1=random.nextInt(400);
		int y1=random.nextInt(500);
		while(flag) {
			planet2=new planete(x, y,50,3,10);
			planet3=new planete(x1, y1,50,0);
			if(planet1.distance(planet2) && planet1.distance(planet3) && planet2.distance(planet3)) {
				flag=false;
				//planet2=new planete(x, y,50,1);
			}
			x=random.nextInt(400);
			y=random.nextInt(500);
			x1=random.nextInt(400);
			y1=random.nextInt(500);
			System.out.println("x");
		}
		testItemList.addAll(planet2.createSpaceShip(2));
		testItemList.add(planet1);
		testItemList.add(planet2);
		testItemList.add(planet3);
		/*for(int i=0;i<2;i++){
			testItemList.add(new planete(random.nextInt(400), random.nextInt(500), 50));
		}*/
		Manager manager = new Manager();
		Run r = new Run(500, 600);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(testItemList, manager, r);
	}
}