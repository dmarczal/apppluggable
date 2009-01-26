package org.app.model;

import java.util.Observable;

public class FontSize extends Observable{

	private static final int BEGIN_SIZE = 12;
	private int size;
	private static FontSize fsc;
	
	
	public static FontSize getInstance(){
		if (fsc == null){
			fsc = new FontSize();
			return fsc;
		}else
			return fsc;
	}
	
	public FontSize(){
		size = BEGIN_SIZE;
	}
	
	public void beginSize() {
		size = BEGIN_SIZE;
		setChanged();
		notifyObservers();
	}

	public void incrementSize() {
		++size;
		setChanged();
		notifyObservers();
	}

	public void decrementSize() {
		--size;
		setChanged();
		notifyObservers();
	}
	
	public int getSize(){
		return size;
	}
}
