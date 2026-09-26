class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> food = new ArrayList<>();
        List<Integer> table = new ArrayList<>(); 
        for(List<String> s : orders){
            if(!food.contains(s.get(2))) food.add(s.get(2));
            if(!table.contains(Integer.parseInt(s.get(1)))) table.add(Integer.parseInt(s.get(1)));
        }
        Collections.sort(food);
        Collections.sort(table);
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("Table");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < food.size(); i++){
            temp.add(food.get(i));
            map.put(food.get(i), i);
        }
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < table.size(); i++){
            index.put(table.get(i), i);
        }
        int[][] freq = new int[table.size()][temp.size() - 1];
        ans.add(temp);
        for(List<String> s : orders){
            int ind = index.get(Integer.parseInt(s.get(1)));
            int dish_ind = map.get(s.get(2));
            freq[ind][dish_ind]++;
        }
        for(int i = 0; i < table.size(); i++){
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(table.get(i)));
            for(int j = 0; j < temp.size() - 1; j++){
                row.add(Integer.toString(freq[i][j]));
            }
            ans.add(row);
        }
        return ans;
    }
}