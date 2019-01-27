/**
 * 
 */

var $recordT = undefined;
var pageNo = 1;
var totalPaging = 1;

$(document).ready(function(){
	$recordT = $("#stockInOutHistory .record").clone();
	$("#stockInOutHistory .record").remove();
	
	//input 엔터키
	$("#prodName , #memberNm , #stdDate, #endDate").on("keypress",function(e){
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
	
	//입출고 이력 조회
	reqList();
});

reqList = function(){
	var data = {
			"prodName" : $("#prodName").val(),
			"prodCategory" : $("#prodCategory option:selected").attr("value"),
			"stdDate" : $("#stdDate").val(),
			"endDate" : $("#endDate").val(),
			"memberNm" : $("#memberNm").val(),
			"pageNo" : pageNo
	};
	var option = {
			"url" : "reqStockInOutStoryList.do",
			"data" : data,
			"callback" : function(res){
				renderInoutHistoryList(res.body);
			}
	}
	util.requestToServer(option);
};

renderInoutHistoryList = function(res){
	//페이징 랜더
	util.makePageBlock(res.totalCnt);
	
	//입출고 리스트 랜더
	$("#stockInOutHistory .record").remove();
	var totalCnt = res.totalCnt;
	if(totalCnt == 0){
		$("#noData").removeClass("hide");
	}else{
		$("#noData").addClass("hide");
		for(var i=0; i<res.list.length; i++){
			var data = res.list[i];
			var $record = $recordT.clone();
			$record.attr("prodCode",data.prodCode);
			$record.find(".no").text(data.no);
			$record.find(".prodName").text(data.prodName);
			$record.find(".inoutCnt").text(data.inoutCnt);
			$record.find(".userNm").text(data.userNm);
			$record.find(".gubun").text(data.gubun == 'I' ? "입고" : "출고");
			$record.find(".stockMemo").text(data.stockMemo);
			$record.find(".stockEtc").text(data.stockEtc);
			$record.find(".regDate").text(data.regDate);
			
			$("#stockInOutHistory tbody").append($record);
		}
	}
};