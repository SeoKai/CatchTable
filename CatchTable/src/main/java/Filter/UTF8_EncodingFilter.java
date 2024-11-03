package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class UTF8_EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[Filter] UTF8_EncodingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("[Filter] UTF8_EncodingFilter..Start");

        // 요청 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 응답 인코딩 설정
        response.setContentType("text/html; charset=UTF-8");

        // 필터 체인 실행
        chain.doFilter(request, response);
        
        System.out.println("[Filter] UTF8_EncodingFilter..End");
    }

    @Override
    public void destroy() {
        System.out.println("[Filter] UTF8_EncodingFilter destroyed");
    }
}
