package ie.gmit;

import java.rmi.*;

public interface RemoteFibonacci extends Remote{
	public String getFibonacci(int max) throws RemoteException;
}