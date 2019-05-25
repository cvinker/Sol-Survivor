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
		////if(keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_LEFT) {
			
				//try {
				////gui.getPlayers()[0].move(event.getKeyCode());
			//	}catch(Exception e) {}
				
			
		
		if(keycode == KeyEvent.VK_UP) {
			try {
				SolSurvivorGUI.getPlayers()[0].move(KeyEvent.VK_UP);
			}catch(Exception e) {}
		}
		else if(keycode == KeyEvent.VK_DOWN) {
			try {
				SolSurvivorGUI.getPlayers()[0].move(KeyEvent.VK_DOWN);
			}catch(Exception e) {}
		}
		else if(keycode == KeyEvent.VK_LEFT) {
			try {
				SolSurvivorGUI.getPlayers()[0].move(KeyEvent.VK_LEFT);
			}catch(Exception e) {}
		}
		else if(keycode == KeyEvent.VK_RIGHT) {
			try {
				SolSurvivorGUI.getPlayers()[0].move(KeyEvent.VK_RIGHT);
			}catch(Exception e) {}
		}
	
		
		else if(keycode == KeyEvent.VK_SPACE) {
			System.out.println("Resource consumed!");
		}
		
		
		
	}
		public void keyReleased(KeyEvent event) {
			 event.setKeyCode(0); 
		}
		public void keyTyped(KeyEvent event) {
			
		}
	
	


}
