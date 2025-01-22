public class PriorityScheduling {
    public static void main(String[] args) {
        int[] processIds = {1, 2, 3, 4, 5};
        int[] burstTimes = {10, 1, 2, 1, 5};
        int[] priorities = {3, 1, 4, 5, 2};
        
        int n = processIds.length;
        int[] completionTimes = new int[n];
        int[] turnAroundTimes = new int[n];
        int[] waitingTimes = new int[n];
        
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (priorities[j] > priorities[j + 1]) {
                    
                    int tempPriority = priorities[j];
                    priorities[j] = priorities[j + 1];
                    priorities[j + 1] = tempPriority;
                    
                    
                    int tempBurst = burstTimes[j];
                    burstTimes[j] = burstTimes[j + 1];
                    burstTimes[j + 1] = tempBurst;
                    
                    
                    int tempId = processIds[j];
                    processIds[j] = processIds[j + 1];
                    processIds[j + 1] = tempId;
                }
            }
        }
        
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            currentTime += burstTimes[i];
            completionTimes[i] = currentTime;
            turnAroundTimes[i] = completionTimes[i];
            waitingTimes[i] = turnAroundTimes[i] - burstTimes[i];
        }
        
        
        System.out.println("Process\tPriority\tBurst Time\tCompletion Time\tTurn Around Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processIds[i] + "\t\t" + priorities[i] + "\t\t" + burstTimes[i] + "\t\t" + completionTimes[i] + "\t\t" + turnAroundTimes[i] + "\t\t\t" + waitingTimes[i]);
        }
        
        
        double totalTAT = 0, totalWT = 0;
        for (int i = 0; i < n; i++) {
            totalTAT += turnAroundTimes[i];
            totalWT += waitingTimes[i];
        }
        
        System.out.println("Average Turn Around Time: " + (totalTAT / n));
        System.out.println("Average Waiting Time: " + (totalWT / n));
    }
}
