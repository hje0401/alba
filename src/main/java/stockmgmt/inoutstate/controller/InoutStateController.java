package stockmgmt.inoutstate.controller;

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
import stockmgmt.inoutstate.model.InoutStateVO;
import stockmgmt.inoutstate.service.IInoutStateService;
import stockmgmt.login.model.LoginVO;
import stockmgmt.stock.model.StockVO;

@Controller
public class InoutStateController extends UtilController{
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IInoutStateService inoutStateService;
	
	@RequestMapping(value="/inoutState.do")
	public ModelAndView stockList() throws Exception{
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		ModelAndView mv = new ModelAndView("state/inoutState");
		mv.addObject("session", session);
		
		return mv;
	}
	
	@RequestMapping(value="/reqStockInOutStoryList.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO reqStockInOutStoryList(@RequestBody SearchVO searchVo){
		int cnt = inoutStateService.reqStockInOutStoryListCnt(searchVo);
		List<InoutStateVO> list = inoutStateService.reqStockInOutStoryList(searchVo);
		
		JSONObject body = new JSONObject();
		body.put("totalCnt", cnt);
		body.put("list", list);
		
		ResultVO<JSONObject> resultVo = new ResultVO<JSONObject>();
		resultVo.setResult(true);
		resultVo.setBody(body);
		
		printResultLog(resultVo);

		return resultVo;
	}
}
