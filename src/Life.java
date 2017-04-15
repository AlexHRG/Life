import java.util.Random;

public class Life {

	private int[][] playMap;
	private int rows, columns, deathTreshold, divisionTreshold, creaturesCounter;
	
	final static int FREECELL = 0;
	final static int CREATURE = 1;
	final static int DYING = 2;
	final static int BORNING = 3;
	
	public Life(int rows, int columns, int creatures, int deathTreshold, int divisionTreshold){
		this.rows = rows;
		this.columns = columns;
		playMap = new int[rows][columns];
		this.deathTreshold = deathTreshold;
		this.divisionTreshold = divisionTreshold;

		setLife(creatures);
	}
	
	
	public int getCount() {
		return creaturesCounter;
	}
		
	public void printMap(){
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++){
				System.out.print(playMap[i][j] + "  ");
			}
			System.out.println(System.lineSeparator());
		}
	}
	
	public void setLife(int quantity){
		int counter = 0;
		int randomRow, randomColumn;
		
		while (counter < quantity) {
			randomRow = new Random().nextInt(rows);
			randomColumn = new Random().nextInt(columns);
			
			if (playMap[randomRow][randomColumn] == FREECELL) {
				playMap[randomRow][randomColumn] = CREATURE;
				counter += 1;
			}
		}
		
		this.creaturesCounter = quantity;
	}
	
	public void performDay(){
		int neighbours = 0;
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++){
				neighbours = countNeighbours(i, j);
				
				if (playMap[i][j] == FREECELL && neighbours >= divisionTreshold) {
					playMap[i][j] = BORNING;
				} else if (playMap[i][j] == CREATURE && neighbours <= deathTreshold){
					playMap[i][j] = DYING;
				}
			}
		}
	}
	
	public void performNight(){
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++){
				if (playMap[i][j] == BORNING) {
					playMap[i][j] = CREATURE;
					creaturesCounter += 1;
				} else if (playMap[i][j] == DYING){
					playMap[i][j] = FREECELL;
					creaturesCounter -= 1;
				}
			}
		}
	}

	private int countNeighbours(int i, int j) {
		int startRow, finishRow, startColumn, finishColumn;
		int neighbours = 0;
		
		startRow = (i == 0) ? i : i-1;
		finishRow = (i == rows-1) ? i : i+1;
		startColumn = (j == 0) ? j : j-1;
		finishColumn = (j == columns-1) ? j : j+1;
		
		for (int searchRow = startRow; searchRow <= finishRow; searchRow++) {
			for (int searchColumn = startColumn; searchColumn <= finishColumn; searchColumn++) {
				if (playMap[searchRow][searchColumn] == CREATURE) {
					neighbours += 1;
				}
			}
		}
		
		if (playMap[i][j] == CREATURE) {
			neighbours -= 1;
		}
		
		return neighbours;
	}
}
