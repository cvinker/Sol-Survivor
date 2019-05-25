public class SolSurvivor {
	static int SolCounter;
	public static void main(String [] args) throws Exception
	{
		SolSurvivorGUI gui = new SolSurvivorGUI();
		SolSurvivorListener listener = new SolSurvivorListener(gui);
		
		for(int j = 0; j>=0;j++) {
			try {
				Thread.sleep(10000);
			}catch(Exception e) {}
			SolCounter++;
			System.out.println("Sols passed: " + SolCounter);
		}		
	}
}
