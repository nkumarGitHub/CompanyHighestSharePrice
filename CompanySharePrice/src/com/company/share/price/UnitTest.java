package com.company.share.price;

/**
 * Unit Test to get N number of companies highest share price.
 * 
 * @author Neeraj
 * 
 */
public class UnitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UnitTest ut = new UnitTest();
		ut.getPassResults();
		//ut.getFailResults();
	}

	/*
	 * Valid sample data in CSV file.
	 */
	public void getPassResults() {
		CompanyHighestSharePrice csh = new CompanyHighestSharePrice();
		csh.getResults("E:\\SampleData.csv");
	}

	/*
	 * Invalid sample data in CSV file.
	 */
	private void getFailResults() {
		CompanyHighestSharePrice csh = new CompanyHighestSharePrice();
		csh.getResults("E:\\InvalidData.csv");

	}
}
