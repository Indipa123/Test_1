class FCFS{
	public static void main(String[]args){
		int[]process={1,2,3,4};
		int[]Burst={21,3,6,2};
		int[]completion=new int[4];
		int[]turnaround=new int[4];
		int[]wait=new int[4];
		
		int current=0;
		for(int i=0;i<4;i++){
			current+=Burst[i];
			completion[i]=current;
		}
		int turn=0;
		for(int i=0;i<4;i++){
			
			turn+=Burst[i];
			turnaround[i]=turn;
		}
		
		for(int i=0;i<4;i++){
			wait[i]=completion[i]-Burst[i];
		}
		
		System.out.println("process\tBurst\tCompletion time\tTurn Around Time\twaiting");
		
		for(int i=0;i<4;i++){
		System.out.println(process[i]+"\t"+Burst[i]+"\t"+completion[i]+"\t\t"+turnaround[i]+"\t\t\t"+wait[i]);
		}
	}
}