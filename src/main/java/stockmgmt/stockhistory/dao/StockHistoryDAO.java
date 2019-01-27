package stockmgmt.stockhistory.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.login.model.LoginVO;
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
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		historyVo.setRegId(session.getUserId());
		return sqlSession.insert("StockHistory.insertProdHistory", historyVo);
	}
}
