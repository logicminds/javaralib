package biz.logicminds.remoteadmin.javaralib.client;

public class RemoteClientException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4723480128984100597L;

	public RemoteClientException(){
		super();
	}
	
	public RemoteClientException(String message){
		super(message);
	}
}
