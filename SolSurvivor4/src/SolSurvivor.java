public class SolSurvivor {
	public static void main(String [] args) throws Exception
	{
		SolSurvivorGUI gui = new SolSurvivorGUI();
		SolSurvivorListener listener = new SolSurvivorListener(gui);
	}
}
