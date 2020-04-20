/**
 * 
 */
'use strict';

function refreshRaceList() {
	var url = null;
	var warningParam = paramWarnings();
	if (warningParam == null) {
		url = 'events/races' + buildRaceRequest();
	} else {
		url = 'events/warning?message=' + warningParam;
	}
	$("#events_race_list").load(url, function(){
		raceListInit();
	});
}

function paramWarnings(){
	var from = !validateFromDate();
	var to = !validateToDate();
	if(to&&from){
		return "both";
	}
	if(to){
		return "for";
	}
	if(from){
		return "from";
	}
	return null;
}

function buildRaceRequest() {
	var dateFrom = getFromDate();
	var dateTo = getToDate();
	if (selectedPark == null && dateFrom == null && dateTo == null) {
		return "";
	} else {
		var request = "?";
		if (dateFrom != null) {
			request += ("from=" + dateFrom);
		}
		if (dateTo != null) {
			if (request != "?") {
				request += "&"
			}
			request += ("to=" + dateTo);
		}
		if (selectedPark != null) {
			if (request != "?") {
				request += "&"
			}
			request += ("park=" + selectedPark);
		}
		return request;
	}
}

function showRaceInfo(raceId){
	$('#race_info_panel').animate({
		opacity: 0
	});
	setTimeout(function(){
		$("#events_race_info_block").load("events/races/info?id="+raceId, function(){
			//$("#race_info_panel").css("opacity",1);
		});
	},333);
}