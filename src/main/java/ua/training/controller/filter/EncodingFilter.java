package ua.training.controller.filter;

import ua.training.constants.EncodingTypes;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType(EncodingTypes.CONTENT_TYPE);
        servletResponse.setCharacterEncoding(EncodingTypes.ENCODING_CHAR);
        servletRequest.setCharacterEncoding(EncodingTypes.ENCODING_CHAR);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
