package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(servletNames = { "FrontController" })
public class SetEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//doFilter 메소드의 인자 request는 타입이 HttpServletRequest(인터페이스) 가 아닙니다
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		httpRequest.setCharacterEncoding("UTF-8");
		chain.doFilter(httpRequest, response);	//필터틑 체인으로 구성될 수 있으므로 다음 필터 실행
	}
	//이 필터는 모든 요청에 대한 문자인코딩을 UTF-8로 합니다. 따라서 서블릿에서
	//httpRequest.setCharacterEncoding("UTF-8"); 코딩은 작성 안해도 됩니다.
}

