package com.sys.filter;

import javax.servlet.*;
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
/*
public class EncodingFilter extends OncePerRequestFilter
{
    private String encoding="UTF-8";

    private boolean forceEncoding = false;

    /**
     * Set the encoding to use for requests. This encoding will be passed into a
     * {@link javax.servlet.http.HttpServletRequest#setCharacterEncoding} call.
     * <p>
     * Whether this encoding will override existing request encodings (and
     * whether it will be applied as default response encoding as well) depends
     * on the {@link #setForceEncoding "forceEncoding"} flag.
     *
     * @param encoding the encoding
     *//*

public void setEncoding(String encoding)
{
    this.encoding = encoding;
}

    */


   /* public void setForceEncoding(boolean forceEncoding)
    {
        this.forceEncoding = forceEncoding;
    }



    public String filter(HttpServletRequest request, String input) {
        String ret = input;
        // 客户端请求参数值可能为(null)服务端过滤掉当null处理即可
        if (input == null || input.trim().equals("(null)")) {
            ret = null;
            return ret;
        }
        try {
            System.out.println(ret);
            ret = new String(input.getBytes("iso-8859-1"), this.encoding);
            System.out.println(ret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

/*final String method = request.getMethod();
        // 该处可以实现各种业务的自定义的过滤机制
        if (method.equalsIgnoreCase("get"))
        {
            try
            {
                ret = new String(input.getBytes("iso-8859-1"), this.encoding);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }*//*

        return ret;
    }
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        //设置request和response的编码格式
        if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null))
        {
            request.setCharacterEncoding(this.encoding);
            if (this.forceEncoding)
            {
                response.setCharacterEncoding(this.encoding);
            }
        }

        //对request中的参数进行编码格式的转换
        filterChain.doFilter(new HttpServletRequestWrapper(request)
        {
            private HttpServletRequest _getHttpServletRequest() {
                return (HttpServletRequest) super.getRequest();
            }
            @Override
            public String getRequestURI() {
                String value= this._getHttpServletRequest().getRequestURI();
                return  filter(this, value);
            }
            @Override
            public StringBuffer getRequestURL() {
                StringBuffer stringBuffer=this._getHttpServletRequest().getRequestURL();
                String value=stringBuffer.toString();
                return new StringBuffer(filter(this,value));
            }
            @Override
            public String getParameter(String name)
            {
                String value = super.getParameter(name);
                return filter(this, value);
            }

            @Override
            public String[] getParameterValues(String name)
            {
                String[] values = super.getParameterValues(name);
                if (values == null)
                {
                    return null;
                }
                for (int i = 0; i < values.length; i++)
                {
                    values[i] = filter(this, values[i]);
                }
                return values;
            }
        }, response);
    }
}

}
*/
