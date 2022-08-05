package ProjectOOP;

class Accounting{
	public double valueOfSupply;
	public static double varRate = 0.1;	
	
	public Accounting(double valueOfSupply) {
		this.valueOfSupply = valueOfSupply;
	}
	public double getVat() {
		return valueOfSupply * varRate;
	}	
	public double getTotal() {
		return valueOfSupply + getVat();								
	}	
}