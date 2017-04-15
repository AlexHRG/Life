import java.util.Random;

public class Life {

	int[][] playMap;
	int rows, columns, deathTreshold, divisionTreshold;
	
	final static int FREECELL = 0;
	final static int CREATURE = 1;
	final static int DYING = 2;
	final static int BORNING = 3;
	
	public Life(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		playMap = new int[rows][columns];
		deathTreshold = 3;
		divisionTreshold = 6;
	}
	
	public void printMap(){
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++){
				System.out.print(this.playMap[i][j] + "  ");
			}
			System.out.println(System.lineSeparator());
		}
	}
	
	public void setLife(int quantity){
		int creaturesCounter = 0;
		int randomRow, randomColumn;
		
		while (creaturesCounter < quantity) {
			randomRow = new Random().nextInt(rows);
			randomColumn = new Random().nextInt(columns);
			
			if (playMap[randomRow][randomColumn] != CREATURE) {
				playMap[randomRow][randomColumn] = CREATURE;
				creaturesCounter += 1;
			}
		}
	}
}
