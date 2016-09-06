//Pennington, Thomas-100%
//Boyd, Evie-100%
//Chen, Jack-100%
// Lab 1: Retirement Investment Calculator 
import java.util.Scanner;

public class Retirement {
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		//Scanner Inputs for Annual Return command prompts in payback mode 
		
		// Monthly Social Security Income that you would receive 
		double mssi;
		do{
		System.out.print("Please enter a Monthly Social Security Income between $0 and $2642: ");
		 mssi = input.nextDouble();
			if(mssi < 0.00 || mssi > 2642.00)
				System.out.println("Error: not within specified range!");}
		while(mssi < 0.00 || mssi > 2642.00);
		
		// Required income that you would like to have every month 
		double reqincome;
		do{
		System.out.print("Please enter a Required Monthly Income (Any Amount): ");
		reqincome = input.nextDouble();
			if(reqincome < 0)
				System.out.println("Error");}
			while(reqincome < 0);
		
		// Annual Return for retirement and enter in decimal for e.g. .03
		double annret;
		do{
		System.out.print("Please enter a retired Annual Return Percentage in decimal form between 0 and .03: ");
			annret = input.nextDouble();
			if(annret < 0.00 || annret > 0.03)
				System.out.println("Error: not within specified range!");}
			while(annret < 0.00 || annret > 0.03);
		
		// Years that would like to retire for
		int yrsret;
		do{
		System.out.print("Please enter Years Retired (Any Natural Number): ");
			yrsret = input.nextInt();
			if(yrsret < 0)
				System.out.println("Error: not a natural number");}
			while(yrsret < 0);
		
		// Helper parts for the formula for amount to save
		
		double diff = reqincome - mssi; // what is required to come up with 
		double ann = (1+annret/12);
		double form = ((1-(1/(Math.pow(ann, yrsret*12))))/(annret/12));

		// Formula for the total amount to save while you are working
		
		double saved = (diff * form); // The total amount that is required to be saved before retirement 
		
		// Second Part of input interface for investment mode
		
		// Years that you still have to work left in investing mode
		double yrswork;
		do{
		System.out.print("Please enter remaining years to work (Any Natural Number): ");
		yrswork = input.nextDouble();
			if(yrswork < 0)
				System.out.println("Error: not a natural number");}
			while(yrswork < 0);
			
		// Annual work return percentage for investing mode and enter in a decimal e.g. .07
		double annwork;
		do{
		System.out.print("Please enter a working Annual Return Percentage in decimal form between 0 and .20: ");
			annwork = input.nextDouble();
			if(annwork < 0.00 || annwork > 0.20)
				System.out.println("Error: not within the specified range");}
			while(annwork < 0.00 || annwork > 0.20);
		
		// Helper for Monthly payments to save
		
		double inter = (1+(annwork/12));
		double form2 = (Math.pow(inter, yrswork*12) - 1)/(annwork/12);
		
		// Calculation for required savings per month
		
		double calc = saved/form2; // The total amount that must be saved monthly to reached amount saved goal
		
		System.out.println("The amount of money to save each month is $" + calc);
		
		input.close(); // This closes the scanner user interface
	}

}
