import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        func(n, k, 0, '2', ans, new StringBuilder());
        return ans;
    }

    public void func(int n, int k, int sum, char prev, List<String> ans, StringBuilder temp) {
        if (temp.length() == n) {
            // Valid strings must have a total cost <= k
            if (sum <= k) {
                ans.add(temp.toString());
            }
            return;
        }

        // The current 0-based index is exactly the current length of the string
        int currentIndex = temp.length();

        // Branch 1: Try adding '0' (Cost does not change)
        temp.append('0');
        func(n, k, sum, '0', ans, temp);
        temp.deleteCharAt(temp.length() - 1);

        // Branch 2: Try adding '1' (Only if no consecutive '1's and cost remains <= k)
        if (prev != '1' && sum + currentIndex <= k) {
            temp.append('1');
            func(n, k, sum + currentIndex, '1', ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
