package org.app.model;

public class CalcLogic {
	
	private double currentNumber;
	private boolean isSetCurrentNumber;
	
	public boolean isSetCurrentNumber() {
		return isSetCurrentNumber;
	}

	public void setSetCurrentNumber(boolean isSetCurrentNumber) {
		this.isSetCurrentNumber = isSetCurrentNumber;
	}

	public double getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = convertToDouble(currentNumber);
	}
	
	public double convertToDouble(String s){
		return Double.parseDouble(s);
	}
	
	public double sum(String s){
		return (currentNumber += convertToDouble(s));
	}
	
	public double subtract(String s){
		return (currentNumber -= convertToDouble(s));
	}
	
	public double divide(String s){
		return (currentNumber /= convertToDouble(s));
	}
	
	public double multiply(String s){
		return (currentNumber *= convertToDouble(s));
	}
	
	public double pow(String s){
		return (currentNumber = Math.pow(convertToDouble(s),2));
	}
	
	public double sqrt(String s){
		return (currentNumber = Math.sqrt(convertToDouble(s)));
	}
}
