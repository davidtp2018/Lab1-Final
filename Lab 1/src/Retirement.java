//Pennington, Thomas-100%
//Boyd, Evie-100%
//Chen, Jack-100%

import java.util.Scanner;

public class Retirement {
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		//Scanner Inputs for Annual Return
		double mssi;
		do{
		System.out.print("Please enter a Monthly Social Security Income between $0 and $2642: ");
		 mssi = input.nextDouble();
			if(mssi < 0.00 || mssi > 2642.00)
				System.out.println("error");}
		while(mssi < 0.00 || mssi > 2642.00);
		
		double reqincome;
		do{
		System.out.print("Please enter a Required Monthly Income (Any Amount): ");
		reqincome = input.nextDouble();
			if(reqincome < 0)
				System.out.println("error");}
			while(reqincome < 0);
		
		double annret;
		do{
		System.out.print("Please enter a retired Annual Return Percentage in decimal form between 0 and .03: ");
			annret = input.nextDouble();
			if(annret < 0.00 || annret > 0.03)
				System.out.println("error");}
			while(annret < 0.00 || annret > 0.03);
		
		int yrsret;
		do{
		System.out.print("Please enter Years Retired (Any Natural Number): ");
			yrsret = input.nextInt();
			if(yrsret < 0)
				System.out.println("error");}
			while(yrsret < 0);
		
		// Helper parts for the formula for amount to save
		
		double diff = reqincome - mssi;
		double annuity = (1+annret/12);
		double form = ((1-(1/(Math.pow(annuity, yrsret*12))))/(annret/12));

		// Formula for the total amount to save
		
		double saved = diff * form;
		
// Second Part of input interface
		double yrswork;
		do{
		System.out.print("Please enter remaining years to work (Any Natural Number): ");
		yrswork = input.nextDouble();
			if(yrswork < 0)
				System.out.println("error");}
			while(yrswork < 0);
			
		double annwork;
		do{
		System.out.print("Please enter a working annual return percentage in decimal form between 0 and .20: ");
			annwork = input.nextDouble();
			if(annwork < 0.00 || annwork > 0.20)
				System.out.println("error");}
			while(annwork < 0.00 || annwork > 0.20);
		
		// Helper for Monthly payments to save
		
		double inter = (1+(annwork/12));
		double form2 = (Math.pow(inter, yrswork*12) - 1)/(annwork/12);
		
		// Calculation for required savings per month
		
		double calc = saved/form2;
		
		System.out.println(calc);
		
	}

}
