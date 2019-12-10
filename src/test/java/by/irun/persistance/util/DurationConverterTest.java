package by.irun.persistance.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;

public class DurationConverterTest {

	private DurationConverter converter = new DurationConverter();
	private Duration duration1 = Duration.ofMinutes(1);
	private Duration duration2 = Duration.ofMillis(1000);
	
	@Test
	public void convertToDataBaseColumnTest(){
		assertTrue(converter.convertToDatabaseColumn(duration1)==60);
		assertTrue(converter.convertToDatabaseColumn(duration2)==1);
	}
	
	@Test
	public void convertTuEnttityAttributeTest(){
		assertEquals(duration1,converter.convertToEntityAttribute(60));
		assertEquals(duration2,converter.convertToEntityAttribute(1));
	}
}
