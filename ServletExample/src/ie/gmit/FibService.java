package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class FibService {
	private LinkedList <FibRequest> inqueue = new LinkedList<FibRequest>();
	private Map <Integer, String> outqueue = new HashMap<Integer, String>();
	
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
	public int add(int max){
		Random random = new Random(System.currentTimeMillis());
		int number = ((random.nextInt(199)+1));
		inqueue.add(new FibRequest(number, max));
		return number;
	}
	
	public String add(String parameter) {
		return null;
	}

}
