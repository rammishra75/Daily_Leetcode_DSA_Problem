class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // TreeSet automatically keeps food items unique and sorted alphabetically
        TreeSet<String> foodItems = new TreeSet<>();
        // TreeSet automatically keeps tables unique and sorted numerically
        TreeSet<Integer> tables = new TreeSet<>();
        
        // Map to keep track of counts: TableNumber -> (FoodItem -> Count)
        Map<Integer, Map<String, Integer>> tableToFoodCount = new HashMap<>();

        // Single pass to collect unique items, tables, and populate counts
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            String food = order.get(2);

            foodItems.add(food);
            tables.add(tableNum);

            // Compute the inner map for the table and update the count efficiently
            tableToFoodCount.computeIfAbsent(tableNum, k -> new HashMap<>())
                             .put(food, tableToFoodCount.get(tableNum).getOrDefault(food, 0) + 1);
        }

        List<List<String>> result = new ArrayList<>();

        // Create the header row
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItems);
        result.add(header);

        // Build rows for each table
        for (int table : tables) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            
            Map<String, Integer> counts = tableToFoodCount.get(table);
            
            // For each food item in the sorted list, check if the table ordered it
            for (String food : foodItems) {
                int count = (counts != null) ? counts.getOrDefault(food, 0) : 0;
                row.add(String.valueOf(count));
            }
            result.add(row);
        }

        return result;
    }
}
