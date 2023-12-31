package hcmute.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static void add(HttpServletRequest req, String name, Object value) {
		HttpSession session = req.getSession();
		session.setAttribute(name, value);
	}
	
	public static Object get(HttpServletRequest req, String name) {
		HttpSession session = req.getSession();
		return session.getAttribute(name);
	}
	public static void invalidate(HttpServletRequest req) {
		HttpSession session = req.getSession();
		req.removeAttribute("acc");
		session.invalidate();
	}
	
	public static boolean isLogin(HttpServletRequest req) {
		return get(req, "acc")!=null;
	}
	
	public static String getLogin(HttpServletRequest req) {
		Object username = get(req, "acc");
		return username == null?null:username.toString();
	}
}
