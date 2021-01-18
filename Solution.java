import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String tweet = sc.nextLine();
		String[] words=tweet.split("\\s");
		HashMap<String,Integer> hm = new HashMap<>();
		for (String word : words) {
		    if(word.charAt(0) == '#'){
		        if(!hm.containsKey(word)){
		            hm.put(word,1);
		        } else {
		            int tmp = hm.get(word);
		            hm.put(word,tmp+1);
		        }
		    }
		}
		int i = 0;
		// Could have sorted the hashtags and printed the top 10, but its T.C would have been O(nlogn).
		// So utilizing PriorityQueue, like min heap its Time complexity would be much better O(nlogk) where k=10 here.
		PriorityQueue<String> minHeap = new PriorityQueue<>();
		for (Map.Entry<String,Integer> entry : hm.entrySet()){
		    if(i<10){
		        minHeap.add(entry.getKey());
		        i++;
		        continue;
		    }
		    if(entry.getValue() >  hm.get(minHeap.peek())){
		        minHeap.poll();
		        minHeap.add(entry.getKey());
		    }
		}
		while(!minHeap.isEmpty()){
		    System.out.println(minHeap.poll());
		}
	}
}
