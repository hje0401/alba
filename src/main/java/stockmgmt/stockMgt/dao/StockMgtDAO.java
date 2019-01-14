package stockmgmt.stockMgt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.common.model.SearchVO;
import stockmgmt.stockMgt.model.StockMgtVO;

@Repository
public class StockMgtDAO extends CommonDAO implements IStockMgtDAO{
	@Autowired
	@Qualifier("sqlSessionTemplate")
    private SqlSessionFactoryBean sqlSessionTemplate;
	
	public int StockMgtListCnt(SearchVO searchVo){
		return getSqlSession().selectOne("StockMgt.StockMgtListCnt", searchVo);
	}
	
	public List<StockMgtVO> StockMgtList(SearchVO searchVo){
		return getSqlSession().selectList("StockMgt.StockMgtList", searchVo);
	}
}
