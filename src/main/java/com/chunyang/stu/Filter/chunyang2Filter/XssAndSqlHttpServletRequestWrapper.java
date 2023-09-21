package com.chunyang.stu.Filter.chunyang2Filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Happy
 * 防止XSS攻击
 */
public class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        if (!StringUtils.isEmpty(value)) {
            value = StringEscapeUtils.escapeHtml4(value);
        }
        return value;
    }
    @Override
    public String[] getParameterValues(String name) {
        String[] parameterValues = super.getParameterValues(name);
        if (parameterValues == null) {
            return null;
        }
        for (int i = 0; i < parameterValues.length; i++) {
            String value = parameterValues[i];
            parameterValues[i] = StringEscapeUtils.escapeHtml4(value);
        }
        return parameterValues;
    }
}
