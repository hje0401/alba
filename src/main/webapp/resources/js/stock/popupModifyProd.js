/**
 * 
 */
$(document).ready(function(){
	var inputFlag = $("#inputFlag").val() == "I" ? "입고" : "출고";
	$(".page-header").text("출고현황 > " + inputFlag);
	$("#btnModyProd").text(inputFlag);
	
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
			alert(inputFlag + "할 제품이 없습니다.");
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
			alert(inputFlag + "할 수량을 모두 입력해 주세요.");
			return false;
		}
		
		var userName 	= $("#inpUserName").val(),
			reason		= $("#inpReason").val(),
			etc			= $("#inpEtc").val();
		
		if(userName == ""){
			alert(inputFlag + "자명을 입력해 주세요.");
			return false;
		}
		
		if(reason == ""){
			alert(inputFlag + "사유를 입력해 주세요.");
			return false;
		}
	});
	
});