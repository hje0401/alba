package stockmgmt.stock.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.common.model.SearchVO;
import stockmgmt.stock.model.StockVO;

@Repository
public class StockDAO extends CommonDAO implements IStockDAO{
	@Autowired
	@Qualifier("sqlSessionTemplate")
    private SqlSessionFactoryBean sqlSessionTemplate;
	
	public int reqStockListCnt(SearchVO searchVo){
		return getSqlSession().selectOne("Stock.reqStockListCnt", searchVo);
	}
	
	public List<StockVO> reqStockList(SearchVO searchVo){
		return getSqlSession().selectList("Stock.reqStockList", searchVo);
	}
	
	public List<StockVO> reqModyStockList(StockVO stockVo){
		return getSqlSession().selectList("Stock.reqModyStockList", stockVo);
	}
}
