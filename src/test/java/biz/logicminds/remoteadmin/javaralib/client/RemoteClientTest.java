package biz.logicminds.remoteadmin.javaralib.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.http.ContentCodingType;
import org.springframework.web.client.RestTemplate;

public class RemoteClientTest {

	private String url = "https://localhost:3000";

	@InjectMocks
	private RemoteClient mockClient = Mockito.spy(new RemoteClient(url));

	@Before
	public void setup() throws Exception {

	}

	@Test
	public void testAbstractRemoteClient() {
		RemoteClient client = Mockito.spy(new RemoteClient(url));
		Mockito.verify(client.createClient());
		assertNotNull(client);
	}

	@Test
	public void testGetBaseUrl() {
		assertEquals(url, mockClient.getBaseUrl());
	}

	@Test
	public void testSetTimeout() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeaders() {
		assertNotNull(mockClient.getHeaders());
	}

	@Test
	public void testSetAuthentication() {
		mockClient.setAuthentication("testuser", "password");
		String header = mockClient.getHeaders().getAuthorization();
		assertNotNull(header);

	}

	@Test
	public void testCreateClient() {
		RestTemplate rest = mockClient.createClient();
		assertNotNull(rest);

	}

	@Test
	public void testSetAcceptHeader() throws RemoteClientException {
		int before = mockClient.getHeaders().size();
		mockClient.setAcceptHeader("application/json");
		int after = mockClient.getHeaders().size();
		assertTrue(after > before);

	}

	@Test(expected = RemoteClientException.class)
	public void testSetAcceptHeaderException() throws RemoteClientException {
		int before = mockClient.getHeaders().size();
		mockClient.setAcceptHeader("application\\json");
		int after = mockClient.getHeaders().size();
		assertTrue(after > before);
	}

	@Test
	public void testSetAcceptEncoding() {
		int before = mockClient.getHeaders().size();
		mockClient.setAcceptEncoding(ContentCodingType.GZIP);
		int after = mockClient.getHeaders().size();
		assertTrue(after > before);
	}

}
