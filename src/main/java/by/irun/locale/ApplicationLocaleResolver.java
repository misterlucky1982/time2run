package by.irun.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

public class ApplicationLocaleResolver extends SessionLocaleResolver{
	
	{
		this.setDefaultLocale(AppLocales.DEFAULT);
	}

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale = (Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		return AppLocales.resolveLocale(locale);
	}
}
