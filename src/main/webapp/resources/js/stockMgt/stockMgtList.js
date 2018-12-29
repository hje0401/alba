/**
 * 
 */
$(document).ready(function(){
	$recordT = $("#stockMgtList .record").clone();
	$prodModyBoxT = $("#prodModifyWrap .prodModyBox").clone();
	$("#stockList .record, #prodModifyWrap .prodModyBox").remove();
	
	//input 엔터키
	$("#prodName , #searchDate").on("keypress",function(e){
		if (e.keyCode == 13) {
			pageNo = 1;
			reqList();
		}
	});
	
	//검색버튼
	$("#btnSearch").on("click",function(){
		pageNo = 1;
		reqList();
	});
	
	//재고 리스트 조회
	reqList();
	
});

var $recordT = undefined;
var $prodModyBoxT = undefined;
var pageNo = 1;
var totalPaging = 1;

/**
 * 재고 목록 조회
 */
reqList = function(){
	var data = {
			"prodName" : $("#prodName").val(),
			"prodCategory" : $("#prodCategory option:selected").attr("value"),
			"searchDate" : $("#searchDate").val(),
			"pageNo" : pageNo
	};
	var option = {
			"url" : "StockSearchList.do",
			"data" : data,
			"callback" : function(res){
				StockMgtList(res.body);
			}
	}
	util.requestToServer(option);
};

/**
 * 재고 목록 랜더
 */
StockMgtList = function(res){
	//페이징 랜더
	util.makePageBlock(res.totalCnt);
	
	//재품 리스트 랜더
	$("#stockMgtList .record").remove();
	var totalCnt = res.totalCnt;
	if(totalCnt == 0){
		$("#noData").removeClass("hide");
	}else{
		$("#noData").addClass("hide");
		for(var i=0; i<res.list.length; i++){
			var data = res.list[i];
			var $record = $recordT.clone();
			$record.find(".no").text(data.no);
			$record.find(".prodName").text(data.prodName);
			$record.find(".salePrice").text(data.salePrice);
			$record.find(".originPrice").text(data.originPrice);
			$record.find(".prodCnt").text(data.stockCnt);
			$record.find(".updDate").text(data.uptDate);
			$record.find(".updId").text(data.uptId);
			
			$("#stockMgtList tbody").append($record);
		}
	}
};
