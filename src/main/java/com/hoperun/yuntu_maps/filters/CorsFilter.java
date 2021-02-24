package com.hoperun.yuntu_maps.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
@WebFilter(urlPatterns = "/*", filterName = "CorsFilter")
public class CorsFilter implements Filter {

	@Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest reqs = (HttpServletRequest) req;
        
        //getServletPath():字符串类似"/"根目录，"/user/login":登录控制器，就springmvc来说就是@RequestMap()中路由的组合，不包括域名、协议
      	//getPathInfo():/merchant/user/login,比getServletPath()多出项目名称
      	//getContextPath():获取项目的根路径,本地输出/merchant，因为不是在root下
      	//getRequestURI:获取根路径到地址结尾，本地输出/merchant/user/login
      	//getRequestURL:获取请求的地址链接（浏览器中输入的地址），是最完整的路径  http://localhost:8080/merchant/或者http://localhost:8080/merchant/user/login
      	//request.getServletContext().getRealPath("/")：D:\workspace4eclipse4.13\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\merchant\
      	//getScheme():获取的是使用的协议(http 或https)
      	//getProtocol():获取的是协议的名称(HTTP/1.11)
      	//getServerName():获取的是域名(xxx.com)
      	//getLocalName:获取到的是IP
      	//String fatherUrl = fatherUrl = req.getHeader("REFERER");//取得上一级页面的RUL，这个在防止页面被iframe嵌套时候非常有用
        
        String curOrigin = reqs.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", curOrigin == null ? "true" : curOrigin);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Access-Token");
        chain.doFilter(req, res);
    }

}
