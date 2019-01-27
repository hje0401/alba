package stockmgmt.inoutstate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import stockmgmt.login.model.LoginVO;

@Controller
public class InoutStateController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/inoutState.do")
	public ModelAndView stockList() throws Exception{
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		ModelAndView mv = new ModelAndView("state/inoutState");
		mv.addObject("session", session);
		
		return mv;
	}
}
