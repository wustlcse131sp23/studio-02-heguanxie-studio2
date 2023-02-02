package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int startAmount = 2;
		double winChance = 0.6;
		int winLimit = 10;
		int dollar = startAmount;
		int initial = 0;
		int runTimes = initial;
		double a = (1 - winChance) / winChance;
		int losses = 0;
		int totalSimulations = 20; 
		
		for (totalSimulations = 1; totalSimulations <= 20; totalSimulations++)
		{
			System.out.print("Simulation " + totalSimulations + ": ");
			while (dollar < winLimit && dollar > 0)
				{
				if (Math.random() <= winChance)
					{
						dollar++;
					}
				else
					{
						dollar--;
					}
				runTimes++;
				}
			System.out.print(runTimes);
			if (dollar == 10)
				{
					System.out.println(" WIN");
				}
			else 
				{
					System.out.println(" LOSE");
					losses++;
				}
			dollar = startAmount;
			runTimes = initial;
		}	
		System.out.println("Losses: " + losses +" Simulations: " + (totalSimulations - 1));
		System.out.print("Ruin Rate from Simulation: " + (double)(losses)/ (totalSimulations - 1)+ " ");
		if (winChance == 0.5)
			{
			double expectedValue = 1 - (double)(startAmount) / winLimit;
			System.out.println("Expected Ruin Rate: " + expectedValue);
			}
		else
			{
			double expectedValue =  (Math.pow(a, startAmount))- (Math.pow(a, winLimit))/(1 - (Math.pow(a, winLimit)));
			System.out.println("Expected Ruin Rate: " + expectedValue);
			}
	}

}
