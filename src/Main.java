
public class Main {

	public static void main(String[] args) {
		Life life = new Life(5, 10);
		boolean gameOver = false;
		
		life.setLife(20);
		
		System.out.println("Initial map:");
		life.printMap();
		
		int counter = 0;
		
		while (!gameOver) {
			life.performDay();
			life.performNight();
			
			counter++;
			
			if (life.getCount() < 1 || life.getCount() == life.getMaxCount()) {
				gameOver = true;
			}
		}
		System.out.println("Creatures: " + life.getCount() + ", iterations: " + counter);
	}

}
