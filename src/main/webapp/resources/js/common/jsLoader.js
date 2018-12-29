(function()
{
	var RELATE_DEPTH = "/stockmgmt/resources/js/common/";
		
	var jsUrls = 
	[
	 	"const.js",
	 	"util.js",
	 	"common.js",
	];

	var JsList="";
		
	for(var i=0;i<jsUrls.length;i++) 
	{
		JsList +=	"<script type=\"text/javascript\" src=\""+ RELATE_DEPTH + jsUrls[i] + "\" charset=\"utf-8\"></script>";
	}
	$("head").append(JsList);
})();
