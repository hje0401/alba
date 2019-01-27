/**
 * 
 */
$(document).ready(function(){
	$recordT = $("#stockList .record").clone();
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
	
	//재고 리스트 더블클릭 이벤트
	$("#stockList").on("dblclick",".record",function(){
		var prodInfo = {
			"prodCode" : $(this).attr("prodCode"),
			"prodName" : $(this).find(".prodName").text(),
			"prodCnt"  : $(this).find(".prodCnt").text()
		};
		renderModifyProdList(prodInfo);
	});
	
	//재고 수정 리스트 제품 삭제
	$("#prodModifyWrap").on("click",".close",function(){
		$(this).closest(".prodModyBox").remove();
	});
	
	//입고버튼
	$("#btnInProd").on("click",function(){
		openInOutProdPopup("I");
	});
	//출고버튼
	$("#btnOutProd").on("click",function(){
		openInOutProdPopup("O");
	});
	
	//재고 리스트 조회
	reqList();
	
});

var $recordT = undefined;
var $prodModyBoxT = undefined;
var pageNo = 1;
var totalPaging = 1;

/**
 * 새로고침 
 */
refrash = function(){
	location.reload();
};
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
			"url" : "reqStockList.do",
			"data" : data,
			"callback" : function(res){
				renderStockList(res.body);
			}
	}
	util.requestToServer(option);
};

/**
 * 재고 목록 랜더
 */
renderStockList = function(res){
	//페이징 랜더
	util.makePageBlock(res.totalCnt);
	
	//재품 리스트 랜더
	$("#stockList .record").remove();
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
			$record.find(".prodCnt").text(data.stockCnt);
			$record.find(".updDate").text(data.uptDate);
			$record.find(".updId").text(data.uptId);
			$record.find(".updId").text(data.uptId);
			
			$("#stockList tbody").append($record);
		}
	}
};

/**
 * 재고수정 리스트 랜더
 */
renderModifyProdList = function(prodInfo){
	var $prodElem = $("#prodModifyWrap .prodModyBox[prodCode='"+prodInfo.prodCode+"']");
	var isInclusion = ($prodElem.length) > 0 ? true : false;
	
	if(isInclusion){
		$prodElem.remove();
	}else{
		var $prodModyBox = $prodModyBoxT.clone();
		$prodModyBox.attr("prodCode",prodInfo.prodCode);
		$prodModyBox.attr("prodCnt",prodInfo.prodCnt);
		$prodModyBox.find(".prodNm").text(prodInfo.prodName);
		$prodModyBox.appendTo("#prodModifyWrap");
	}
	
};

/**
 * 입/출고 팝업 open
 */
openInOutProdPopup = function(inoutFlag){
	var modyProdList = [];
	var inoutTxt = inoutFlag == "I" ? "입고" : "출고";
	$("#prodModifyWrap .prodModyBox").map(function(){
		modyProdList.push($(this).attr("prodCode"));
	});
	
	if(modyProdList.length == 0){
		alert(inoutTxt + "할 제품을 선택해 주세요.");
		return false;
	}
	
	var param = {"prodCodeList" : modyProdList , "inputFlag" : inoutFlag};
	util.openPopup("popupModifyProd.do", param, "popupModifyProd", 900, 650);
	return;
};