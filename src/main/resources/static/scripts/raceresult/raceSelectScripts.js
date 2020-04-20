/**
 * 
 */
'use strict'

var isSelectOptionsPanelHidden = true;

$(document).ready(function() {
   console.log("hello!");
	$('#race_list').jScrollPane();
	$('#race_search_panel').css("opacity", 0);
	$('#race_search_panel').css("height", 0);
	$('#race_list_wrapper').css("opacity", 0);
	$('#race_list_wrapper').css("height", 0);
	$('#seek_other_races_button').click(showRaceSelectPanel);
	$('#show_last_events').click(showRaceList);
	$('#seek_other_races_button').click(showRaceSelectPanel);
	$('#race_search_button').click(showRaceList);
	$('#hide_race_list_panel').click(hideRaceList);
	$('#hide_search_race_panel_button').click(hideRaceSelectPanel);
});


function showRaceList(){
	$('#show_last_events').animate({
		opacity:0
	})
	$('#show_last_events').animate({
		height : 0
	})
	$('#race_list_wrapper').animate({
		height : 200
	})
	$('#race_list_wrapper').animate({
		opacity:1
	})
}

function hideRaceList(){
	console.log(isSelectOptionsPanelHidden);
	if(!isSelectOptionsPanelHidden){
		hideRaceSelectPanel();
	};
	$('#race_list_wrapper').animate({
		height : 0,
		opacity:0
	})
	$('#show_last_events').animate({
		height : 30,
		opacity:1
	})
}

function showRaceSelectPanel(){
	$('#race_search_panel').animate({
		height : 325
	})
	$('#race_search_panel').animate({
		opacity:1
	})
	$('#seek_other_races_button').animate({
		opacity:0
	})
	$('#seek_other_races_button').animate({
		height : 0
	})
	isSelectOptionsPanelHidden = false;
}

function hideRaceSelectPanel(){
	$('#race_search_panel').animate({
		opacity:0
	})
	$('#race_search_panel').animate({
		height : 0
	})
	$('#seek_other_races_button').animate({
		height : 30
	})
	$('#seek_other_races_button').animate({
		opacity:1
	})
	isSelectOptionsPanelHidden = true;
}
