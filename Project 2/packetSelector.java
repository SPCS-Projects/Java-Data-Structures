public class packetSelector {

	public static StackWork packets;

	public static void main(String[] args) {
		System.out.println("Packet selector is now running...\n");
		packets = new StackWork(10, 10, 10);

		packets.Push(95, 0);
		packets.Push(103, 0);
		packets.Push(81, 0);
		packets.Push(120, 0);
		packets.Push(74, 0);
		packets.Push(134, 0);
		packets.Push(62, 0);
		packets.Push(101, 0);
		packets.Push(59, 0);
		packets.Push(148, 0);

		packets.displayStackData();

		reorganizeNetworkTraffic();

		packets.displayStackData();
	}

	public static void reorganizeNetworkTraffic()
	{
		while (packets.getS0top() >= 0) {
			int timestamp = packets.Pop(0);
			if (timestamp <= 100) {
				packets.Push(timestamp, 1);
			} else {
				packets.Push(timestamp, 2);
			}
		}
	}
}