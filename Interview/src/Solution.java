import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    
   class Trip{
		 int startDay;
		 int endDay;
		@Override
		public String toString() {
			return "Trip [startDay=" + startDay + ", endDay=" + endDay + "]";
		}
   }
	
	
   public static void main(String[] args) {
	   		Solution s=new Solution();
	   		int[] a={7,3,7,3,1,3,4,1};
	   		System.out.println(s.solution(a));
   }
    
    public int solution(int[] A) {
        int min=0;
        Map<Integer,Boolean> originalLocationMap=new HashMap<>();
        List<Integer> trips=new ArrayList<Integer>();
        for(int i=0;i<A.length;i++)
        {
        	originalLocationMap.put(A[i],false);
        }
        Map<Integer,Boolean> tempLocationMap=new HashMap<>(originalLocationMap);
        for(int i=0;i<A.length;i++)
        {
        	int startDay=i+1;
        	int endDay=i+1;;
        	
        	for(int j=i;j<A.length;j++)
        	{
        		tempLocationMap.put(A[j], true);
        		boolean allPlacesVisted=!tempLocationMap.containsValue(false);
        		if(allPlacesVisted)
        		{
        			endDay=j+1;
        			
        		}
        	}
        	tempLocationMap=new HashMap<Integer, Boolean>(originalLocationMap);
        	trips.add(startDay-endDay);
        }
        for(Integer t:trips)
        	System.out.println(t);
        Collections.sort(trips);
        return trips.get(0);
    }
}