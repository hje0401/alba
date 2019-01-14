/**
 * @author jekim
 * @desc 유틸리티 함수
 */

(function($, undefined)
{
	window.util = {};
	
	util.checkResponseError = function(res){
		if(!res){
			alert("요청처리에 실패하였습니다.");
			return false;
		}
		if(!res.resultCode){
			alert("요청처리에 실패하였습니다. [" + res.value + "]" );
			return false;
		}
		
		return true;
	};
	
	util.requestToServer = function(options){
		$.ajax({
			 type: "POST",
		     url: options.url,
		     dataType: "json",
		     data: JSON.stringify(options.data),
		     contentType: "application/json",
//		     traditional: true,
		     success: function(response) {
		    	 options.callback(response);
		     }, 
		     error: function(request, error, errormessage) {
		    	 alert("error : " + error);
		     } 
		});
	};
	
	util.openPopup = function(url, param, target, width, height, options){
		options = $.extend(true, {
            scrollbars : "no",
            resizable : "no"
        }, options || {});

        var winLeft = (screen.width - width) / 2;
        var winTop = (screen.height - height) / 2;
        var status = 'height='+height+',width='+width+',top='+winTop+',left='+winLeft+',scrollbars='+options.scrollbars+',resizable=' + options.resizable;
        var win = window.open("", target, status);
        
        $.post(
                url,
                $.param(param, true),
                function(result) {
                   win.document.write(result);
                   win.document.close();
                }
            );

        try {
            win.window.focus();
        }
        catch(e){
        }

        return win;
        
//		options = $.extend(true, {
//            scrollbars : "no",
//            resizable : "no",
//            top : (screen.height - height) / 2,
//            left : (screen.width - width) / 2
//        }, options || {});
//
//        var status = 'height='+height+',width='+width+',top='+options.top+',left='+options.left+',scrollbars='+options.scrollbars+',resizable=' + options.resizable;
//
//        var win = window.open(url, target, status);
//        if (win == null) {
//            return win;
//        }
//
//        try {
//            win.window.focus();
//        }
//        catch(e){
//        }
//
//        return win;
	};
	
	util.makePageBlock = function(totalCnt){
		$("#dataTables_paginate .btnPage").remove();
		
		var maxPaging = Math.ceil(pageNo / def.PAGING_BLOCK_CNT),
			startPageIdx = ( (maxPaging - 1) * def.PAGING_BLOCK_CNT ) + 1,
			endPageIdx =startPageIdx + def.PAGING_BLOCK_CNT - 1; 
		
		totalPaging = Math.ceil(totalCnt / def.PAGING_CNT);
		if (endPageIdx > totalPaging){
			endPageIdx = totalPaging;
		} 
		
		for(var i=startPageIdx; i<=endPageIdx; i++){
			var $pagingElem = $("<li>"),
				$pagingSpan = $("<span>");
			$pagingElem.addClass("paginate_button btnPage").attr("pageNo",i);
			$pagingSpan.text(i);
			$pagingSpan.appendTo($pagingElem);
			$pagingElem.insertBefore( "#dataTables-example_next" );
		}
		
		$(".btnPage.active").removeClass("active");
		$(".btnPage[pageNo = '"+pageNo+"']").addClass("active");
	};
	
})(jQuery, undefined);
