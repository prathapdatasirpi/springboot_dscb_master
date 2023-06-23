package com.datasirpi.dschatbox.common;

import com.datasirpi.dschatbox.dto.RequestMeta;
import com.datasirpi.dschatbox.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RequestMeta requestMeta;

    public JwtInterceptor(RequestMeta requestMeta) {
        this.requestMeta = requestMeta;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {
        System.out.println("---PRE_HANDLE Request for the Endpoint("+request.getRequestURI()+")---by JASBER_INTERCEPTOR---");
        String endPoint = request.getRequestURI();
//        if(!(endPoint.contains("login") || endPoint.contains("signup") || endPoint.contains("error"))){
//            String auth = request.getHeader("Authorization");
//            if (auth != null){
//                Claims claims = jwtUtils.verifyAccessToken(auth);
//                requestMeta.setUserId(Integer.parseInt(claims.getIssuer()));
//                requestMeta.setUserMail(claims.get("userMail").toString());
//            }
//        }
        return super.preHandle(request, response, handler);
    }
}
