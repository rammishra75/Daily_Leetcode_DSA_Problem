class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int c = x;
        if(x < 0){
            return false;
        }
        while(c > 0){
            int rem = c % 10;
            rev = (rev * 10) + rem;
            c = c / 10;
        }
        if(rev == x){
            return true;
        }
        return false;
    }
}