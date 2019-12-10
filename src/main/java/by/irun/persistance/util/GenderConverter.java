package by.irun.persistance.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import by.irun.domain.Gender;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String>{

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(Gender
	 * attribute)
	 */
	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		if(attribute==null)throw new ConvertAttributeException("Gender cannot be null");
		switch (attribute) {
		case MALE:
			return DBConstants.MALE;
		case FEMALE:
			return DBConstants.FEMALE;
		default:
			throw new ConvertAttributeException("Invalid gender: " + attribute);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(String
	 * dbData)
	 */
	@Override
	public Gender convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case DBConstants.MALE:
			return Gender.MALE;
		case DBConstants.FEMALE:
			return Gender.FEMALE;
		default:
			throw new ConvertAttributeException("Invalid gender`s value: " + dbData);
		}
	}

}
