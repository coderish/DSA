# System Design:

```
1. Features/Requirements (Functional/NonFunctional)
2. Latency/Performance
3. Scalability
4. Availability
5. Durability
6. APIs
7. UML Representation (HLD/LLD)
8. Security & Privacy
9. Cost Diagram
10. Capacity Estimation
11. Discuss Tradeoffs
12. Find and discuss faults in the system
```

### Topics to consider during HLD

1. Vertical vs Horizontal Scaling
2. CAP Theorem
3. ACID [_Atomicity_, _Consistency_, _Isolation_, _Durability_] vs BASE [_Basically Available_, _Soft State_, _Eventual
   Consistency_]
4. Partitioning/Sharding Data [**Consistent Hashing**]
5. Optimistic vs Pessimistic Locks
6. Strong vs Eventual Consistency
7. Index Types in DB - HashingBased, LSM Trees and SS Tables, B-Trees 
8. Relational vs NoSql Database
9. DB Types - _Key-Value_, _Wide-Column_, _Document-Based_, _Graph-Based_
10. Caching - Cache Per Node, Distributed Caches, Cannot be the Source of Truth, Small Data and Eviction Policy
11. Data Centres/Racks/Hosts
12. CPU/Memory/HardDrives/NetworkBandwidth
13. Random vs Sequential Read/Write on Disk

```
1. HTTP vs HTTP2 vs Websockets
2. TCP/IP model
3. IPv4 vs IPv6
4. TCP/UDP
5. DNS Lookup, LAN[IP, Subnet, Gateway], Router[NAT, DMZ, Firewall, Port Forwarding], VPN
6. HTTPs(Secured HTTP) vs TLS(Transport Layer Security)
7. Cryptography - Symmetric vs Asymmetric Encryption
8. Public Key Infrastructure & Certificate Authority
9. Proxy, ReverseProxy, Load Balancer - L4 vs L7 (OSM model)
10.CDNs & Edge
11. Bloom Filters & Count-Min Sketch 
12. Paxos(P(Proposers) A(Approvers) L(Learners) Q(Quorum)), Raft - Consensus Algorithms over distributed hosts, Byzantine
13. Design Patterns, OOD(Object Oriented Design), DDD(Domain Driven Design), MDD(Model Driven Design)
14. Virtual Machines & Containers
15. Pub-Sub over Observer [Kafka(ConsumerPullRead) vs ActiveMQ/RabbitMQ(ConsumerPushRead)]
16. Map Reduce
17. Multithreading - Concurrency, locks, Synchronization, CAS(Compare and Swap) Semantics.
```

### Cache
```
1. Invalidation (TTL)
2. Cache Eviction Policy (FIFO, LRU, LFU)
3. Cache Patterns
  - Cache Aside Strategy [Server-Cache, Server-DB]
  - Read Through Strategy [Server-Cache-DB (Reads)]
  - Write Through Strategy [Server-Cache-DB (Writes)]
  - Write Around Strategy [Server-DB(Writes), Server-Cache-DB(Reads)]
  - Write Back Strategy [Server-Cache, Cache(Bulk/Batch)-DB]
```

### Scaling
```
1. Vertical Scaling - Increasing the capacity of the resources. (Moving from micro instance to large instance)
2. Horizonatal Scaling - Increasing the number of resources. (Deploying multiple application instances in different VMs)
```

### Fault and Failure
```
1. Transient Faults
2. Permanent Faults

Failsafe Mechanisms
Fault Tolerance Mechanisms
```

### CAP
```
1. Consistency
2. Availability
3. Partition Tolerance

Degrees of CAP
```

### Performance Metrics
```
1. Throughput
2. Bandwidth
3. Latency
4. Response Time
```

### Capacity Estimation
```
1. Round off Approximations
2. Power of 2's
3. Metric System: 10^6(million), 10^9(billion), 10^12(trillion)
4. Storage Capacity: 
5. Memorizing Exercise: 1 million/day = 12/sec = 700/min = 4200/hr
6. Latency Numbers
```

### Tools
```
1. Cassandra
2. MongoDB
3. MySql
4. MemCached
5. Redis
6. Zookeeper, etcd, Consul
7. Kafka
8. NGINX
9. HAProxy
10. SOLR, Elastic Search
11. Apache FluentD
```