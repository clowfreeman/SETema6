/**
 * 
 */
package mta.se.mvc.utils;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Action;

/**
 * @author ClPardos
 *
 */
public class WeatherAction implements Action {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	private boolean mEnabled = true;
	
	
	private HashMap<String, Object> mValues = new HashMap<String, Object>();

    private List<PropertyChangeListener> mChangeListeners;
    
	@Override
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		if (mChangeListeners == null) {
            mChangeListeners = new ArrayList<PropertyChangeListener>();
        }

        mChangeListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#getValue(java.lang.String)
	 */
	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return mValues.get(key);
	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return mEnabled;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#putValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		mValues.put(key, value);
	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		if (mChangeListeners != null && mChangeListeners.contains(listener)) {
            mChangeListeners.remove(listener);
        }
	}

	/* (non-Javadoc)
	 * @see javax.swing.Action#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		mEnabled = b;
	}

}
