package common.mailServer.config.interceptor;

import common.mailServer.mail.sender.dto.MultipartFileCustomDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class DataFilterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("dataFilterInterceptor : 요청 Path = " + request.getServletPath());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
