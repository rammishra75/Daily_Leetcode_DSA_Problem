class AuthenticationManager {
    HashMap<String, Integer> mpp;
    int time;

    public AuthenticationManager(int timeToLive) {
        mpp = new HashMap<>();
        time = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        mpp.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (mpp.containsKey(tokenId) && mpp.get(tokenId) + time > currentTime) {
            mpp.put(tokenId, currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        mpp.entrySet().removeIf(entry -> entry.getValue() + time <= currentTime);
        return mpp.size();
    }
}


/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */