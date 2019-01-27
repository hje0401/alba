package stockmgmt.stockhistory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.model.StockHistoryListVO;
import stockmgmt.stockhistory.model.StockHistoryVO;
import stockmgmt.stockhistory.service.IStockHistoryService;

@Controller
public class StockHistoryController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IStockHistoryService stockHistoryService;
	
	@RequestMapping(value="/reqProdCntModify.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO reqProdCntModif(@RequestBody StockHistoryListVO historyList){
		List<StockHistoryVO> list = historyList.getHistoryList();
		ResultVO resultVo = stockHistoryService.reqProdCntModif(list);
		return resultVo;
//		for (StockHistoryVO stockHistoryVO : list) {
//			log.debug(stockHistoryVO.toString());
//		}
	}
}
