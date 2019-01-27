/**
 * 
 */
$(document).ready(function(){
	var inputFlag = $("#inputFlag").val();
	var inputFlagNm = inputFlag == "I" ? "입고" : "출고";
	$(".page-header").text("출고현황 > " + inputFlagNm);
	$("#btnModyProd").text(inputFlagNm);
	
	//제품 삭제 버튼
	$(".btnRemove").on("click",function(){
		var $record = $(this).closest(".record");
		var prodName = $record.find(".prodName").text();
		
		var result = confirm(prodName + " 제품을 삭제하시겠습니까?");
		if(result){
			$record.remove();
		}
	});
	
	//입고/출고 버튼
	$("#btnModyProd").on("click",function(){
		if($(".prodCnt").length == 0){
			alert(inputFlagNm + "할 제품이 없습니다.");
			return;
		}
		
		var cntFlag = true;
		$(".prodCnt").each(function(idx,arg){
			if(arg.value == "" || arg.value < 1){
				cntFlag = false;
				return false;
			}
		});
		
		if(!cntFlag){
			alert(inputFlagNm + "할 수량을 모두 입력해 주세요.");
			return false;
		}
		
		var userName 	= $("#inpUserName").val(),
			reason		= $("#inpReason").val(),
			etc			= $("#inpEtc").val();
		
		if(userName == ""){
			alert(inputFlagNm + "자명을 입력해 주세요.");
			return false;
		}
		
		if(reason == ""){
			alert(inputFlagNm + "사유를 입력해 주세요.");
			return false;
		}
		
		var prodList = [];
		$(".prodModifyWrap .record").each(function(idx,arg){
			var prodCode = $(arg).attr("prodCode");
			var inoutCnt = $(arg).find(".prodCnt").val();
			var prodInfo = {
				"prodCode" : prodCode,
				"inoutCnt" : inoutCnt,
				"userName" : userName,
				"stockMemo" : reason,
				"stockEtc" : etc,
				"gubun" : inputFlag
			};
			
			prodList.push(prodInfo);
		});
		
		reqProdCntModify(prodList);
	});
});

reqProdCntModify = function(prodList){
	param = {"historyList" : prodList};
	var option = {
			"url" : "reqProdCntModify.do",
			"data" : param,
			"contentType" : "application/json",
			"callback" : function(res){
				if(util.checkResponseError(res)){
					alert("등록 되었습니다.");
					opener.refrash();
					window.close();
				}
			}
	}
	
	util.requestToServer(option);
};