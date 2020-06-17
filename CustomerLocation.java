package socialDistanceShopSampleSolution;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.atomic.*;

public class CustomerLocation  { // this is a separate class so don't have to access thread
	
//can protect with Atomic variables or with synchronized	
	private final int ID; //total customers created
	private Color myColor;
	private AtomicBoolean inRoom;
	private AtomicInteger x;
	private AtomicInteger y;
	
	CustomerLocation(int ID ) {
		Random rand = new Random();
		float c = rand.nextFloat();
		myColor = new Color(c, rand.nextFloat(), c);	//only set at beginning	by thread
		inRoom = new AtomicBoolean(false);
		this.ID=ID;
		this.x = new AtomicInteger(0);
		this.y = new AtomicInteger(0);
	}
	/*
	// Thuso Kharibe
	// 		-> All getters and setters must be synchronized
	*/

	//setter
	public  synchronized void  setX(int x) { this.x.set(x);}	
		
	//setter
	public synchronized void  setY(int y) {	this.y.set(y);	}
	
	//setter
	public synchronized void setInRoom(boolean in) {
		this.inRoom.set(in);
}
	//getter
	public synchronized int getX() { return x.get();}	
	
	//getter
	public synchronized int getY() {	return y.get();	}
	
	//getter
		public synchronized int getID() {	return ID;	}

	//getter
		public synchronized boolean inRoom() {
			return inRoom.get();
		}
	//getter
	public synchronized  Color getColor() { return myColor; }
		
}
