package stockmgmt.stockMgt.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import stockmgmt.common.model.ResultVO;
import stockmgmt.common.model.SearchVO;
import stockmgmt.common.util.UtilController;
import stockmgmt.login.model.LoginVO;
import stockmgmt.stock.model.StockVO;
import stockmgmt.stockMgt.model.StockMgtVO;
import stockmgmt.stockMgt.service.IStockMgtService;

@Controller
public class StockMgtController extends UtilController{
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IStockMgtService stockMgtService;
	
	@RequestMapping(value="/stockMgtList.do")
	public ModelAndView stockList(){
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		ModelAndView mv = new ModelAndView("stockMgt/stockMgt");
		mv.addObject("session", session);
		
		return mv;
	}
	
	@RequestMapping(value="/StockSearchList.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO StockSearchList(SearchVO searchVo){
		int stockMgtCnt = stockMgtService.StockMgtListCnt(searchVo);
		List<StockMgtVO> stockMgtList = stockMgtService.StockMgtList(searchVo);
		
		JSONObject body = new JSONObject();
		body.put("totalCnt", stockMgtCnt);
		body.put("list", stockMgtList);
		
		ResultVO resultVo = new ResultVO();
		resultVo.setResult(true);
		resultVo.setBody(body);
		
		printResultLog(resultVo);

		return resultVo;
	}
}