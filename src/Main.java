
public class Main {

	public static void main(String[] args) {
		int rows = 5;
		int columns = 10;
		int creaturesAtStart = 33;
		int deathTreshold = 2;
		int divisionTreshold = 4;
		
		final int ITERATIONLIMIT = 1000;
		boolean gameOver = false;
		int maxCount = rows * columns;
		
		Life life = new Life(rows, columns, creaturesAtStart, deathTreshold, divisionTreshold);

		System.out.println("Initial map:");
		life.printMap();
		
		int iterations = 0;
		
		while (!gameOver) {
			life.performDay();
			life.performNight();
			
			iterations++;
			
			if (life.getCount() < 1 || life.getCount() == maxCount
					|| iterations == ITERATIONLIMIT) {
				gameOver = true;
			}
		}

		System.out.println("Result map:");
		life.printMap();

		String result = life.getCount() == 0
				? "All are dead :(" : life.getCount() == (rows*columns)
				? "Maximum creatures :)" : "Life goes on";

		System.out.println(System.lineSeparator()
				+ "Creatures: " + life.getCount()
				+ ", iterations: " + iterations
				+ System.lineSeparator()
				+ result);
	}

}
