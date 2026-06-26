package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SqlInjectionFilter implements Filter {

    private static final Pattern SQL_PATTERN =
            Pattern.compile(
                    "(?i)(select|insert|update|delete|drop|union|or\\s+1=1|--)");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {

            String paramName = params.nextElement();
            String value = req.getParameter(paramName);

            if (value != null &&
                    SQL_PATTERN.matcher(value).find()) {

                System.out.println(
                        "[SECURITY] SQL Injection detected: "
                                + paramName + "=" + value);

                resp.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "SQL Injection detected");

                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}