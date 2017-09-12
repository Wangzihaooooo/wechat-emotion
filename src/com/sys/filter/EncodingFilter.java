package com.sys.filter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码过滤器， 设置当前系统的编码。
 */
public class EncodingFilter implements Filter
{
    private String encoding = "UTF-8";
    private String contentType = "text/html;charset=UTF-8";
    // 项目启动时就已经进行读取
    @Override
    public void init(FilterConfig config) throws ServletException {
        String _encoding = config.getInitParameter("encoding");
        String _contentType = config.getInitParameter("contentType");
        // String ext=config.getInitParameter("ext");
        if (_encoding != null)
            encoding = _encoding;
        if (_contentType != null)
            contentType = _contentType;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse httpresponse,
                         FilterChain chain) throws IOException, ServletException {
        // 将请求和响应强制转换成Http形式
        HttpServletResponse response=(HttpServletResponse)httpresponse;
        // 处理响应乱码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType(contentType);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setHeader("Access-Control-Allow-Headers","accept, origin, content-type");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods","POST,GET");

        chain.doFilter(request, response);
    }
    @Override
    public void destroy() { }
}
