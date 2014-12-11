package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FibService {
	private LinkedList<FibRequest> inqueue = new LinkedList<FibRequest>();
	private Map<Integer, String> outqueue = new HashMap<Integer, String>();
	
	public int add(int max){
		//generate int
		int random = (int)Math.random();
		//inqueue.addLsat(new FibRequest(martion, max));
		return random;
	}
	
	public String getResult(int jobNumber){
		if(outqueue.containsKey(jobNumber))
		{
			String result = outqueue.get(jobNumber);
			outqueue.remove(jobNumber);
			return result; //another routine from request (timer class) then process it back to the outqueue
		}
		else
		{
			return null;
		}
	}

}
