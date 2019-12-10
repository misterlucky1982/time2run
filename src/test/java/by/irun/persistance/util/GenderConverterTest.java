package by.irun.persistance.util;

import static org.junit.Assert.*;

import org.junit.Test;

import by.irun.domain.Gender;

public class GenderConverterTest {
	
	private GenderConverter converter = new GenderConverter();
	
	@Test
	public void convertToDataBaseColumnTest(){
		assertEquals(DBConstants.MALE,converter.convertToDatabaseColumn(Gender.MALE));
		assertEquals(DBConstants.FEMALE,converter.convertToDatabaseColumn(Gender.FEMALE));
	}
	
	@Test(expected=ConvertAttributeException.class)
	public void convertToDataBaseColumnWithExceptionForNullGenderValueTest(){
		converter.convertToDatabaseColumn(null);
	}
	
	@Test
	public void convertToEntityAttributeTest(){
		assertEquals(Gender.MALE,converter.convertToEntityAttribute(DBConstants.MALE));
		assertEquals(Gender.FEMALE,converter.convertToEntityAttribute(DBConstants.FEMALE));
	}
	
	@Test(expected = ConvertAttributeException.class)
	public void convertToEntityAttributeWithExceptionTest(){
		converter.convertToEntityAttribute("UNKNOWN GENDER");
	}
}
