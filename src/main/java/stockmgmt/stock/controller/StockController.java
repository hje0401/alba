
package stockmgmt.stock.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
import stockmgmt.stock.service.IStockService;

@Controller
public class StockController extends UtilController{
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IStockService stockService;
	
	@RequestMapping(value="/stockList.do")
	public ModelAndView stockList(){
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		ModelAndView mv = new ModelAndView("stock/stockList");
		mv.addObject("session", session);
		
		return mv;
	}
	
	@RequestMapping(value="/reqStockList.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO reqStockList(@RequestBody SearchVO searchVo){
		int stockCnt = stockService.reqStockListCnt(searchVo);
		List<StockVO> stockList = stockService.reqStockList(searchVo);
		
		JSONObject body = new JSONObject();
		body.put("totalCnt", stockCnt);
		body.put("list", stockList);
		
		ResultVO<JSONObject> resultVo = new ResultVO<JSONObject>();
		resultVo.setResult(true);
		resultVo.setBody(body);
		
		printResultLog(resultVo);

		return resultVo;
	}
	
	@RequestMapping(value="/popupModifyProd.do", method = RequestMethod.POST)
	public ModelAndView popupModifyProd(StockVO stockVo){
		ModelAndView mv = new ModelAndView("stock/popupModifyProd");
		
		List<StockVO> modyStockList = stockService.reqModyStockList(stockVo);
		mv.addObject("modyStockList", modyStockList);
		mv.addObject("inputFlag", stockVo.getInputFlag());
		return mv;
	}
}
