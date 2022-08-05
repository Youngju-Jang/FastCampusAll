
public class AccountingIFApp {

	public static void main(String[] args) {
		
		double valueOfSupply = Double.parseDouble(args[0]);
		double expenseRate = 0.3;
		double vatRate = 0.1;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply - expense;
		
		double divided1;
		double divided2;
		double divided3;
		
		if(income > 10000.0) {
			divided1 = income * 0.5;
			divided2 = income * 0.3;
			divided3 = income * 0.2;
		} else {
			divided1 = income * 1;
			divided2 = income * 0;
			divided3 = income * 0;			
		}

		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT : " + vat );
		System.out.println("Total : " + total );
		System.out.println("Expense : " + expense );
		System.out.println("Income : " + income );
		
		System.out.println("Dividend1: " + divided1 );
		System.out.println("Dividend2: " + divided2 );
		System.out.println("Dividend3: " + divided3 );
		
		
		
	}

}
