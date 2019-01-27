/**
 * @author jekim
 * @desc 유틸리티 함수
 */

(function($, undefined)
{
	$(document).ready(function(){
		/**
		 * 전체메뉴
		 */
		//로그아웃 버튼
		$("#btnLogout").click(function(){
			location.href = "logout.do";
		});
		
		/**
		 * 페이징
		 */
		//페이지 번호 클릭
		$("#dataTables_paginate").on("click",".btnPage",function(){
			pageNo = $(this).attr("pageNo");
			$(".btnPage.active").removeClass("active");
			$(".btnPage[pageNo = '"+pageNo+"']").addClass("active");
			reqList();
		});
		
		//페이징 이전
		$("#dataTables-example_previous").on("click",function(){
			var prevPage = Number($(".btnPage:first").attr("pageNo")) - 5;
			if(prevPage < 1){
				return;
			}
			pageNo = prevPage;
			$(".btnPage.active").removeClass("active");
			$(".btnPage[pageNo = '"+pageNo+"']").addClass("active");
			reqList();
		});
		
		//페이징 다음
		$("#dataTables-example_next").on("click",function(){
			var nextPage = Number($(".btnPage:last").attr("pageNo")) + 1;
			if(nextPage > totalPaging){
				return;
			}
			pageNo = nextPage;
			$(".btnPage.active").removeClass("active");
			$(".btnPage[pageNo = '"+pageNo+"']").addClass("active");
			reqList();
		});
	});
})(jQuery, undefined);
