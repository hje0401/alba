package stockmgmt.stockMgt.dao;

import java.util.List;
import stockmgmt.common.model.SearchVO;
import stockmgmt.stockMgt.model.StockMgtVO;

public interface IStockMgtDAO {
	public int StockMgtListCnt(SearchVO searchVo);
	public List<StockMgtVO> StockMgtList(SearchVO searchVo);

}
