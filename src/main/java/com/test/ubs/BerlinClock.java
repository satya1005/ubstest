package com.test.ubs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is meant for berlin clock logic
 * 
 * @author Satyabira
 *
 */
public class BerlinClock implements IBerlinClock {

	public static final int NUMBER_FOUR=4;
	public static final int NUMBER_FIVE=5;
	public static final int NUMBER_ELEVEN=11;
	public static final int NUMBER_TWO=2;
	public static final String ON_YELLOW="Y";
	public static final String LAMP_OFF="O";
	public static final String ON_RED="R";
	
	
	@Override
	public String convertTime(String time) {
		
		List<Integer> splitTime = new ArrayList<Integer>();
		for (String part : time.split(":")) {
			splitTime.add(Integer.parseInt(part));
		}
		return  getSecond(splitTime.get(2))+" , " +getTopRowHours(splitTime.get(0))+" , "+ getLowerRowHours(splitTime.get(0))+" , "+
				getBottemRowMinutes(splitTime.get(1))+" , "+ getBottemLowerRowMinutes(splitTime.get(1)) ;
	}

	
	/* (non-Javadoc)
	 * @see com.test.ubs.IBerlinClock#getSecond(int)
	 */
	@Override
	public String getSecond( int number) {
		if (number % NUMBER_TWO == 0)
			return ON_YELLOW;
		else
			return LAMP_OFF;
	}

	/* (non-Javadoc)
	 * @see com.test.ubs.IBerlinClock#getTopRowHours(int)
	 */
	@Override
	public String getTopRowHours(int number) {
		int totalOnLamp=getNumberOfLampaisOn(number);
		return getTotalOnOff(NUMBER_FOUR, totalOnLamp, ON_RED);
	}
	
	
	/**
	 * Method to get number of lamp is on
	 * @param number
	 *             input hour/minute 
	 * @return
	 *        number of on lamp
	 */
	private int getNumberOfLampaisOn(int number) {
		return  number / NUMBER_FIVE;
	}
	
	/**
	 * Method to return total on and off lamps
	 * @param lamps
	 *          total no.of lamps
	 * @param noofOnLamp
	 *          no.of on lamps
	 * @param onSignSymbol
	 *          string on sign
	 * @return
	 *      total on and off lamps 
	 */
	private String getTotalOnOff(int lamps, int noofOnLamp, String onSignSymbol) {
		String out = "";
		// String multiplication would be useful
		for (int i = 0; i < noofOnLamp; i++) {
			out += onSignSymbol;
		}
		for (int i = 0; i < (lamps - noofOnLamp); i++) {
			out += LAMP_OFF;
		}
		return out;
	}
	
	/* (non-Javadoc)
	 * @see com.test.ubs.IBerlinClock#getLowerRowHours(int)
	 */
	@Override
	public String getLowerRowHours(int number) {
		int totalOn=getNumberOflamphavingOnSignsInLowerRow( number);
		return getTotalOnOff(NUMBER_FOUR, totalOn, ON_RED);
	}
	/**
	 * Method to return number of Lamp is on
	 * @param number
	 *          
	 * @return
	 */
	private int getNumberOflamphavingOnSignsInLowerRow(int number) {
		return number%NUMBER_FIVE;
	}

	/* (non-Javadoc)
	 * @see com.test.ubs.IBerlinClock#getBottemRowMinutes(int)
	 */
	@Override
	public String getBottemRowMinutes(int number) {
		
		 return getTotalOnOff(NUMBER_ELEVEN, getNumberOfLampaisOn(number), ON_YELLOW).replaceAll("YYY", "YYR");
	}

	/* (non-Javadoc)
	 * @see com.test.ubs.IBerlinClock#getBottemLowerRowMinutes(int)
	 */
	@Override
	public String getBottemLowerRowMinutes(int number) {
		int totalOn =getNumberOflamphavingOnSignsInLowerRow(number);
		return getTotalOnOff(NUMBER_FOUR, totalOn % NUMBER_FIVE, ON_YELLOW);
	}

	
}
