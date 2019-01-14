package stockmgmt.login.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import stockmgmt.common.dao.CommonDAO;
import stockmgmt.login.model.LoginVO;

@Repository
public class LoginDAO extends CommonDAO implements ILoginDAO{
	
//	@Autowired
//    private SqlSessionTemplate sqlSession;
	@Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSessionFactoryBean sqlSessionTemplate;

	public int reqUserInfoCnt(LoginVO loginVo){
		return getSqlSession().selectOne("Login.reqUserInfoCnt",loginVo);
	}
	
	public LoginVO reqLogin(LoginVO loginVo){
		return getSqlSession().selectOne("Login.reqLogin",loginVo);
	}
}
