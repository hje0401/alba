package stockmgmt.stockMgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stockMgt.dao.IStockMgtDAO;
import stockmgmt.stockMgt.model.StockMgtVO;
@Service
public class StockMgtService implements IStockMgtService{
	
	@Autowired
	private IStockMgtDAO IStockMgtDAO;
	
	public int StockMgtListCnt(SearchVO searchVo){
		return IStockMgtDAO.StockMgtListCnt(searchVo);
	}
	
	public List<StockMgtVO> StockMgtList(SearchVO searchVo){
		return IStockMgtDAO.StockMgtList(searchVo);
	}
	
}