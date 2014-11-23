/**
 * 
 */
package mta.se.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mta.se.mvc.interfaces.IModelListener;

/**
 * @author ClPardos
 *
 */
public class WeatherModel {
	public static final String INITIAL_VALUE = "0";
	private int temperatura=0, vant=0;
	
	private int mValTemp,mValVant;
	
	private List<IModelListener> mListeners;

	public WeatherModel(){
		mValTemp=0;
		mValVant=0;
	}
	
	public int temp(){
		int tempMin=0;
		int tempMax=30;
		Random rand =new Random();
		int randomNum=rand.nextInt((tempMax-tempMin)+1)+tempMin;
		return randomNum;
	}
	public int vt(){
		int vantMin=0;
		int vantMax=100;
		Random rand =new Random();
		int randomNum=rand.nextInt((vantMax-vantMin)+1)+vantMin;
		return randomNum;
	}
	public void setValue1(String initialValue) {
		// TODO Auto-generated method stub
		mValTemp= temp();
		notifyListeners();
	}
	public void setValue2(String initialValue) {
		// TODO Auto-generated method stub
		mValVant =vt();
		notifyListeners();
	}
	
	 public int getValue1() {
	        return mValTemp;
	    }
	 public int getValue2() {
	        return mValVant;
	    }
	 
	 public void addModelListener(IModelListener listener) {
	        if (mListeners == null) {
	            mListeners = new ArrayList<IModelListener>();
	        }

	        mListeners.add(listener);
	   	}
	 
	 private void notifyListeners() {
	        if (mListeners != null && !mListeners.isEmpty()) {
	            for (IModelListener listener : mListeners)
	                listener.onUpdate();
	        }
	    }
}
