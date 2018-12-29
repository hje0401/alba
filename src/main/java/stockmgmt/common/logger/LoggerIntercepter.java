package stockmgmt.common.logger;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import stockmgmt.login.model.LoginVO;

public class LoggerIntercepter extends HandlerInterceptorAdapter{
	protected Logger log = LoggerFactory.getLogger(this.getClass());
//	protected static Logger log = Logger.getLogger(LoggerIntercepter.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("================================             START             ================================");
			log.debug(" Request URI \t:    " + request.getRequestURI());
			LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
			if(session != null) {
				log.debug(" Request USER \t:    " + session.getUserId());
			}
			Enumeration<String> paramNames = request.getParameterNames();
			StringBuffer objectValue = new StringBuffer();
		    while (paramNames.hasMoreElements()) {
		      String key = (String) paramNames.nextElement();
		      String value = request.getParameter(key);
		      objectValue.append(" , " + key + " = ").append(value);
		    }
		    log.debug(" RequestParameter Data ==>" + objectValue.toString());
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndVieew) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("================================             END             ================================");
		}
	}
}
