package stockmgmt.stock.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stock.model.StockVO;

@Repository
public class StockDAO implements IStockDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int reqStockListCnt(SearchVO searchVo) {
		return sqlSession.selectOne("Stock.reqStockListCnt", searchVo);
	}
	
	public List<StockVO> reqStockList(SearchVO searchVo){
		return sqlSession.selectList("Stock.reqStockList", searchVo);
	}
	
	public List<StockVO> reqModyStockList(StockVO stockVo){
		return sqlSession.selectList("Stock.reqModyStockList", stockVo);
	}
}
