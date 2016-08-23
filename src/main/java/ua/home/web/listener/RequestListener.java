package ua.home.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	private static final ThreadLocal<String> sessionIds = new ThreadLocal<>();

	public static String getCurrentSessionId() {
		return 	sessionIds.get();
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
		String id = request.getSession().getId();
		sessionIds.set(id);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {	}
}
