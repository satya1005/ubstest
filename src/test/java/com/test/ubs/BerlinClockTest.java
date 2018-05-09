package com.test.ubs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.test.ubs.BerlinClock;
import com.test.ubs.IBerlinClock;

public class BerlinClockTest {
	IBerlinClock berlinClock;

	@Before
	public void setUp() throws Exception {
		berlinClock = new BerlinClock();
	}

	@Test
    public void testBerlinClock() {
        String actualBerlinOutput = berlinClock.convertTime("16:37:16");
        String expected ="Y , RRRO , ROOO , YYRYYRYOOOO , YYOO";
                           
        Assert.assertEquals(expected, actualBerlinOutput );
        
    }
	
	/**
	 * Test method to check top Yellow lamp should blink on/off every two
	 * seconds
	 */
	@Test
	public void testGetSecond() {
		Assert.assertEquals("Y", berlinClock.getSecond(0));
		Assert.assertEquals("O", berlinClock.getSecond(1));
		Assert.assertEquals("O", berlinClock.getSecond(29));
		Assert.assertEquals("Y", berlinClock.getSecond(4));
	}

	/**
	 * Test method to check first row of Top of the clock should have 4 lamps.
	 */
	@Test
	public void testGetTopRowHours() {

		Assert.assertEquals(4, berlinClock.getTopRowHours(10).length());
		Assert.assertEquals(4, berlinClock.getTopRowHours(15).length());
		Assert.assertEquals(4, berlinClock.getTopRowHours(20).length());
		Assert.assertNotSame(4, berlinClock.getTopRowHours(25).length());

	}

	/**
	 * Test method to check red lamp represents 5 hours and show how many red
	 * lamp is on and off
	 * 
	 */
	@Test
	public void testTopRowHours_LightRedLampForEvery5Hours() {
		Assert.assertEquals("OOOO", berlinClock.getTopRowHours(0));
		Assert.assertEquals("RROO", berlinClock.getTopRowHours(11));
		Assert.assertEquals("RRRO", berlinClock.getTopRowHours(18));
		Assert.assertEquals("RRRR", berlinClock.getTopRowHours(24));
	}

	/**
	 * Test method to check lower part of Top row of the clock should have 4
	 * lamps.
	 */
	@Test
	public void testTopLowerRowHours_4Lamps() {
		Assert.assertEquals(4, berlinClock.getLowerRowHours(6).length());
	}

	/**
	 * Test method to check red lamp represents 1 hours and show how many red
	 * lamp is on and off
	 */
	@Test
	public void testTopLowerRowHours_LightRedLampForEveryHour() {
		Assert.assertEquals("OOOO", berlinClock.getLowerRowHours(0));
		Assert.assertEquals("RROO", berlinClock.getLowerRowHours(12));
		Assert.assertEquals("RRRO", berlinClock.getLowerRowHours(13));
		Assert.assertEquals("RRRR", berlinClock.getLowerRowHours(24));
	}

	/**
	 * 
	 * Test method to check first row of bottom part should contain 11 lamps
	 * 
	 */
	@Test
	public void testTopMinutes_11Lamps() {
		Assert.assertEquals(11, berlinClock.getBottemRowMinutes(34).length());
	}

	/**
	 * Test method to check first row of bottom part minutes should have 3rd,
	 * 6th and 9th lamps in red to indicate first quarter, half and last quarter
	 */
	@Test
	public void testTopMinutes_3rd6thAnd9thLampsIn_RedToIndicateFirstQuarterHalfAndLastQuarter() {
		String minutes32 = berlinClock.getBottemRowMinutes(32);
		Assert.assertEquals("R", minutes32.substring(2, 3));
		Assert.assertEquals("R", minutes32.substring(5, 6));
		Assert.assertEquals("O", minutes32.substring(8, 9));
	}

	
	/**
	 * Test method to check first row of bottom part minutes should light a
	 * yellow lamp for every 5 minutes except first quarter, half or last
	 * quarter
	 */
	@Test
	public void testTopMinute_LightYellowLampForEvery5MinutesEceptFirst_half_last_quaters() {
		Assert.assertEquals("OOOOOOOOOOO", berlinClock.getBottemRowMinutes(0));
		Assert.assertEquals("YYROOOOOOOO", berlinClock.getBottemRowMinutes(19));
		Assert.assertEquals("YYRYYRYYRYY", berlinClock.getBottemRowMinutes(59));
	}

	/**
	 * 
	 */
	@Test
	public void testBottomMinutes_4Lamps() {
		Assert.assertEquals(4, berlinClock.getBottemLowerRowMinutes(0).length());
	}

	/**
	 * 
	 */
	@Test
	public void testBottomMinutes_LightYellowLamp_EveryMinute() {
		Assert.assertEquals("OOOO", berlinClock.getBottemLowerRowMinutes(0));
		Assert.assertEquals("YYOO", berlinClock.getBottemLowerRowMinutes(17));
		Assert.assertEquals("YYYY", berlinClock.getBottemLowerRowMinutes(59));
	}

	@After
	public void tearDown() throws Exception {
		berlinClock = null;
	}

}
