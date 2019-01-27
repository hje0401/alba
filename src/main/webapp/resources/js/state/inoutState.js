/**
 * 
 */

var $recordT = undefined;
var pageNo = 1;
var totalPaging = 1;

$(document).ready(function(){
	$recordT = $("#stockInOutHistory .record").clone();
	$("#stockInOutHistory .record").remove();
	
	//입출고 이력 조회
	reqStockInOutStoryList();
});