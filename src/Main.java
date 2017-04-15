
public class Main {

	public static void main(String[] args) {
		Life life = new Life(5, 10);
		boolean gameOver = false;
		
		life.setLife(20);
		
		System.out.println("Initial map:");
		life.printMap();
		
		int iterations = 0;
		
		while (!gameOver) {
			life.performDay();
			life.performNight();
			
			iterations++;
			
			if (life.getCount() < 1 || life.getCount() == life.getMaxCount()
					|| iterations == 100) {
				gameOver = true;
			}
		}
		System.out.println("Creatures: " + life.getCount() + ", iterations: " + iterations);
	}

}
