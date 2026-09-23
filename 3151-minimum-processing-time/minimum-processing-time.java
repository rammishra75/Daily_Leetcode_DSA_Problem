class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime, Collections.reverseOrder());
        Collections.sort(tasks);
        int max = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            max = Math.max(max,
                    processorTime.get(i) + tasks.get(i * 4 + 3));
        }

        return max;
    }
}