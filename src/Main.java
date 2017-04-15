
public class Main {

	public static void main(String[] args) {
		Life life = new Life(5, 5);
		
		life.playMap[1][2] = Life.CREATURE;
		life.printMap();
	}

}
