package HelloWorld.com.qa.quickstart;

public class tax {
	
	public double getTax(int salary) {
		double tax;
		if (salary >= 0 && salary < 15000) {
			tax = 0;
		}
		else if (salary >= 15000 && salary < 20000) {
			  tax = 0.10;
		}
		else if (salary >= 20000 && salary < 30000) {
			tax = 0.15;
		}
		else if (salary >= 30000 && salary < 45000) {
			tax = 0.20;
		}
		else {
			tax = 0.25;
		}
	
	return tax;
	}
	
	public double calcTax(double tax, int salary) {
		System.out.println("Hello");
		double calcval = 0;
		calcval = tax * salary;
		return calcval;
	}
}
