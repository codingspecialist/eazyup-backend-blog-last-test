package shop.mtcoding.blogv2._core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. IP 로그 남기기
        System.out.println("접속자 ip : "+req.getRemoteAddr()); 
        System.out.println("접속자 user agent : "+req.getHeader("User-Agent"));

        // 2. 블랙리스트 추방
        if(req.getHeader("User-Agent").contains("XBox")){
            //resp.setContentType("text/html; charset=utf-8");
            resp.setHeader("Content-Type", "text/html; charset=utf-8");
            PrintWriter out = resp.getWriter();

            req.setAttribute("name", "홍길동");
            out.println("<h1>나가세요 크롬이면 : "+req.getAttribute("name")+"</h1>");
            return;
        }
        

        chain.doFilter(request, response); // 다음 필터로 request, response 전달 ..필터 없으면 DS로 전달
    }

}
