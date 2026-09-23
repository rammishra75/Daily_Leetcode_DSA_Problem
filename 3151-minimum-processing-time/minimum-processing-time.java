import java.util.Collections;
import java.util.List;

class Solution {
    public int minProcessingTime(List<Integer> processorTimes, List<Integer> taskTimes) {
        // Sort processorTimes in ascending order
        Collections.sort(processorTimes);
        
        // Sort taskTimes in descending order
        Collections.sort(taskTimes, Collections.reverseOrder());
        
        int processorIndex = 0, answer = 0;
        
        for (int processingTime : processorTimes) {
            int currentMax = 0, taskCount = 0;
            
            while (processorIndex < taskTimes.size() && taskCount < 4) {
                currentMax = Math.max(currentMax, processingTime + taskTimes.get(processorIndex));
                processorIndex++;
                taskCount++;
            }
            
            answer = Math.max(answer, currentMax);
        }
        
        return answer;
    }
}