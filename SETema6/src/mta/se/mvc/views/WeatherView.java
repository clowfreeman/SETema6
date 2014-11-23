package mta.se.mvc.views;

import java.awt.GraphicsConfiguration;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mta.se.mvc.interfaces.IController;
import mta.se.mvc.interfaces.IModelListener;
import mta.se.mvc.interfaces.IView;
import mta.se.mvc.model.WeatherModel;
import mta.se.mvc.utils.WeatherAction;

import java.awt.*;
import java.awt.event.ActionListener;

//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

public class WeatherView extends JFrame implements IModelListener,IView {

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	 private static final long serialVersionUID = -5758555454500685115L;

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 */
	private JTextField mTempTf = new JTextField(6);
    private JTextField mVantTf = new JTextField(20);
    private JButton mWeatherBtn = new JButton("Weather Button");
    private JButton mClearBtn = new JButton("Clear");

    private IController mWeatherController;

    private WeatherModel mModel;

    /**
     * Constructor
     * @return 
     */
    
    
    public WeatherView() {
        // Initialize components
    	mTempTf.getDocument().addDocumentListener(new DocumentListener() {
            // TODO - this is a hack, find a better solution to add data to an event
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                String newValue = mTempTf.getText();
                if (mWeatherBtn.getAction() == null) {
                    mWeatherBtn.setAction(new WeatherAction());
                }
                mWeatherBtn.getAction().putValue(IController.ACTION_RESET, newValue);
                mWeatherBtn.setActionCommand(IController.ACTION_GENERATE);
                mWeatherBtn.setText("GENERARE");
            }
        });
        mVantTf.getDocument().addDocumentListener(new DocumentListener() {
            // TODO - this is a hack, find a better solution to add data to an event
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                String newValue1 = mVantTf.getText();
                if (mWeatherBtn.getAction() == null) {
                    mWeatherBtn.setAction(new WeatherAction());
                }
                mWeatherBtn.getAction().putValue(IController.ACTION_RESET, newValue1);
                mWeatherBtn.setActionCommand(IController.ACTION_GENERATE);
                mWeatherBtn.setText("GENERARE");
            }
        });

        
        
        // Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Temperatura"));
        content.add(mTempTf);
        content.add(new JLabel("Vant"));
        content.add(mVantTf);
        content.add(new JLabel("         "));
        content.add(mWeatherBtn);
        content.add(mClearBtn);

        // Finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("WeatherGenerator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addModel(WeatherModel model) {
        mModel = model;
        mTempTf.setText(String.valueOf(model.getValue1()));
        mVantTf.setText(String.valueOf(model.getValue2()));
    }
    /**
     * Sets the view's event listener - the controller - so that the changes made by the user in the view, can be reflected in the model
     *
     * @param controller The controller (event listener)
     */
    public void addController(IController controller) {
        mWeatherBtn.setActionCommand(IController.ACTION_GENERATE);
        mWeatherBtn.addActionListener(controller);

        mClearBtn.setActionCommand(IController.ACTION_RESET);
        mClearBtn.addActionListener(controller);
    }

    public void onMessage(boolean isError, String message) {
        if (isError) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Weather Generator MVC", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void onUpdate() {
        //mTotalTf.setText(mModel.getValue());
    }
}
