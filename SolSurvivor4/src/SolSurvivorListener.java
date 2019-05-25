import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SolSurvivorListener implements KeyListener {

	private SolSurvivorGUI gui;
	
	public SolSurvivorListener(SolSurvivorGUI g) {
		this.gui = g;
		gui.addListener(this);
	}
	
	public void keyPressed (KeyEvent event) {
		int keycode = event.getKeyCode();
		if(keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_LEFT) {
			
			for(int i = 0; i <2; i++) {
				try {
					gui.getPlayers()[i].move(event.getKeyCode());
				}catch(Exception e) {}
				
			}
		}
	
		
		else if(keycode == KeyEvent.VK_SPACE) {
			//ADD A METHOD FOR EATING/NUTRIENT
		}
	}
		public void keyReleased(KeyEvent event) {
			
		}
		public void keyTyped(KeyEvent event) {
			
		}
	
	


}
