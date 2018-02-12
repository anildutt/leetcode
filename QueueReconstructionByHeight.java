class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;
        
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2){
                if(pair1[0] != pair2[0]) return pair2[0] - pair1[0];
                else return pair1[1] - pair2[1];
            }
        });
        
        //Step1: Pick the max height ones
        List<Integer[]> result = new LinkedList<Integer[]>();
        int max = people[0][0], i = 0;
        for(i=0; i<people.length && people[i][0] == max; i++)
            result.add(new Integer[]{people[i][0], people[i][1]});
        
        //Insert remaining ones into list back
        for(int j=i; j<people.length; j++)
            result.add(people[j][1], new Integer[]{people[j][0], people[j][1]});
        
        //Convert back to array
        for(i=0; i<result.size(); i++){
            people[i][0] = result.get(i)[0];
            people[i][1] = result.get(i)[1];
        }
        
        return people;
    }
}
