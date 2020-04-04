/**
 * 
 */
'use strict';

var selectedPark = null;

function selectPark(parkName,parkId){
	console.log("hello");
	window.selectedPark = parkId;
	$('#events_parkselect').html(parkName);
	console.log("111");
}