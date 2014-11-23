package mta.se.mvc;

import mta.se.mvc.controllers.WeatherControllers;
import mta.se.mvc.model.WeatherModel;
import mta.se.mvc.views.WeatherView;

/**
 * 
 */

/**
 * @author ClPardos
 *
 */
public class WeatherMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeatherModel model=new WeatherModel();
		WeatherView view=new WeatherView();
		
		WeatherControllers controllers=new WeatherControllers();
		 
		model.addModelListener(view);
		
		view.addModel(model);
		view.addController(controllers);
		
		controllers.addModel(model);
		controllers.addView(view);
		
		view.setVisible(true);
	}

}
