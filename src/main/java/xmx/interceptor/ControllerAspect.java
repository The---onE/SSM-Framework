package xmx.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import xmx.dao.LogMapper;
import xmx.model.Admin;
import xmx.model.Log;
import xmx.model.User;
import xmx.util.IPUtil;

@Component
@Aspect
public class ControllerAspect {
	
	@Resource
	private LogMapper logDao;

	@Pointcut("execution (* xmx.controller..*.*(..))")
	private void point() {
	}

	@After("point()")
	public void doAfter(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String ip = IPUtil.getIP(request);
		String target = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().toString();
		Object[] params = joinPoint.getArgs();
		StringBuffer param = new StringBuffer();
		for (Object o : params) {
			if (o == null) {
				param.append("?_?");
			} else if (o instanceof String) {
				param.append(o);
			} else if (o.getClass().isPrimitive()) {
				param.append(o);
			} else {
				param.append(o.getClass().getSimpleName());
			}
			param.append(" ");
		}
		HttpSession session = request.getSession();
		String user = "";
		String userType = "";
		Object o;
		o = session.getAttribute("admin");
		if (o != null && o instanceof Admin) {
			user = ((Admin) o).getUsername();
			userType = "Admin";
		} else {
			o = session.getAttribute("user");
			if (o != null && o instanceof User) {
				user = ((User) o).getUsername();
				userType = "User";
			}
		}

		Log log = new Log();
		log.setType("controller");
		log.setTarget(target);
		log.setMethod(method);
		log.setParam(param.toString());
		log.setUser(user);
		log.setUserType(userType);
		log.setIp(ip);

		logDao.insertSelective(log);
	}

	@Around("point()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		Object object = pjp.proceed();
		return object;
	}
}
