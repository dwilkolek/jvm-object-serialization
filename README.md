### Serialized object size
| Sample size | Java          | Kryo          |
|-------------|---------------|---------------|
| 1           | 271 bytes     | 56 bytes      |
| 10          | 1063 bytes    | 550 bytes     |
| 20          | 1943 bytes    | 1099 bytes    |
| 50          | 4583 bytes    | 2745 bytes    |
| 100         | 8983 bytes    | 5494 bytes    |
| 200         | 17783 bytes   | 10992 bytes   |
| 500         | 44183 bytes   | 27476 bytes   |
| 1000        | 88183 bytes   | 54946 bytes   |
| 2000        | 176183 bytes  | 109862 bytes  |
| 5000        | 440183 bytes  | 274671 bytes  |
| 10000       | 880183 bytes  | 549383 bytes  |
| 20000       | 1760183 bytes | 1098706 bytes |
| 50000       | 4400183 bytes | 2746732 bytes |

### Time required to serialize
| Sample size | Java     | Kryo     |
|-------------|----------|----------|
| 1           | 32 ms    | 11 ms    |
| 10          | 43 ms    | 9 ms     |
| 20          | 54 ms    | 10 ms    |
| 50          | 111 ms   | 13 ms    |
| 100         | 153 ms   | 39 ms    |
| 200         | 210 ms   | 45 ms    |
| 500         | 544 ms   | 99 ms    |
| 1000        | 1055 ms  | 191 ms   |
| 2000        | 2162 ms  | 395 ms   |
| 5000        | 5990 ms  | 1118 ms  |
| 10000       | 13020 ms | 2680 ms  |
| 20000       | 27741 ms | 5406 ms  |
| 50000       | 88367 ms | 13191 ms |

### Time required to deserialize
| Sample size | Java     | Kryo     |
|-------------|----------|----------|
| 1           | 78 ms    | 20 ms    |
| 10          | 58 ms    | 21 ms    |
| 20          | 83 ms    | 30 ms    |
| 50          | 204 ms   | 50 ms    |
| 100         | 128 ms   | 45 ms    |
| 200         | 233 ms   | 62 ms    |
| 500         | 553 ms   | 141 ms   |
| 1000        | 1066 ms  | 282 ms   |
| 2000        | 2114 ms  | 591 ms   |
| 5000        | 5310 ms  | 1525 ms  |
| 10000       | 10798 ms | 3029 ms  |
| 20000       | 21670 ms | 6240 ms  |
| 50000       | 59649 ms | 15407 ms |

