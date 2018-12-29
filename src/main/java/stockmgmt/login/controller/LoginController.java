package stockmgmt.login.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import stockmgmt.common.model.ResultVO;
import stockmgmt.common.util.UtilController;
import stockmgmt.login.model.LoginVO;
import stockmgmt.login.service.ILoginService;

@Controller
public class LoginController extends UtilController{
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private ILoginService loginService;
	
	@RequestMapping(value="/login.do")
	public ModelAndView login(@CookieValue(value="storeIdCookie", required = false) Cookie storedCookie) throws Exception{
		ModelAndView mv = new ModelAndView("login/login");
		if(storedCookie != null) {
			mv.addObject("userId", storedCookie.getValue());
		}
		return mv;
	}
	
	@RequestMapping(value="/reqLogin.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO reqLogin(LoginVO loginVo, HttpServletResponse response) throws Exception{
		ResultVO resultVo = new ResultVO(false);
		
		int userInfoCnt = loginService.reqUserInfoCnt(loginVo);
		
		if(userInfoCnt > 0) {
			LoginVO loginInfo = loginService.reqLogin(loginVo);
			RequestContextHolder.currentRequestAttributes().setAttribute("loginInfo", loginInfo, RequestAttributes.SCOPE_SESSION);
			
			//자동로그인 설정
			if("Y".equals(loginVo.getSaveIdYn())) {
				Cookie storeIdCookie = new Cookie("storeIdCookie", loginVo.getUserId());
				response.addCookie(storeIdCookie);
			}else {
				Cookie storeIdCookie = new Cookie("storeIdCookie", null);
				storeIdCookie.setMaxAge(0);
				response.addCookie(storeIdCookie);
			}

			resultVo.setResult(true);
		}else {
			resultVo.setErrorMessage("아이디 또는 비밀번호를 확인해 주세요.");
		}
		printResultLog(resultVo);
		return resultVo;
	}
	
	@RequestMapping(value="/logout.do")
	public ModelAndView logout() throws Exception{
		RequestContextHolder.currentRequestAttributes().setAttribute("loginInfo", null, RequestAttributes.SCOPE_SESSION);
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}
}
