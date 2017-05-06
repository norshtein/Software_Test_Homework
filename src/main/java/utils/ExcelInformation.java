package utils;

public final class ExcelInformation {

	private int parameterBegin;
	private int parameterEnd;
	private int answerBegin;
	private int answerEnd;
	private int outputAnswerBegin;
	private int outputAnswerEnd;
	private int outputInformationBegin;
	private int outputInformationEnd;
	private int testDataRowBegin = 1;
	
	public ExcelInformation(){}

	public ExcelInformation(int parameterBegin,int parameterEnd,int answerBegin,int answerEnd,int outputAnswerBegin,int outputAnswerEnd,int outputInformationBegin,int outputInformationEnd)
	{
		this.parameterBegin = parameterBegin;
		this.parameterEnd = parameterEnd;
		this.answerBegin = answerBegin;
		this.answerEnd = answerEnd;
		this.outputAnswerBegin = outputAnswerBegin;
		this.outputAnswerEnd = outputAnswerEnd;
		this.outputInformationBegin = outputInformationBegin;
		this.outputInformationEnd = outputInformationEnd;

	}
	
	public ExcelInformation(int parameterBegin,int parameterEnd,int answerBegin,int answerEnd,int outputAnswerBegin,int outputAnswerEnd,int outputInformationBegin,int outputInformationEnd,int rowBegin)
	{
		this.parameterBegin = parameterBegin;
		this.parameterEnd = parameterEnd;
		this.answerBegin = answerBegin;
		this.answerEnd = answerEnd;
		this.outputAnswerBegin = outputAnswerBegin;
		this.outputAnswerEnd = outputAnswerEnd;
		this.outputInformationBegin = outputInformationBegin;
		this.outputInformationEnd = outputInformationEnd;
		this.testDataRowBegin = rowBegin;
	}
	public int getParameterBegin() {
		return parameterBegin;
	}
	public void setParameterBegin(int parameterBegin) {
		this.parameterBegin = parameterBegin;
	}
	public int getParameterEnd() {
		return parameterEnd;
	}
	public void setParameterEnd(int parameterEnd) {
		this.parameterEnd = parameterEnd;
	}
	public int getTestDataRowBegin() {
		return testDataRowBegin;
	}
	public void setTestDataRowBegin(int testDataRowBegin) {
		this.testDataRowBegin = testDataRowBegin;
	}
	public int getAnswerBegin() {
		return answerBegin;
	}
	public void setAnswerBegin(int answerBegin) {
		this.answerBegin = answerBegin;
	}
	public int getAnswerEnd() {
		return answerEnd;
	}
	public void setAnswerEnd(int answerEnd) {
		this.answerEnd = answerEnd;
	}

	public int getOutputAnswerBegin() {
		return outputAnswerBegin;
	}

	public void setOutputAnswerBegin(int outputAnswerBegin) {
		this.outputAnswerBegin = outputAnswerBegin;
	}

	public int getOutputAnswerEnd() {
		return outputAnswerEnd;
	}

	public void setOutputAnswerEnd(int outputAnswerEnd) {
		this.outputAnswerEnd = outputAnswerEnd;
	}

	public int getOutputInformationBegin() {
		return outputInformationBegin;
	}

	public void setOutputInformationBegin(int outputInformationBegin) {
		this.outputInformationBegin = outputInformationBegin;
	}

	public int getOutputInformationEnd() {
		return outputInformationEnd;
	}

	public void setOutputInformationEnd(int outputInformationEnd) {
		this.outputInformationEnd = outputInformationEnd;
	}
}
