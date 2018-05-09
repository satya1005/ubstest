package com.test.ubs;


/**
 * @author Satyabira
 *
 */
public interface IBerlinClock {
	
	
	
	public String convertTime(String aTime);
	
	/**
	 * Method to check top of the clock the yellow lamp blinks in every two seconds.
	 * @param number
	 * @return
	 *     returns Y for every two seconds else return O(off)
	 */
	public String getSecond(int number);
	
	/**
	 * Method to check red lamp represents 5 hours and show how many red
	 * lamp is on and off in top first row
	 * @param number
	 * @return
	 */
	public  String getTopRowHours(int number);
	/**
	 * @param number
	 * @return
	 */
	public  String getLowerRowHours(int number);
	/**
	 * @param number
	 * @return
	 */
	public  String getBottemRowMinutes(int number);
	/**
	 * @param number
	 * @return
	 */
	public  String getBottemLowerRowMinutes(int number);
	
	
}
