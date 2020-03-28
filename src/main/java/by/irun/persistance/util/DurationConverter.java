package by.irun.persistance.util;

import java.time.Duration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DurationConverter implements AttributeConverter<Duration,Integer>{

	@Override
	public Integer convertToDatabaseColumn(Duration time) {
		if(time==null)throw new ConvertAttributeException();
		return (int)time.toMillis()/1000;
	}

	@Override
	public Duration convertToEntityAttribute(Integer sec) {
		if(sec==null)throw new ConvertAttributeException();
		return Duration.ofSeconds(sec.longValue());
	}

}
