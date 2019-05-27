import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * GUI class
 * Holds information about the game board and the interface
 */
public class SolSurvivorMainGUI
{
	private JFrame frame; /** What is on the screen */
	private static JLabel[][] squares; /** The labels to show on the screen */
	private static MapMaker board; /** Keeping track of the MapMaker */
	private static Curiosity[] Curiositys; /** The human and computer Curiositys */
	private static int AIDifficulty; /** The difficulty level of the AI */
	
	/**
	 * Constructor for SolSurvivorMainGUI
	 * Initializes Curiositys based on what the user asked for. (Number of human Curiositys, computer Curiositys,
	 * difficulty of the computers)
	 * Sets up the interface for SolSurvivorMain
	 */
	public SolSurvivorMainGUI() throws Exception
	{
		/** Create the frame to play in */
		frame = new JFrame( "SolSurvivorMain" );
		JPanel panel = (JPanel) frame.getContentPane();
		
		/** Set the layout of the frame. 13 rows by 15 columns */
		panel.setLayout( new GridLayout( 13, 15 ) );
		
		/** Create the board arrays */
		squares = new JLabel[13][15];
		
		/** Create all of the squares */
		for( int row = 0; row < 13; row++ )
		{
			for( int column = 0; column < 15; column++ )
			{
				squares[row][column] = new JLabel();
				
				/** Add the square to the interface */
				panel.add( squares[row][column] );
			}
		}
		
		frame.setContentPane( panel );
		
		/** Set the size of the board to fit a 13x15 board, where squares are 50x50 */
		frame.setSize( 750, 650 );
		
		/** Show the board */
		frame.setVisible( true );
		
		/** Exit the program when the [X] is pressed */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Let the user choose the difficulty of the AI
		String[] choices = { "1", "2", "3", "4" };
		AIDifficulty = JOptionPane.showOptionDialog(
		                               null                     
		                             , "What level do you want the AI to be?"     
		                             , "Choose the difficulty"             
		                             , JOptionPane.YES_NO_OPTION
		                             , JOptionPane.PLAIN_MESSAGE 
		                             , null                     
		                             , choices                    
		                             , null
		                           );
		//Make it not a zero based number
		AIDifficulty++;
		
		/**
		 * 1. Create the MapMaker
		 * 2. Create all of the Curiositys necessary
		 * 3. Start the game
		 */
		//Only create the Curiositys once!!
		Curiositys = new Curiosity[4];
		Curiositys[0] = new Curiosity( 0, 0 );
		Curiositys[1] = new Curiosity( 0, 0 );
		
		board = new MapMaker();
		CuriositySetup();
	}
	
	/**
	 * Adds the listener to look at events from
	 * @param listener The KeyboardListener to check for events from
	 */
	public void addListener( SolSurvivorMain listener )
	{
		frame.addKeyListener( listener );
	}
	
	public static void setSquare( int row, int column, MapMaker.Piece type )
	{
		String s = "Images/Curiosity-down.jpg";
		
		//Show the image based on what type it is
		if( type == MapMaker.Piece.BLOCK )
			s = "Images/block.jpg";
		else if( type == MapMaker.Piece.BOMB )
			s = "Images/bomb.jpg";
		else if( type == MapMaker.Piece.BLOCK )
			s = "Images/block.jpg";
		else if ( type == MapMaker.Piece.COMPUTER )
		{
			for( int i = 0; i < 2; i++ )
			{
				//If the computer was found then
				if( row == Curiositys[i].getRow() && column == Curiositys[i].getColumn() && Curiositys[i].isComputer() )
				{
					//Show the image depending on what direction they are facing
					if( Curiositys[i].getDx() == 1 )
						s = "Images/computer-right.jpg";
					else if( Curiositys[i].getDx() == -1 )
						s = "Images/computer-left.jpg";
					else if( Curiositys[i].getDy() == 1 )
						s = "Images/computer-down.jpg";
					else
						s = "Images/computer-up.jpg";
				}
			}
		}
		else if( type == MapMaker.Piece.CRATE )
			s = "Images/crate.jpg";
		else if( type == MapMaker.Piece.EXPLOSION )
			s = "Images/explosion.jpg";
		else if( type == MapMaker.Piece.NOTHING )
			s = "Images/nothing.jpg";
		else if( type == MapMaker.Piece.Curiosity )
		{
			//2 Curiositys
			for( int i = 0; i < 2; i++ )
			{
				//If a Curiosity was found then
				if( row == Curiositys[i].getRow() && column == Curiositys[i].getColumn() && !Curiositys[i].isComputer() )
				{
					//Show the image depending on what direction they are facing
					if( Curiositys[i].getDx() == 1 )
						s = "Images/Curiosity-right.jpg";
					else if( Curiositys[i].getDx() == -1 )
						s = "Images/Curiosity-left.jpg";
					else if( Curiositys[i].getDy() == 1 )
						s = "Images/Curiosity-down.jpg";
					else
						s = "Images/Curiosity-up.jpg";
				}
			}
		}
		
		//Show the image
		squares[row][column].setIcon( new ImageIcon( s ) );
	}
	
	public static void CuriositySetup()
	{
		int CuriosityCount = 0; //Keep track of how many Curiositys/computers have been found
		
		//Look on the board for any Curiositys or computers
		for( int r = 0; r < 13; r++ )
		{
			for( int c = 0; c < 15; c++ )
			{
				//Set up all of the necessary variables for a Curiosity
				if( board.getBoard()[r][c] == MapMaker.Piece.Curiosity )
				{
					Curiositys[CuriosityCount].setRow( r );
					Curiositys[CuriosityCount].setColumn( c );
					Curiositys[CuriosityCount].setComputer( false );
					
					Curiositys[CuriosityCount].time.bombs.makeNew();
					
					CuriosityCount++;
				}
				else if( board.getBoard()[r][c] == MapMaker.Piece.COMPUTER )
				{
					Curiositys[CuriosityCount].setRow( r );
					Curiositys[CuriosityCount].setColumn( c );
					Curiositys[CuriosityCount].setComputer( true );
					
					Curiositys[CuriosityCount].time.bombs.makeNew();
					
					//Set the AI difficulty
					Curiositys[CuriosityCount].setAI( AIDifficulty );
					AITimer ai = Curiositys[CuriosityCount].getAITime();
					ai.setCuriosity( Curiositys[CuriosityCount] );
					Curiositys[CuriosityCount].setAITime( ai );
					
					CuriosityCount++;
				}
			}
		}
	}
	
	/**
	 * Get ready to play another game
	 * @throws Exception From MapMaker
	 */
	public static void resetBoard() throws Exception
	{
		board = new MapMaker();
		CuriositySetup();
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(MapMaker board) {
		this.board = board;
	}

	/**
	 * @return the board
	 */
	public static MapMaker getBoard() {
		return board;
	}

	/**
	 * @param Curiositys the Curiositys to set
	 */
	public void setCuriositys(Curiosity[] Curiositys) {
		this.Curiositys = Curiositys;
	}

	/**
	 * @return the Curiositys
	 */
	public static Curiosity[] getCuriositys() {
		return Curiositys;
	}
}