package org.example;

import org.apache.hc.core5.http.NameValuePair;

import java.util.List;

public class Request {

    private final List validPaths = List.of("/index.html", "/spring.svg", "/spring.png",
            "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html",
            "/events.html", "/events.js");
    private String method;

    private String path;
    private List<String> headers;
    private String body;

    private List<NameValuePair> params;


    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public List getValidPaths() {
        return validPaths;
    }

    public void setParams(List<NameValuePair> params) {
        this.params = params;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<NameValuePair> getQueryParams() {
        return this.params;
    }
}
