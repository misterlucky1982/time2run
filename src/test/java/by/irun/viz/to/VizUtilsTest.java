/**
 * 
 */
package by.irun.viz.to;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * test class for {@link by.irun.viz.to.VizUtils}
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
}
