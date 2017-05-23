package test;

import java.util.ArrayList;
import java.util.List;

import testunits.ComputerSale;
import utils.BaseComparator;
import utils.ExcelInformation;
import utils.HttpWrapper;

public class ComputerSaleTester extends TestFacilty{
	
	public ComputerSaleTester(ExcelInformation ex) {
		super(ex);
	}

	@Override
	public List<String> eval(List<String> parameters) {
		double profit = ComputerSale.getProfit(parameters.get(0), parameters.get(1),parameters.get(2));
		List<String> resultList = new ArrayList<String>();
		resultList.add(String.format("%.2f", profit));
		return resultList;
	}

}
