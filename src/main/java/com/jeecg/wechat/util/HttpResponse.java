package com.jeecg.wechat.util;

import java.nio.charset.Charset;
import java.util.Vector;

/**
 * HTTP响应对象
 * 
 * @author OUWCH
 */
public class HttpResponse {

	String urlString;

	int defaultPort;

	String file;

	String host;

	String path;

	int port;

	String protocol;

	String query;

	String ref;

	String userInfo;

	String contentEncoding;

	String content;

	String contentType;

	int code;

	String message;

	String method;

	int connectTimeout;

	int readTimeout;

	Vector<String> contentCollection;

	private String defaultContentEncoding;

	public HttpResponse() {
		this.defaultContentEncoding = Charset.defaultCharset().name();
	}
	
	/**
	 * @return the defaultContentEncoding
	 */
	public String getDefaultContentEncoding() {
		return defaultContentEncoding;
	}

	/**
	 * @param defaultContentEncoding the defaultContentEncoding to set
	 */
	public void setDefaultContentEncoding(String defaultContentEncoding) {
		this.defaultContentEncoding = defaultContentEncoding;
	}

	/**
	 * @param urlString the urlString to set
	 */
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	/**
	 * @param defaultPort the defaultPort to set
	 */
	public void setDefaultPort(int defaultPort) {
		this.defaultPort = defaultPort;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @param contentEncoding the contentEncoding to set
	 */
	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @param connectTimeout the connectTimeout to set
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * @param readTimeout the readTimeout to set
	 */
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * @param contentCollection the contentCollection to set
	 */
	public void setContentCollection(Vector<String> contentCollection) {
		this.contentCollection = contentCollection;
	}

	public String getContent() {
		return content;
	}

	public String getContentType() {
		return contentType;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Vector<String> getContentCollection() {
		return contentCollection;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public String getMethod() {
		return method;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public String getUrlString() {
		return urlString;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public String getFile() {
		return file;
	}

	public String getHost() {
		return host;
	}

	public String getPath() {
		return path;
	}

	public int getPort() {
		return port;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getQuery() {
		return query;
	}

	public String getRef() {
		return ref;
	}

	public String getUserInfo() {
		return userInfo;
	}

	/**
	 * @param urlString
	 * @param defaultPort
	 * @param file
	 * @param host
	 * @param path
	 * @param port
	 * @param protocol
	 * @param query
	 * @param ref
	 * @param userInfo
	 * @param contentEncoding
	 * @param content
	 * @param contentType
	 * @param code
	 * @param message
	 * @param method
	 * @param connectTimeout
	 * @param readTimeout
	 * @param contentCollection
	 * @param defaultContentEncoding
	 */
	public HttpResponse(String urlString, int defaultPort, String file, String host, String path, int port,
			String protocol, String query, String ref, String userInfo, String contentEncoding, String content,
			String contentType, int code, String message, String method, int connectTimeout, int readTimeout,
			Vector<String> contentCollection, String defaultContentEncoding) {
		super();
		this.urlString = urlString;
		this.defaultPort = defaultPort;
		this.file = file;
		this.host = host;
		this.path = path;
		this.port = port;
		this.protocol = protocol;
		this.query = query;
		this.ref = ref;
		this.userInfo = userInfo;
		this.contentEncoding = contentEncoding;
		this.content = content;
		this.contentType = contentType;
		this.code = code;
		this.message = message;
		this.method = method;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.contentCollection = contentCollection;
		this.defaultContentEncoding = defaultContentEncoding;
	}


}
