# Project 2 - Packet Timestamping and Separation

Building upon the linked list implementation from Project 1, this project addresses the timestamping and separation of packets in the NIDS. Each network packet is assigned a timestamp, dependent on the sequence number and arrival time. After timestamping, packets are inserted into stack S0. The NIDS then separates packets based on their urgency by examining each packet in stack S0. If a packet's timestamp is less than or equal to 100, it is inserted into stack S1; otherwise, it goes into stack S2. The project showcases the restructuring of data in these stacks.

## Running the Project

1. Open the project in your Java development environment.
2. Execute the `packetSelector` main method.
3. Observe the timestamping, separation, and restructuring of packets in stacks S0, S1, and S2.
