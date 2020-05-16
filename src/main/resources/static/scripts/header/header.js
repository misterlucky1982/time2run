/**
 * 
 */
'use strict'

function switchLocale(lang) {
	if(window.location.search.endsWith(lang)){
		return;
	}
	let i=window.location.search.indexOf("locale=");
	let search = i>0?window.location.search.substring(0,i+7):(window.location.search.length>0?(window.location.search+"&locale="):(window.location.search+"?locale="));
	search+=lang;
	var location = window.location.pathname+search;
	window.location.replace(location);
}