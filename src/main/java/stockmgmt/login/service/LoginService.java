package stockmgmt.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stockmgmt.login.dao.ILoginDAO;
import stockmgmt.login.model.LoginVO;

@Service
public class LoginService implements ILoginService{
	
	@Autowired
	private ILoginDAO loginDao;
	
	public int reqUserInfoCnt(LoginVO loginVO){
		return loginDao.reqUserInfoCnt(loginVO);
	}
	
	public LoginVO reqLogin(LoginVO loginVO){
		return loginDao.reqLogin(loginVO);
	}
}
