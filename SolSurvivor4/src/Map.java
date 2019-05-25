import java.io.FileReader;
import java.util.Scanner;
public class Map {
	static boolean loadMap = true;

	public enum Piece {BASE, CARGO, FUEL, REDSAND, PLAYER};
	private Piece[][] board; 
	
	public Map() throws Exception
	{
		loadMap("default.txt");
	}
	
	public void loadMap(String filename) throws Exception
	{
		char[][] map = new char [16][12];
		board = new Piece[16][12];
		Scanner in = new Scanner(new FileReader(filename));
		
		for(int r = 0; r < 16; r++) {
			map[r] = in.next().toCharArray();
			for(int c = 0; c <12; c++) {
				switch(map[r][c])
				{
				case 'B':
					board[r][c] = Piece.BASE;
					break;
				case 'C':
					board[r][c] = Piece.CARGO;
					break;
				case 'F':
					board[r][c] = Piece.FUEL;
					break;
				case 'R':
					board[r][c] = Piece.REDSAND;
					break;
				case 'P':
					board[r][c] = Piece.PLAYER;
					break;
				default:
					break;

				}
			}
		}
		
		for(int r = 0; r < 16; r++)
			for(int c = 0; c < 12; c++)
		
		SolSurvivorGUI.setSquare(r, c, board[r][c]);
		
	}
	
	public void setBoard(Piece[][] board) {
		this.board = board;
	}
	
	public Piece[][] getBoard() {
		return board;
	}

	public void clearBoard() {
		loadMap = true;
	}

	


	
}
