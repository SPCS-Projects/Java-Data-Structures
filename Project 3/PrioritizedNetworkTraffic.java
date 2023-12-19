public class PrioritizedNetworkTraffic {

	private int[] Q;
	private int head = -1;
	private int tail = 0;
	private int length;

	// Precondition: Priority queue Q is defined but not created.
	// Postcondition: Priority queue Q is created, and its size is set to "queueSize".
	// All values of Q are initialized to -1.
	// length is set to "queueSize".
	public PrioritizedNetworkTraffic(int queueSize) {
		this.Q = new int[queueSize];
		this.length = queueSize;
		for (int i = 0; i < queueSize; i++) {
			Q[i] = -1;
		}
	}


	// Precondition: Priority queue Q is existent.
	// "tail" is already set to the index of Q where a new packet may be inserted.
	// "head" is already set to the index of Q where the packet with the highest priority is stored.
	// Postcondition: A new packet with priority "newElement" is inserted in the priority queue Q.
	// "head" is set to the index of Q where the packet with the highest priority is stored.
	// "tail" is set to the next index of Q that is available for storage of a new element.
	// If Q is full, "tail" is to the index of Q where the packet with the lowest priority is stored.
	public void Enqueue(int newElement) {
		if (tail == length) {
			tail = LocateNextTail(0, length);
		}
		Q[tail] = newElement;
		if (head == -1 || newElement > Q[head]) {
			head = tail;
		}
		tail++;
		System.out.println("At Enqueue: inserted " + newElement + " in index " + (tail - 1));
	}


	// Precondition: Priority queue Q is existent.
	// "head" is already set to the index of Q where the packet with the highest priority is stored.
	// If Q is empty, "head" is -1.
	// "tail" is already set to the index of Q where a new packet may be inserted.
	// Postcondition: The packet with index equal to "head" is removed from Q and is returned to the caller.
	// -1 is inserted in its place, namely in the cell of Q where the removed packet was previously stored.
	// "head" is set to the index of Q where the packet with the highest priority is stored.
	// "tail" is set to the next index of Q that is available for storage of a new element.
	// If Q is empty, "head" is set to -1 and "tail" is set to 0.
	public int Dequeue() {
		if (head == -1) {
			return -1;
		}
		int dequeued = Q[head];
		Q[head] = -1;
		int dequeuedIndex = head;
		head = LocateNextHead(0, length);
		System.out.println("At Dequeue: removed " + dequeued + " from index " + dequeuedIndex);
		return dequeued;
	}

	// Precondition: Priority queue Q is existent.
	// "startIndex" and "endIndex" are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	// "startIndex" and "endIndex" may refer to the entire Q.
	// Postcondition: The index of Q, where the packet with the highest priority is stored, is found and is returned to the caller.
	public int LocateNextHead(int startIndex, int endIndex) {
		int maxIndex = startIndex;
		for (int i = startIndex; i < endIndex; i++) {
			if (Q[i] > Q[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	// Precondition: Priority queue Q is existent.
	// "startIndex" and "endIndex" are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	// "startIndex" and "endIndex" may refer to the entire Q.
	// Postcondition: The index of Q, where the packet with the lowest priority is stored, is found and is returned to the caller.
	public int LocateNextTail(int startIndex, int endIndex) {
		int minIndex = startIndex;
		for (int i = startIndex; i < endIndex; i++) {
			if (Q[i] < Q[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Precondition: Priority queue Q is existent.
	// Postcondition: The index and priority of each packet in Q are displayed on the monitor.
	public void DisplayPriorityQueue() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("Displaying priority queue data...");
		for (int i = 0; i < length; i++) {
			System.out.println("Index: " + i + " Packet Priority: " + Q[i]);
		}
		System.out.println("Current Head: " + head + "; Current Tail: " + tail);
		System.out.println("-------------------------------------------------------------");
	}
}