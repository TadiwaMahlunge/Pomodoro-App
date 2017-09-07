package application.com;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class SessionModel {
	private int restMins;
	private int workMins;
	private int numSessions;
	private int sessionsLeft;
	private double height;
	private double width;
	
	/**
	 * This will initialise the application model's values.
	 */
	public SessionModel(){
		restMins = 100;
		workMins = 100;
		numSessions = 100;
		sessionsLeft = 100;
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		height = visualBounds.getHeight();
		width = visualBounds.getWidth();
	}
	/**
	 * This returns the height of the screen.
	 * @return The height of the screen 
	 */
	public double getHeight(){
		return height;
	}
	/**
	 * This returns the width of the screen.
	 * @return The width of the screen 
	 */
	public double getWidth(){
		return width;
	}
	/**
	 * This returns the rest minutes per Session.
	 * @return The rest minutes per Session.
	 */
	public int getRestMins(){
		return restMins;
	}
	/**
	 * This sets the number of minutes the user elected to rest.
	 * @param mins The number of minutes the user elected to rest.
	 */
	public void setRestMins(int mins){
		restMins = mins;
	}
	/**
	 * This returns the work minutes per Session.
	 * @return The work minutes per Session.
	 */
	public int getWorkMins(){
		return workMins;
	}
	/**
	 * This sets the number of minutes the user elected to work.
	 * @param mins The number of minutes the user elected to work.
	 */
	public void setWorkMins(int mins){
		workMins = mins;
	}
	/**
	 * This returns the number of Sessions the user wants to perform.
	 * @return The number of Sessions the user wants to perform.
	 */
	public int getNumSessions(){
		return numSessions;
	}
	/**
	 * This sets the number of Sessions the user elected to perform.
	 * @param sessions The number of Sessions the user elected to perform.
	 */
	public void setNumSessions(int sessions){
		numSessions = sessions;
	}
	/**
	 * This returns the number of Sessions left for the user to perform.
	 * @return The number of Sessions left for the user to perform.
	 */
	public int getSessionsLeft(){
		return sessionsLeft;
	}
	/**
	 * This sets the number of Sessions left for the user to perform.
	 * @param sessions The number of Sessions left for the user to perform.
	 */
	public void setSessionsLeft(int sessions){
		sessionsLeft = sessions;
	}	
}
