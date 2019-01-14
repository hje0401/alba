package stockmgmt.stockhistory.dao;

import java.util.List;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.model.StockHistoryVO;

public interface IStockHistoryDAO{
	public int reqProdCntModif(StockHistoryVO historyVo);
	public int insertProdHistory(StockHistoryVO historyVo);
}
