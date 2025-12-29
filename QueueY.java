/*
Queue :
First In First Out (FIFO)

Queue Operations :
Enque => Add => "Adding Elements" 
Deque => Remove => "Removing Element"
Front => Peek => "Seeing which element is front".
Rare => "Last element which is stored"

 It is not a good choice to use Array and implement queue
as array is fixed size. 

*/

public class QueueY {
	static class Queue {
		static int arr[];
		static int size;
		static int rare = -1;
		
		Queue(int n) {
			arr = new int[n];
			this.size = n;
		}
		
		public static boolean isEmpty() {
			return rare == -1;
		}
		
		//enqueue
		public static void add(int data) {
			if(rare == size -1) {
				System.out.println("Full Queue");
				return;
			}
			rare++;
			arr[rare] = data;
		}
		//dequeue - O(n)
		public static int remove() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			int front = arr[0];
			for(int i=0; i<rare; i++) {
				arr[i] = arr[i+1];
			}
			rare--;
			return front;
		}
		//peek
		public static int peek() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
				return -1;
			}
			
			return arr[0];
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		//1 2 3
		
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
	}
}
