/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int helper(Employee e,Map<Integer,Employee> map ){
        int sum=e.importance;
        for(int subId : e.subordinates){
            sum+= helper(map.get(subId),map);
        }
        return sum;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        return helper(map.get(id),map);
        
    }
}