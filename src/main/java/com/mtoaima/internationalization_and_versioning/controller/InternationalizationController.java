package com.mtoaima.internationalization_and_versioning.controller;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InternationalizationController {
	
	private MessageSource messageSource;
	
	
	public InternationalizationController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	/*
	 * Internationalization support more languages
	 * this method support English French, Deutsch and Dutch;
	 * just send in header Accept_Language fr, nl, de ;
	 */

	@GetMapping(path = "/message/internationalization")
	public String messageInternationalization() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morining.message", null, "Defult Message", locale);
	}
	
	
}
