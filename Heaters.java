class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int radius = 0;
        
        for(int i=0; i<houses.length; i++){
            int loc = Arrays.binarySearch(heaters, houses[i]); //Search for heater
            if(loc == 0) continue; //Found heater in current home. No updates to Radius
            if(loc < 0){
                loc = -(loc + 1); //Fetch insertion point

                int leftDist = (loc==0) ? Integer.MAX_VALUE : houses[i] - heaters[loc-1];
                int rightDist = (loc > heaters.length-1) ? Integer.MAX_VALUE : heaters[loc] - houses[i];
                int curRad = Math.min(leftDist, rightDist);
                
                radius = Math.max(curRad, radius);
            }
        }
        
        return radius;
    }
}
