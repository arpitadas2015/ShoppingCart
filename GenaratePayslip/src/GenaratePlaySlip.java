
/**
 * @author arpitadas
 *
 */
public class GenaratePlaySlip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenaratePlaySlip genaratePlaySlip = new GenaratePlaySlip();
		genaratePlaySlip.empMonthlyPaySlip("David","Rudd",60050,9,"01 March – 31 March");
		genaratePlaySlip.empMonthlyPaySlip("Ryan","Chen",120000,10,"01 March – 31 March");
	}
	
	public void empMonthlyPaySlip(String firstName,String lastName,long annualSalary,int superRate,String paymnetStartDate) {
		double annualTaxAmount = calculateTax(annualSalary);
		float annualSuperAmount = calculateSuper(annualSalary, superRate);
		long taxPerMonth = Math.round(annualTaxAmount/12);
		long superPerMonth = Math.round(annualSuperAmount/12);
		long salaryPerMonth = Math.round(annualSalary/12);
		long netIncome = salaryPerMonth - taxPerMonth;
		System.out.println(firstName + "" + lastName + "," + 
		paymnetStartDate + "," + salaryPerMonth + "," + taxPerMonth +"," + netIncome + "," + superPerMonth);
		
	}

	
	/**
	 * super = gross income x super rate
	 * @param taxableIncome
	 * @return superAmount
	 */
	public float calculateSuper(long taxableIncome, int empSuper) {
		
		float superPercentage = empSuper/100.0f;
		float superAmount = taxableIncome * superPercentage;
		return superAmount;
	}
	
	/**
	 * Taxable income Tax on this income 0 - $18,200 Nil
		$18,201 - $37,000 $37,001 - $80,000 $80,001 - $180,000 $180,001 and over
		19c for each $1 over $18,200
		$3,572 plus 32.5c for each $1 over $37,000
		$17,547 plus 37c for each $1 over $80,000 $54,547 plus 45c for each $1 over $180,000
	 * @param taxableIncome
	 * @return taxAmount
	 */
	public double calculateTax(long taxableIncome) {
		double totalTaxPerAnnum = 0;
		double taxFirstSlab = 0;
		double taxSecondSlab = 0;
		double taxThridSlab = 0;
		double taxLastSlab = 0;
		//first slab no tax
		taxableIncome = taxableIncome - 18200;
		//second slab calculation
		taxFirstSlab = calculateSecondSlab(taxableIncome);
		if((taxFirstSlab > 0) && (taxableIncome > 18800)) {
			taxableIncome = taxableIncome - 18800;
		}else {
			taxableIncome = taxableIncome - taxableIncome;
		}
		//Second slab calculation
		taxSecondSlab = calculateThridSlab(taxableIncome);
		if((taxSecondSlab > 0) && (taxableIncome > 43000)) {
			taxableIncome = taxableIncome - 43000;
		}else{
			taxableIncome = taxableIncome - taxableIncome;
		}
		//third slab calculation
		taxThridSlab = calculateForthSlab(taxableIncome);
		if((taxSecondSlab > 0) && (taxableIncome > 100000)){
			taxableIncome = taxableIncome -100000;
		}else {
			taxableIncome = taxableIncome - taxableIncome;
		}
		//last slab calculation
		taxLastSlab = calculateLastSlab(taxableIncome);
		
		totalTaxPerAnnum =  taxFirstSlab + taxSecondSlab + taxThridSlab + taxLastSlab;
		
		return totalTaxPerAnnum;
	}
	
	private double calculateSecondSlab(long taxableIncome) {
		double tax=0.0;
		if (taxableIncome > 18800) {
			tax =  (18800 * 0.19);
		}
		if (taxableIncome < 18800) {
			tax = taxableIncome * 0.19;
		}
		return tax;
	}

	private double calculateThridSlab(long taxableIncome) {
		double tax=0.0;
		if (taxableIncome > 43000) {
			tax = 43000 * 0.325;
		}
		if (taxableIncome < 43000) {
			tax = taxableIncome * 0.325;
		}
		return tax;
	}
	
	private double calculateForthSlab(long taxableIncome) {
		double tax = 0.0;
		if (taxableIncome > 100000) {
			tax = 100000 * 0.37;
		}
		if (taxableIncome < 100000) {
			tax = taxableIncome * 0.37;
		}
		return tax;
	}
	
	private double calculateLastSlab(long taxableIncome) {
		double tax = 0.0;
		if (taxableIncome > 0) {
			tax = taxableIncome * 0.45;
		}
		return tax;
	}
	
}
