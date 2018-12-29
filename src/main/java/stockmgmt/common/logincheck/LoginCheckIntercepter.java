package stockmgmt.common.logincheck;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import stockmgmt.login.model.LoginVO;

public class LoginCheckIntercepter extends HandlerInterceptorAdapter{
	private Set<String> uncheckedUrls = new HashSet<String>();
	private String redirectUrl = "/";
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getServletPath();
		if(uncheckedUrls.contains(requestUrl)) return true;
		
		LoginVO session = (LoginVO) RequestContextHolder.currentRequestAttributes().getAttribute("loginInfo", RequestAttributes.SCOPE_SESSION);
		if(!checkSession(session)){
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return false;
		}
		
		return true;
	}

	/**
	 * 세션이 유효하면 ture, 유효하지 않으면 false 리턴
	 */
	private boolean checkSession(LoginVO session) {
		String sessionUserId = session == null ? "" : (String)session.getUserId();
		if("".equals(sessionUserId)){
			return false;
		} else {
			return true;
		}
	}
	
	public void setUncheckedUrls(Set<String> uncheckedUrls) {
		this.uncheckedUrls = uncheckedUrls;
	}
}
