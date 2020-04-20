/**
 * 
 */
'use strict';

var selectedPark = null;
var isFromDateSelected = false;
var selectedMonthFrom = null;
var selectedDayFrom = null;
var selectedYearFrom = null;
var isToDateSelected = false;
var selectedMonthFor = null;
var selectedDayFor = null;
var selectedYearFor = null;
var defaultToDate = null;
var defaultToYear = null;
var defaultToMonth = null;
var defaultFromDate = null;
var defaultFromYear = null;
var defaultFromMonth = null;

function selectPark(parkName,parkId){
	selectedPark = parkId;
	$('#events_parkselect').hide().html(parkName).fadeIn(333);
}

function eventsFromDate(title,hide,ending){
	if(hide&&!isFromDateSelected){
		showFromDate();
	}
	if(!hide&&isFromDateSelected){
		hideFromDate();
	}
	isFromDateSelected = hide;
	$('#events_fromdate').hide().html(title+ending).fadeIn(333);
}

function eventsToDate(title,hide,ending){
	if(hide&&!isToDateSelected){
		showToDate();
	}
	if(!hide&&isToDateSelected){
		hideToDate();
	}
	isToDateSelected = hide;
	$('#events_todate').hide().html(title+ending).fadeIn(333);
}

function monthFor(month){
	selectedMonthFor = month;
}

function showFromDate(){
	if(isToDateSelected){
		$('#events_select_options_container').animate({
			width : 1160
		});
	}else{
		$('#events_select_options_container').animate({
			width : 960
		});
	}
	$('#fromdate_calendar').animate({
		width : 260
	});
	$('#fromdate_calendar').animate({
		opacity:1
	});
	$('#todate_select_options').animate({
		'margin-left' :  10
	});
}

function hideFromDate() {
	selectedMonthFrom = null;
	selectedDayFrom = null;
	selectedYearFrom = null;
	$('#fromDate31').css("opacity", 1);
	$('#fromDate30').css("opacity", 1);
	$('#fromDate29').css("opacity", 1);
	$('#fromdate_calendar').animate({
		opacity : 0
	});
	$('#fromdate_calendar').animate({
		width : 0
	});
	$('#todate_select_options').animate({
		'margin-left' : -5
	});

	if (defaultFromDate != null) {
		$('#calendar_fromdate_days').html(defaultFromDate);
		defaultFromDate = null;
	}
	if (defaultFromYear != null) {
		$('#calendar_fromdate_years').html(defaultFromYear);
		defaultFromYear = null;
	}
	if (defaultFromMonth != null) {
		$('#calendar_fromdate_months').html(defaultFromMonth);
		defaultFromMonth = null;
	}

	setTimeout(function() {
		if (isToDateSelected) {
			$('#events_select_options_container').animate({
				width : 960
			});
		} else {
			$('#events_select_options_container').animate({
				width : 760
			});
		}
	}, 333);
}

function showToDate(){
	if(isFromDateSelected){
		$('#events_select_options_container').animate({
			width : 1160
		});
	}else{
		$('#events_select_options_container').animate({
			width : 960
		});
	}
	$('#todate_calendar').animate({
		width : 260
	});
	$('#todate_calendar').animate({
		opacity:1
	});
	$('#apply_search_options_button').animate({
		'margin-left' :  10
	});
}

function hideToDate() {
	selectedMonthFor = null;
	selectedDayFor = null;
	selectedYearFor = null;
	$('#toDate31').css("opacity", 1);
	$('#toDate30').css("opacity", 1);
	$('#toDate29').css("opacity", 1);
	$('#todate_calendar').animate({
		opacity : 0
	});
	$('#todate_calendar').animate({
		width : 0
	});
	if (defaultToDate != null) {
		$('#calendar_todate_days').html(defaultToDate);
		defaultToDate = null;
	}
	if (defaultToYear != null) {
		$('#calendar_todate_years').html(defaultToYear);
		defaultToYear = null;
	}
	if (defaultToMonth != null) {
		$('#calendar_todate_months').html(defaultToMonth);
		defaultToMonth = null;
	}
	$('#apply_search_options_button').animate({
		'margin-left' : -5
	});

	setTimeout(function() {
		if (isFromDateSelected) {
			$('#events_select_options_container').animate({
				width : 960
			});
		} else {
			$('#events_select_options_container').animate({
				width : 760
			});
		}
	}, 333);

}

function selectFromDate(date){
	if(date=='31'&&(selectedMonthFrom=='02'||selectedMonthFrom=='04'||selectedMonthFrom=='06'||selectedMonthFrom=='09'||selectedMonthFor=='11')){
		return;
	}
	if(date=='30'&&selectedMonthFrom=='02'){
		return;
	}
	if(date=='29'&&selectedMonthFrom=='02'&&(!(selectedYearFrom=='2020'||selectedYearFrom=='2016'||selectedYearFrom=='2012'||selectedYearFrom=='2024'))){
		return;
	}
	if(defaultFromDate==null){
		defaultFromDate = document.getElementById('calendar_fromdate_days').innerHTML;
	}
	$('#calendar_fromdate_days').hide().html(date).fadeIn(333);
	selectedDayFrom = date;
}

function selectFromYear(year){
	if(!(year=='2012'||year=='2016'||year=='2020'||year=='2024')&&selectedMonthFrom=='02'&&selectedDayFrom=='29'){
		selectFromDate('28');
		$('#fromDate29').css("opacity","0");
	}
	if((year=='2012'||year=='2016'||year=='2020'||year=='2024')&&selectedMonthFrom=='02'){
		$('#fromDate29').css("opacity","1");
	}
	selectedYearFrom = year;
	if(defaultFromYear==null){
		defaultFromYear = document.getElementById('calendar_fromdate_years').innerHTML;
	}
	$('#calendar_fromdate_years').hide().html(year).fadeIn(333);
}

function selectFromMonth(monthLabel,month){
	selectedMonthFrom = month;
	if(defaultFromMonth==null){
		defaultFromMonth = document.getElementById('calendar_fromdate_months').innerHTML;
	}
	$('#calendar_fromdate_months').hide().html(monthLabel).fadeIn(333);
	if(month=='04'||month=='06'||month=='09'||month=='11'){
		$('#fromDate29').css("opacity","1");
		$('#fromDate30').css("opacity","1");
		if(selectedDayFrom=='31'){
			selectFromDate('30');
		}
		$('#fromDate31').css("opacity","0");
	}
	if(month=='02'){
		$('#fromDate31').css("opacity","0");
		$('#fromDate30').css("opacity","0");
		if(selectedYearFrom=='2020'){
			if(selectedDayFrom=='31'||selectedDayFrom=='30'){
				selectFromDate('29');
			}
		}else{
			$('#fromDate29').css("opacity","0");
			if(selectedDayFrom=='31'||selectedDayFrom=='30'||selectedDayFrom=='29'){
				selectFromDate('28');
			}
		}
	}
	if(month=='01'||month=='03'||month=='05'||month=='07'||month=='08'||month=='10'||month=='12'){
		$('#fromDate29').css("opacity","1");
		$('#fromDate30').css("opacity","1");
		$('#fromDate31').css("opacity","1");
	}
}

function selectToDate(date){
	if(date=='31'&&(selectedMonthFor=='02'||selectedMonthFor=='04'||selectedMonthFor=='06'||selectedMonthFor=='09'||selectedMonthFor=='11')){
		return;
	}
	if(date=='30'&&selectedMonthFor=='02'){
		return;
	}
	if(date=='29'&&selectedMonthFor=='02'&&(!(selectedYearFor=='2020'||selectedYearFor=='2016'||selectedYearFor=='2012'||selectedYearFor=='2024'))){
		return;
	}
	if(defaultToDate==null){
		defaultToDate = document.getElementById('calendar_todate_days').innerHTML;
	}
	$('#calendar_todate_days').hide().html(date).fadeIn(333);
	selectedDayFor = date;
}

function selectToYear(year){
	if(!(year=='2012'||year=='2016'||year=='2020'||year=='2024')&&selectedMonthFor=='02'&&selectedDayFor=='29'){
		selectToDate('28');
		$('#toDate29').css("opacity","0");
	}
	if((year=='2012'||year=='2016'||year=='2020'||year=='2024')&&selectedMonthFor=='02'){
		$('#toDate29').css("opacity","1");
	}
	selectedYearFor = year;
	if(defaultToYear==null){
		defaultToYear = document.getElementById('calendar_todate_years').innerHTML;
	}
	$('#calendar_todate_years').hide().html(year).fadeIn(333);
}

function selectToMonth(monthLabel,month){
	selectedMonthFor = month;
	if(defaultToMonth==null){
		defaultToMonth = document.getElementById('calendar_todate_months').innerHTML;
	}
	$('#calendar_todate_months').hide().html(monthLabel).fadeIn(333);
	if(month=='04'||month=='06'||month=='09'||month=='11'){
		$('#toDate29').css("opacity","1");
		$('#toDate30').css("opacity","1");
		if(selectedDayFor=='31'){
			selectToDate('30');
		}
		$('#toDate31').css("opacity","0");
	}
	if(month=='02'){
		$('#toDate31').css("opacity","0");
		$('#toDate30').css("opacity","0");
		if(selectedYearFor=='2020'){
			if(selectedDayFor=='31'||selectedDayFor=='30'){
				selectToDate('29');
			}
		}else{
			$('#toDate29').css("opacity","0");
			if(selectedDayFor=='31'||selectedDayFor=='30'||selectedDayFor=='29'){
				selectToDate('28');
			}
		}
	}
	if(month=='01'||month=='03'||month=='05'||month=='07'||month=='08'||month=='10'||month=='12'){
		$('#toDate29').css("opacity","1");
		$('#toDate30').css("opacity","1");
		$('#toDate31').css("opacity","1");
	}
}

function getFromDate(){
	if(selectedYearFrom==null||selectedMonthFrom==null||selectedDayFrom==null){
		return null;
	}else{
		return selectedYearFrom+"-"+selectedMonthFrom+"-"+(selectedDayFrom.length==1?("0"+selectedDayFrom):selectedDayFrom);
	}
}

function getToDate(){
	if(selectedYearFor==null||selectedMonthFor==null||selectedDayFor==null){
		return null;
	}else{
		return selectedYearFor+"-"+selectedMonthFor+"-"+(selectedDayFor.length==1?("0"+selectedDayFor):selectedDayFor);
	}
}

function validateFromDate(){
	if(isFromDateSelected){
		return !(selectedYearFrom==null||selectedMonthFrom==null||selectedDayFrom==null);
	}else return true;
}

function validateToDate(){
	if(isToDateSelected){
		return !(selectedYearFor==null||selectedMonthFor==null||selectedDayFor==null);
	}else return true;
}

var isSearchOptionsHidden = true;

function searchOptions(){
	if(isSearchOptionsHidden){
		$('#search_race_panel_wrapper').css({ "overflow": "visible"});
		$('#search_race_panel_wrapper').animate({
			height: 'auto'
		});
		setTimeout(function(){
			$('#search_race_panel_wrapper').animate({
				opacity: 1
			});
			$('#seek_hide_button').html(hideSearchOptions);
		},333)
		isSearchOptionsHidden = false;
	}else{
		$('#seek_hide_button').html(seekOtherEvents);
		$('#search_race_panel_wrapper').animate({
			opacity: 0
		});
		setTimeout(function(){
			$('#search_race_panel_wrapper').animate({
			height: 'auto'
		});
			$('#search_race_panel_wrapper').css({ "overflow": "hidden"});
		},333)
		isSearchOptionsHidden = true;
		}
}	