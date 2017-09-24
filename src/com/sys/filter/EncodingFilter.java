package com.sys.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 编码过滤器， 设置当前系统的编码。
 */

/**
 * The type Encoding filter.
 * 自定义编码过滤器，解决乱码问题
 */
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
     */
    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing request and response encodings.
     * <p>
     * Default is "false", i.e. do not modify the encoding if
     * {@link javax.servlet.http.HttpServletRequest#getCharacterEncoding()}
     * returns a non-null value. Switch this to "true" to enforce the specified
     * encoding in any case, applying it as default response encoding as well.
     * <p>
     * Note that the response encoding will only be set on Servlet 2.4+
     * containers, since Servlet 2.3 did not provide a facility for setting a
     * default response encoding.
     *
     * @param forceEncoding the force encoding
     */
    public void setForceEncoding(boolean forceEncoding)
    {
        this.forceEncoding = forceEncoding;
    }

    /**
     * Filter string.
     *
     * @param request the request
     * @param input   the input
     * @return the string
     */
    public String filter(HttpServletRequest request, String input)
    {
        String ret = input;
        // 客户端请求参数值可能为(null)服务端过滤掉当null处理即可
        if (input == null || input.trim().equals("(null)"))
        {
            ret = null;
            return ret;
        }
        final String method = request.getMethod();
        // 该处可以实现各种业务的自定义的过滤机制
        if (method.equalsIgnoreCase("get"))
        {
            try
            {
                ret = new String(input.getBytes("ISO8859-1"), this.encoding);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }else {
            try
            {
                ret = new String(input.getBytes("ISO8859-1"), this.encoding);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return ret;
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
