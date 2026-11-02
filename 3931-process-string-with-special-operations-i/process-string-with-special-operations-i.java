class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                str.append(c);
            }
            else if(c == '*' && str.length() > 0){
                str.deleteCharAt(str.length() - 1);
            }
            else if(c == '#'){
                str.append(str);
            }
            else{
                str.reverse();
            }
        }
        return str.toString();
    }
}