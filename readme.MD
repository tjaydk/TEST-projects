### Results

**NOTICE:** _Depth 4 and 5, caused a memory overflow with Neo4j on our Virtual Machine even with 12 gigabytes of distributed RAM. For that reason, we have left these queries out of the program._

```
MySQL - Junko Heiny: 524 ms
MySQL - Endorsements (Depth 1): 233 ms
MySQL - Endorsements (Depth 2): 347 ms
MySQL - Endorsements (Depth 3): 5870 ms

Neo4j - Junko Heiny: 1653 ms
Neo4j - Endorsements (Depth 1): 622 ms
Neo4j - Endorsements (Depth 2): 2635 ms
Neo4j - Endorsements (Depth 3): 66881 ms
```
