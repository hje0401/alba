package stockmgmt.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stock.dao.IStockDAO;
import stockmgmt.stock.model.StockVO;

@Service
public class StockService implements IStockService{

	@Autowired
	private IStockDAO stockDao;
	
	public int reqStockListCnt(SearchVO searchVo){
		return stockDao.reqStockListCnt(searchVo);
	}
	
	public List<StockVO> reqStockList(SearchVO searchVo){
		return stockDao.reqStockList(searchVo);
	}
	
	public List<StockVO> reqModyStockList(StockVO stockVo){
		return stockDao.reqModyStockList(stockVo);
	}
	
}
