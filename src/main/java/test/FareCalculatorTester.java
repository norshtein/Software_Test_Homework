package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import testunits.FareCalculator;
import testunits.Triangle;
import utils.BaseComparator;
import utils.CsvManipulator;
import utils.ExcelInformation;
import utils.HttpWrapper;

public final class FareCalculatorTester extends TestFacilty{
	public FareCalculatorTester(ExcelInformation ex) {
		super(ex);
	}

	@Override
	public List<String> eval(List<String> parameters) {
		double fare = FareCalculator.getTelephoneFare(parameters.get(0), parameters.get(1));
		List<String> resultList = new ArrayList<String>();
		resultList.add(String.format("%.2f", fare));
		return resultList;
	}
}
