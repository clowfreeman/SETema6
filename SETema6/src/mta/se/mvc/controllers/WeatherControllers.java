/**
 * 
 */
package mta.se.mvc.controllers;

import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import mta.se.mvc.exceptions.InputException;
import mta.se.mvc.interfaces.IController;
import mta.se.mvc.interfaces.IView;
import mta.se.mvc.model.WeatherModel;

/**
 * @author ClPardos
 *
 */
public class WeatherControllers implements IController {
	private WeatherModel mModel;
	
	private List<IView> mViews;
	
	
	public WeatherControllers() {
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(ACTION_GENERATE)) {
            // Make the operation
            try {
                JButton source = (JButton) event.getSource();
                if (source != null && source.getAction() != null && source.getAction().getValue(ACTION_GENERATE) != null) {
                    String userInput = source.getAction().getValue(ACTION_GENERATE).toString();
                    makeOperation(userInput);
                } else {
                    notifyViews(true, "Invalid operation data");
                }
            } catch (InputException e) {
                notifyViews(true, e.getMessage());
            } catch (ClassCastException ec) {
                notifyViews(true, ec.getMessage());
            }
        } else if (event.getActionCommand().equals(ACTION_RESET)) {
            // Reset the model to its default state
            if (mModel != null) {
                mModel.setValue1(WeatherModel.INITIAL_VALUE);
				mModel.setValue2(WeatherModel.INITIAL_VALUE);
            }
        }
    }

    public void addModel(WeatherModel model) {
        mModel = model;
    }
    
    public void addView(IView view) {
        if (mViews == null) {
            mViews = new ArrayList<IView>();
        }

        mViews.add(view);
    }
    
	private void notifyViews(boolean isError, String message) {
		// TODO Auto-generated method stub
		if (mViews != null && !mViews.isEmpty()) {
            for (IView view : mViews) {
                view.onMessage(isError, message);
            }
		}
	}

	private void makeOperation(String operand) throws InputException {
		// TODO Auto-generated method stub
		if (mModel != null) {
            Integer currentValue1 = new Integer(mModel.getValue1());
            Integer currentValue2 = new Integer(mModel.getValue2());

            try {
                // Update the model
                mModel.setValue1(currentValue1.toString());
                mModel.setValue2(currentValue2.toString());
            } catch (NumberFormatException e) {
                throw new InputException(operand, e.getMessage());
            }
		}
	}
}
