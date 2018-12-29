package stockmgmt.stock.dao;

import java.util.List;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stock.model.StockVO;

public interface IStockDAO {
	public int reqStockListCnt(SearchVO searchVo);
	public List<StockVO> reqStockList(SearchVO searchVo);
	public List<StockVO> reqModyStockList(StockVO stockVo);
}
