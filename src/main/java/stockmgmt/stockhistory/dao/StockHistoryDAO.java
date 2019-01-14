package stockmgmt.stockhistory.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.stockhistory.model.StockHistoryVO;

@Repository
public class StockHistoryDAO extends CommonDAO implements IStockHistoryDAO{
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionFactoryBean sqlSessionTemplate;
	
	public int reqProdCntModif(StockHistoryVO historyVo){
		return getSqlSession().insert("StockHistory.reqProdCntModif", historyVo);
	}
	
	public int insertProdHistory(StockHistoryVO historyVo) {
		
		return getSqlSession().insert("StockHistory.insertProdHistory", historyVo);
	}
}
