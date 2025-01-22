public class RoundRobin {
    public static void main(String[] args) {
        int[] processIds = {1, 2, 3, 4};
        int[] burstTimes = {21, 3, 6, 2};
        int timeQuantum = 5;
        int n = processIds.length;
        
        int[] remainingBurstTimes = new int[n];
        int[] completionTimes = new int[n];
        int[] turnAroundTimes = new int[n];
        int[] waitingTimes = new int[n];

        
        for (int i = 0; i < n; i++) {
            remainingBurstTimes[i] = burstTimes[i];
        }
        
        int currentTime = 0;
        boolean done;
        
        do {
            done = true;
            for (int i = 0; i < n; i++) {
                if (remainingBurstTimes[i] > 0) {
                    done = false;
                    if (remainingBurstTimes[i] > timeQuantum) {
                        currentTime += timeQuantum;
                        remainingBurstTimes[i] -= timeQuantum;
                    } else {
                        currentTime += remainingBurstTimes[i];
                        completionTimes[i] = currentTime;
                        turnAroundTimes[i] = completionTimes[i];
                        waitingTimes[i] = turnAroundTimes[i] - burstTimes[i];
                        remainingBurstTimes[i] = 0;
                    }
                }
            }
        } while (!done);
        
        
        System.out.println("Process\tBurst Time\tCompletion Time\tTurn Around Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processIds[i] + "\t\t" + burstTimes[i] + "\t\t" + completionTimes[i] + "\t\t" + turnAroundTimes[i] + "\t\t\t" + waitingTimes[i]);
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
