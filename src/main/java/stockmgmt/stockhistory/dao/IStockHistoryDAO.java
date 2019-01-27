package stockmgmt.stockhistory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import stockmgmt.common.model.ResultVO;
import stockmgmt.stockhistory.model.StockHistoryVO;

public interface IStockHistoryDAO{
	public int reqProdCntModif(SqlSession sqlSession, StockHistoryVO historyVo);
	public int insertProdHistory(SqlSession sqlSession, StockHistoryVO historyVo);
}
