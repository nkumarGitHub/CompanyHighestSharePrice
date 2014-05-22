package com.company.share.price;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to get company's highest share price.
 * 
 * @author Neeraj
 * 
 */
public class CompanyHighestSharePrice {
	public void getResults(String fileName) {
		FileReader fr;
		BufferedReader br = null;
		String line = null;
		boolean isSuccess = true;

		ArrayList dataFromFile = new ArrayList();

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				dataFromFile.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String colHeader = (String) dataFromFile.get(0);
		String[] colArr = colHeader.split(",");
		int colSize = colArr.length;
		int[] yearCompanyData = new int[colSize - 2];
		String[] monthCompanyData = new String[colSize - 2];
		int[] maxCompanyData = new int[colSize - 2];

		dataFromFile.remove(0);

		for (int i = 0; i < dataFromFile.size(); i++) {
			String[] splitdata = ((String) dataFromFile.get(i)).split(",");

			if (splitdata.length == colSize) {

				for (int j = 0; j < maxCompanyData.length; j++) {
					if (!splitdata[j + 2].equalsIgnoreCase("")
							&& maxCompanyData[j] < Integer
									.parseInt(splitdata[j + 2])) {
						maxCompanyData[j] = Integer.parseInt(splitdata[j + 2]);
						monthCompanyData[j] = splitdata[1];
						yearCompanyData[j] = Integer.parseInt(splitdata[0]);
					}
				}
			} else {
				System.out.println("Invalid Data in the CSV file...!!!!");
				isSuccess = false;
				break;
			}
		}

		if (isSuccess) {
			for (int j = 0; j < maxCompanyData.length; j++) {
				System.out.println("Highest share price for " + colArr[j + 2]
						+ " is " + maxCompanyData[j] + " on "
						+ monthCompanyData[j] + " " + yearCompanyData[j]);
			}
		}
	}
}
