package stockmgmt.stockMgt.service;

import java.util.List;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stockMgt.model.StockMgtVO;

public interface IStockMgtService {
	public int StockMgtListCnt(SearchVO searchVo);
	public List<StockMgtVO> StockMgtList(SearchVO searchVo);

}
