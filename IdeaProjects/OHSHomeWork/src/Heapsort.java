import java.util.ArrayList;

public class Heapsort {
    public static void main(String[] args){
        FIFO f = new FIFO();
        RR rr = new RR();
        SJF sjf = new SJF();

        f.startProcessing();
        sjf.startProcessing();
        for(int i = 0;i<15;i++) {
            rr.startProcessing();
            rr.timeSlice+=5;
        }
    }
}

class PriorityHeap {
    ArrayList<Integer> list;

    public PriorityHeap(ArrayList<Integer> items) {

        this.list = items;
        buildHeap();
    }

    public void buildHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public int extractMin() {

        if (list.size() == 1) {

            int min = list.remove(0);
            return min;
        }

        int min = list.get(0);
        int lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        minHeapify(0);

        return min;
    }

    public void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = -1;

        if (left <= list.size() - 1 && list.get(left) < list.get(i)) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right) < list.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public void swap(int i, int parent) {
        int temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }
}

class Job{
    int pTime;
    int id;

    public Job(int id){
        pTime = (int)(Math.random()*100);
        this.id = id;
    }
}

class FIFO{
    ArrayList<Job> queue;

    public FIFO(){
        queue = new ArrayList<>();
    }

    public void startProcessing(){
        int sum = 0;
        int waitingTime = 0;
        genJobs();

        for(int i = 0; i<queue.size();i++){
            sum += (queue.get(i).pTime+waitingTime);
            waitingTime += queue.get(i).pTime;
        }
        System.out.println("Average turnaround time for FIFO is " + (sum)/100);
    }

    public void genJobs(){
        queue.clear();
        for(int i = 0;i<100;i++){
            queue.add(new Job(i+1));
        }
    }
}

class SJF{
    ArrayList<Integer> queue;
    PriorityHeap heap;
    public SJF(){
        queue = new ArrayList<>();
        genJobs();
        heap = new PriorityHeap(queue);
        heap.buildHeap();
    }

    public void startProcessing(){
        int waitTime = 0;
        int sum = 0;

        for(int i = 0; i<100;i++){
            int time = heap.extractMin();
            sum+=time+waitTime;
            waitTime+=time;
        }
        System.out.println("Average turnaround time for SJF is " + (sum/100));
    }

    public void genJobs(){
        queue.clear();
        for(int i = 0;i<100;i++){
            queue.add((int)(Math.random()*100));
        }
    }
}

class RR{
    int timeSlice = 20;
    ArrayList<Job> queue;

    public RR(){
        queue = new ArrayList<>();
    }

    public void startProcessing(){
        int waitTime = 0;
        int sum = 0;
        genJobs();

        for(int i = 0; i<queue.size();i++){
            if(queue.get(i).pTime > timeSlice){
                Job add = new Job(i+1);
                add.pTime = queue.get(i).pTime-timeSlice;
                queue.add(add);
                waitTime+=timeSlice;
            }else{
                sum+=(waitTime+queue.get(i).pTime);
                waitTime+=queue.get(i).pTime;
            }
        }
        System.out.println("Average turnaround time for RR with time slice " + timeSlice + " is " + (sum/100));
    }

    public void genJobs(){
        queue.clear();
        for(int i = 0;i<100;i++){
            queue.add(new Job(i+1));
        }
    }
}


