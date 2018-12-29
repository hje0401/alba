package stockmgmt.inoutstate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoutStateController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/inoutState.do")
	public ModelAndView stockList() throws Exception{
		ModelAndView mv = new ModelAndView("state/inoutState");
		return mv;
	}
}
