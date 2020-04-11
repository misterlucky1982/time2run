/**
 * 
 */
'use strict';

var selectedPark = null;

function selectPark(parkName,parkId){
	window.selectedPark = parkId;
	$('#events_parkselect').html(parkName);
}