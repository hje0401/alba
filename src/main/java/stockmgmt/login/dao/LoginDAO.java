package stockmgmt.login.dao;

import stockmgmt.login.model.LoginVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO implements ILoginDAO{
	
	@Autowired
    private SqlSessionTemplate sqlSession;


	public int reqUserInfoCnt(LoginVO loginVo) {
		return sqlSession.selectOne("Login.reqUserInfoCnt",loginVo);
	}
	
	public LoginVO reqLogin(LoginVO loginVo) {
		LoginVO test = sqlSession.selectOne("Login.reqLogin",loginVo); 
		return test;
	}
}
