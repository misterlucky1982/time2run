/**
 * 
 */
'use strict'

function foo(lang) {
	var ln = window.location.pathname.substring(1,3);
	if(lang==ln){
		return;
	}
	var location = "/"+lang+window.location.pathname.substring(3)+window.location.search;
	window.location.replace(location);
}