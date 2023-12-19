# Project 1 - Linked List Packet Organization

This project introduces the fundamental concepts of using linked lists to organize network packets within a Network Intrusion Detection System (NIDS). The primary goal is to maintain the ascending order of packets based on TCP sequence numbers. When a new packet arrives, it is seamlessly inserted into the linked list while preserving the order. The NIDS handles scenarios where a packet with the same sequence number exists by appropriately revising and reinserting the new packet. The code includes the implementation of the `IntNode` class, providing the foundation for subsequent projects.

## Running the Project

1. Open the project in your Java development environment.
2. Execute the `IntrusionDetectorClass` main method.
3. Observe the insertion of new packets and the maintenance of ascending order.
