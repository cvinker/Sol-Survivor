import javax.swing.*;
import java.io.*;
import java.awt.*;

public class SolSurvivorMain {
	public static void main(String args[]) {

		SolSurvivor gui = new SolSurvivorGUI();
		SolSurvivorListener listener = new SolSurvivorListener( gui );		

	}
}
