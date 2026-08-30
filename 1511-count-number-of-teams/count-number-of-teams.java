class Solution {
    public int numTeams(int[] rating) {
        int cnt = 0;
        int n = rating.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(rating[i] < rating[j] && rating[j] < rating[k]){
                        cnt++;
                    }
                    if(rating[i] > rating[j] && rating[j] > rating[k]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}