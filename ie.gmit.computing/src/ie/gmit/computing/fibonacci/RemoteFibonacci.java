package ie.gmit.computing.fibonacci;

import java.rmi.*;

public interface RemoteFibonacci extends Remote{
	public String getFibonacci();
}