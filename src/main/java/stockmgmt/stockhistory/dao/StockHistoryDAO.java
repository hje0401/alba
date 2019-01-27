package stockmgmt.stockhistory.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.stockhistory.model.StockHistoryVO;

@Repository
public class StockHistoryDAO extends CommonDAO implements IStockHistoryDAO{
	public int reqProdCntModif(SqlSession sqlSession, StockHistoryVO historyVo){
		if("I".equals(historyVo.getGubun())) {
			return sqlSession.insert("StockHistory.reqProdCntModifIn", historyVo);
		}else {
			return sqlSession.insert("StockHistory.reqProdCntModifOut", historyVo);
		}
	}
	
	public int insertProdHistory(SqlSession sqlSession, StockHistoryVO historyVo) {
		return sqlSession.insert("StockHistory.insertProdHistory", historyVo);
	}
}
