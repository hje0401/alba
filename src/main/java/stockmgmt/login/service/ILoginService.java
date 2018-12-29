package stockmgmt.login.service;

import stockmgmt.login.model.LoginVO;

public interface ILoginService {
	public int reqUserInfoCnt(LoginVO loginVo);
	public LoginVO reqLogin(LoginVO loginVo);
}
