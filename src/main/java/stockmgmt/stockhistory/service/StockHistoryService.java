package stockmgmt.stockhistory.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.istack.internal.logging.Logger;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.dao.IStockHistoryDAO;
import stockmgmt.stockhistory.model.StockHistoryVO;

@Service
@Transactional(rollbackFor={Exception.class}) 
public class StockHistoryService implements IStockHistoryService{
	@Autowired
	private IStockHistoryDAO stockHistoryDao;
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionFactoryBean sqlSessionTemplate;
	
	public ResultVO reqProdCntModif(List<StockHistoryVO> historyList){
		SqlSession sqlSession = null;
		try {
			SqlSessionFactory sessionFactory = sqlSessionTemplate.getObject();
			sqlSession = sessionFactory.openSession(false);
			
			sqlSession.getConnection().setAutoCommit(false);
			
			for (StockHistoryVO stockHistoryVO : historyList) {
				stockHistoryDao.insertProdHistory(sqlSession, stockHistoryVO);
				stockHistoryDao.reqProdCntModif(sqlSession, stockHistoryVO);
			}
			sqlSession.getConnection().commit();
			return new ResultVO<JSONObject>(true);
		} catch(Exception e) {
			sqlSession.rollback();
			return new ResultVO<JSONObject>(false,"SH0001","입/출고 오류");
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
