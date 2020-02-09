/**
 * 
 */
package by.irun.viz.utils;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import by.irun.viz.utils.VizUtils;

/**
 * test class for {@link by.irun.viz.utils.VizUtils}
 * @author A.Dubovik
 */
public class VizUtilsTest {

	@Test
	public void convertNumberOfSecondsToTimeRepresentationTest(){
		assertEquals("1:00:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3601));
		assertEquals("1:01:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3661));
		assertEquals("111:00:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(399601));
		assertEquals("59:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3541));
		assertEquals("10:00",VizUtils.convertNumberOfSecondsToTimeRepresentation(600));
		assertEquals("5:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(301));
		assertEquals("0:30",VizUtils.convertNumberOfSecondsToTimeRepresentation(30));
		assertEquals("0:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(1));
	}
	
	/**
	 * test for {@link by.irun.viz.utils.VizUtils#convertSqlDateToFrontEndRepresentation(java.sql.Date)}
	 */
	@Test
	public void convertSqlDateToFrontEndRepresentationTest(){
		assertEquals(VizUtils.UNKNOWN_DATE,VizUtils.convertSqlDateToFrontEndRepresentation(null));
		assertEquals("02.02.2000",VizUtils.convertSqlDateToFrontEndRepresentation(Date.valueOf("2000-02-02")));
	}
}
