package biz.logicminds.remoteadmin.javaralib.client;

import java.util.Collections;

import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public abstract class abstractRemoteClient implements remoteClientInterface {

	protected RestTemplate rest = null;
	private HttpHeaders headers = null;
	private String baseurl;
	private boolean isSecure = false;
	
	public abstractRemoteClient(String url) {
		isSecure = url.startsWith("https");
		rest = createClient();
		headers = getHeaders();
		
		// url should be https://hostname:port/
		if (!baseurl.endsWith("/")){
			baseurl = baseurl.concat("/");
		}
		baseurl = url;
		initHeaders();
	}
	
	public String getBaseUrl(){
		return baseurl;
	}
	
	public void setTimeout(int seconds){
		// TODO set the timeout for the httpclient
		
	}
	
	public HttpHeaders getHeaders(){
		if (headers == null){
			 headers = new HttpHeaders();
		}
		return headers;
	}
	
	public void setAuthentication(String username, String password){
		// Set the username and password for creating a Basic Auth request
		HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
		getHeaders().setAuthorization(authHeader);
	}

	public RestTemplate createClient() {
		//MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		//List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		//messageConverters.add(messageConverter);
		//client.setMessageConverters(messageConverters);
		RestTemplate client = new RestTemplate();
		rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return client;
	}

	public void setAcceptHeader(String accept) throws RemoteClientException{
		String[] type = accept.split("/");
		if (type.length < 2){
			throw new RemoteClientException("accept parameter not valid");
		}
		getHeaders().setAccept(Collections.singletonList(new MediaType(
				type[0], type[1])));
	}
	
	public void setAcceptEncoding(ContentCodingType type){
		getHeaders().setAcceptEncoding(type);
	}
	
	public void initHeaders() {
		try {
			setAcceptHeader("application/json");
		} catch (RemoteClientException e) {
			System.out.println(e.getMessage());
		}
		setAcceptEncoding(ContentCodingType.GZIP);
				
	}
	
	abstract public String getFacts(String node);
		
	

	

}
