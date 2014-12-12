package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci{
	
	private static final long serialVersionUID = 5400104440557706773L;

	public Fibonacci(int port) throws RemoteException
	{
		super(port);
	}
	
	public String getFibonacci(int max) throws RemoteException {
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < max; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		System.out.println(results.toString());
		return results.toString();
	}

	public List<Integer> genFib(int fibNum) throws RemoteException{
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < fibNum; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results;
	}

	public String call(String string) {
		return null;
	}

	public String add(String parameter) {
		return null;
	}
	
}