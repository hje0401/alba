package stockmgmt.stockhistory.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.dao.IStockHistoryDAO;
import stockmgmt.stockhistory.model.StockHistoryVO;

@Service
public class StockHistoryService implements IStockHistoryService{
	@Autowired
	private IStockHistoryDAO stockHistoryDao;
	
	@Transactional (rollbackFor={Exception.class,SQLException.class,MyBatisSystemException.class}, propagation = Propagation.REQUIRED)
	public ResultVO reqProdCntModif(List<StockHistoryVO> historyList){
		try {
			for (StockHistoryVO stockHistoryVO : historyList) {
				stockHistoryDao.insertProdHistory(stockHistoryVO);
				stockHistoryDao.reqProdCntModif(stockHistoryVO);
//				if(result == 0) {
//					return new ResultVO<JSONObject>(false);
//				}
			}
			return new ResultVO<JSONObject>(true);
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return new ResultVO<JSONObject>(false);
		}
		
	}

}
