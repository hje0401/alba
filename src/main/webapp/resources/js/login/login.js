/**
 * jekim
 * 로그인
 */
$(document).ready(function(){
	//비밀번호 enter키 이벤트
	$("#userPw").on("keypress",function(e){
		if (e.keyCode == 13) {
			checkValidation();
		}
	});
	
	//로그인 버튼 클릭
	$("#btnLogin").on("click",function(){
//		var url = context + "reqLogin.do";
//		document.form1.action = url;
//		document.form1.submit();
		
//		var param = {
//    			"userId" : "a", "userPw" : "b"
//            };
//		$.getJSON(context + "reqLogin.do", $.param(param, true), function(result) {
//			debugger;
//    	});
		
		checkValidation();
	});
	
});

checkValidation = function(){
	var userId = $("#userId").val();
	var userPw = $("#userPw").val();
	
	if(userId.trim() == ""){
		alert("ID를 입력해 주세요.");
		return false;
	}
	
	if(userPw.trim() == ""){
		alert("비밀번호를 입력해 주세요.");
		return false;
	}
	
	var saveIdYn = $("#cbSaveId").prop("checked") ? "Y" : "N";
	var data = {
			"userId"	: userId,
			"userPw"	: userPw,
			"saveIdYn"	: saveIdYn
	};
	
	reqLogin(data);
};

reqLogin = function(data){
	var option = {
			"url" : "reqLogin.do",
			"data" : data,
			"callback" : function(res){
				if(!res){
					alert("요청처리에 실패하였습니다.");
					return false;
				}
				if(!res.result){
					alert(res.errorMessage + " [" + res.errorCode + "]" );
					return false;
				}
				
				location.replace("stockList.do");
			}
	}
	util.requestToServer(option);
}