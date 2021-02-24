package com.hoperun.yuntu_maps.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoperun.yuntu_maps.entities.JSONBean;
import com.hoperun.yuntu_maps.utils.TokenUtil;

@Component
public class TokenInterceptor implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){  //针对某些异步请求工具发送两次请求的情况，这一步只是在请求是否支持跨域之类，不包含任何实际请求数据
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Access-Token");
        if(token != null){
        	System.out.println(token);
        	
            boolean result = TokenUtil.verify(token.substring(7));
            System.out.println(result);
            
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{
        	ObjectMapper objectMapper = new ObjectMapper();
        	String result = objectMapper.writeValueAsString(new JSONBean(false, "验证失败", "401"));
        	response.getWriter().append(result);
        	System.out.println("认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
