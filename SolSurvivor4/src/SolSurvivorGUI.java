import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class SolSurvivorGUI {

	private JFrame frame;//screen
	private static JLabel[][] squares;
	private static Map board;
	private static Player[] players;
	


	public SolSurvivorGUI() throws Exception
	{
		frame = new JFrame("Sol Survivor by Cameron, Colin, and John");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(16,12,0,0));
		squares = new JLabel[16][12];
		for(int row=0;row<16;row++) {
			for(int colum=0; colum<12;colum++) {
				squares[row][colum] = new JLabel();
				panel.add(squares[row][colum]);
			}
		}
	
	
	frame.setContentPane(panel);
	frame.setSize(750,800);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	players = new Player[4];
	players[0] = new Player(0,0);
	players[1] = new Player(0,0);
	board = new Map();
	playerSetup();
	}
	
	public void addListener(SolSurvivorListener listener)
	{
		frame.addKeyListener(listener);
	}
	
	//\\//\\//\\//TODO
	public static void setSquare (int row, int colum, Map.Piece type)
	{
		String s = "";
		if(type == Map.Piece.BASE)
			s = "Images/Base.png";
		else if (type == Map.Piece.CARGO)
			s = "Images/Cargo.png";
		else if (type == Map.Piece.PLAYER)
			s = "Images/Curiosity.png";
		else if (type == Map.Piece.FUEL)
			s = "Images/Fuel.png";
		else if (type == Map.Piece.REDSAND)
			s = "Images/Redsand.png";
	
			
		squares[row][colum].setIcon(new ImageIcon(s));
	}
	
	public static void playerSetup() {
		
	}
	
	public static void resetBoard() throws Exception{
		board = new Map();
		playerSetup();
	}
	
	public void setBoard(Map board) {
		this.board = board;
	}
	
	
	public static Map getBoard() {
		return board;
	}
	
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public static Player[] getPlayers() {
		return players;
	}
}
	
	
	
	
	
	
	
	
	
	
	
