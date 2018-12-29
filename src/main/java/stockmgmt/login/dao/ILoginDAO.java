package stockmgmt.login.dao;

import stockmgmt.login.model.LoginVO;

public interface ILoginDAO {
	public int reqUserInfoCnt(LoginVO loginVo);
	public LoginVO reqLogin(LoginVO loginVo);
}
