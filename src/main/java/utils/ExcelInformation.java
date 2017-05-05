package utils;

public final class ExcelInformation {

	private int parameterBegin;
	private int parameterEnd;
	private int answerBegin;
	private int answerEnd;
	private int outputBegin;
	private int outputEnd;
	private int testDataRowBegin = 1;
	
	public ExcelInformation(){}
	public ExcelInformation(int parameterBegin,int parameterEnd,int outputBegin,int outputEnd,int answerBegin,int answerEnd)
	{
		this.parameterBegin = parameterBegin;
		this.parameterEnd = parameterEnd;
		this.outputBegin = outputBegin;
		this.outputEnd = outputEnd;
		this.answerBegin = answerBegin;
		this.answerEnd = answerEnd;
	}
	
	public ExcelInformation(int parameterBegin,int parameterEnd,int outputBegin,int outputEnd,int answerBegin,int answerEnd,int testDataRowBegin)
	{
		this.parameterBegin = parameterBegin;
		this.parameterEnd = parameterEnd;
		this.outputBegin = outputBegin;
		this.outputEnd = outputEnd;
		this.answerBegin = answerBegin;
		this.answerEnd = answerEnd;
		this.testDataRowBegin = testDataRowBegin;
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
	public int getOutputBegin() {
		return outputBegin;
	}
	public void setOutputBegin(int outputBegin) {
		this.outputBegin = outputBegin;
	}
	public int getOutputEnd() {
		return outputEnd;
	}
	public void setOutputEnd(int outputEnd) {
		this.outputEnd = outputEnd;
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
}
