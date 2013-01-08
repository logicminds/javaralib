package biz.logicminds.remoteadmin.javaralib.client;

public class ForemanClient extends abstractRemoteClient implements remoteClientInterface {

	public ForemanClient(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFacts(String node) {
		String url = String.format("%s/", getBaseUrl());
		//rest.getForObject(url,);
		// TODO Auto-generated method stub
		return null;
	}

	public String getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGroups() {
		// TODO Auto-generated method stub
		return null;
	}


}
