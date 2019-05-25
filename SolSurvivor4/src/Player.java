import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Player {

	private int row;
	private int colum;
	private int score;
	private int dx;
	private int dy;
	private int keyMove;
	private boolean set;
	
	public Player(int r, int c)
	{
		row = r;
		colum = c;
		dx = 0;
		dy = 0;
	}
	
	public void move(int direction) throws Exception
	{
		
		dx = dy = 0;
		if(direction == KeyEvent.VK_UP)
			dy = -1;
		else if(direction == KeyEvent.VK_DOWN)
			dy = 1;
		else if(direction == KeyEvent.VK_RIGHT)
			dx = 1;
		else if(direction == KeyEvent.VK_LEFT)
			dx = -1;
		
		Map.Piece[][] temp = SolSurvivorGUI.getBoard().getBoard();
		
		if(row + dy >= 0 && row + dy <16 && colum + dx >= 0 && colum + dx < 12 && temp[row + dy][colum + dx] != Map.Piece.BASE) {
			
		}
		
		if(!set)
		{
			temp[row][colum] = Map.Piece.REDSAND;
			SolSurvivorGUI.setSquare( row, colum, Map.Piece.REDSAND );
		}
		SolSurvivorGUI.setSquare( row, colum, Map.Piece.PLAYER );
		temp[row][colum] = Map.Piece.PLAYER;
		set = true;
		
		//else {
		row += dy;
		colum += dx;
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
