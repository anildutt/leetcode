public class NFLGame {
	public static void main(String[] args) {
		String s = findContestMatch(5);
		System.out.println(s);
	}
	
	public static String findContestMatch(int n) {
		List<String> list = new ArrayList<String>();
		for(int i=0; i<n; i++)
			list.add(String.valueOf(i+1));
		
		while(list.size() > 1){
			List<String> tmpList = new ArrayList<String>();
			while(list.size() > 0){
				if(list.size() == 1) tmpList.add(list.remove(0));
				else{
					String beg = list.remove(0);
					String end = list.remove(list.size() - 1);
					tmpList.add("(" + beg + "," + end + ")");
				}
			}
			
			list = tmpList;
		}
		
		return list.get(0);
	}
}
