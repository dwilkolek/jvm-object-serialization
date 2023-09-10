### Time required to serialize
| Sample size | Java     | Kryo    |
|-------------|----------|---------|
| 1           | 30 ms    | 10 ms   |
| 10          | 32 ms    | 9 ms    |
| 100         | 261 ms   | 41 ms   |
| 1000        | 1141 ms  | 304 ms  |
| 10000       | 12338 ms | 2249 ms |

### Time required to deserialize
| Sample size | Java     | Kryo    |
|-------------|----------|---------|
| 1           | 75 ms    | 15 ms   |
| 10          | 56 ms    | 20 ms   |
| 100         | 293 ms   | 73 ms   |
| 1000        | 1010 ms  | 304 ms  |
| 10000       | 10118 ms | 2899 ms |

### Serialized object size
| Sample size | Java          | Kryo         |
|-------------|---------------|--------------|
| 1           | 295 bytes     | 68 bytes     |
| 10          | 1195 bytes    | 671 bytes    |
| 100         | 10195 bytes   | 6695 bytes   |
| 1000        | 100195 bytes  | 66942 bytes  |
| 10000       | 1000195 bytes | 669357 bytes |
