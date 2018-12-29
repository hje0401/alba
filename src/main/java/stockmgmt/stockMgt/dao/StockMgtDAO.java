package stockmgmt.stockMgt.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import stockmgmt.common.model.SearchVO;
import stockmgmt.stockMgt.model.StockMgtVO;

@Repository
public class StockMgtDAO implements IStockMgtDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int StockMgtListCnt(SearchVO searchVo) {
		return sqlSession.selectOne("StockMgt.StockMgtListCnt", searchVo);
	}
	
	public List<StockMgtVO> StockMgtList(SearchVO searchVo){
		return sqlSession.selectList("StockMgt.StockMgtList", searchVo);
	}
}
