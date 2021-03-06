class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }
        else{
            small.add(num);
            large.add(small.poll());
        }
        
        even=!even;
        
    }
    
    public double findMedian() {
        if(even){
            return (double)(small.peek() + large.peek())/2;
        }else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */