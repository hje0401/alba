package stockmgmt.stockhistory.service;

import java.util.List;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.model.StockHistoryVO;

public interface IStockHistoryService {
	public ResultVO reqProdCntModif(List<StockHistoryVO> historyList);
}
