### Time required to serialize

| Sample size | Java     | Kryo     |
|-------------|----------|----------|
| 1           | 37 ms    | 11 ms    |
| 10          | 36 ms    | 10 ms    |
| 20          | 51 ms    | 14 ms    |
| 50          | 98 ms    | 19 ms    |
| 100         | 199 ms   | 42 ms    |
| 200         | 251 ms   | 84 ms    |
| 500         | 630 ms   | 183 ms   |
| 1000        | 1102 ms  | 355 ms   |
| 2000        | 2317 ms  | 622 ms   |
| 5000        | 6461 ms  | 1617 ms  |
| 10000       | 13681 ms | 3421 ms  |
| 20000       | 29149 ms | 6853 ms  |
| 50000       | 77921 ms | 16452 ms |

### Time required to deserialize

| Sample size | Java     | Kryo     |
|-------------|----------|----------|
| 1           | 69 ms    | 16 ms    |
| 10          | 59 ms    | 26 ms    |
| 20          | 87 ms    | 35 ms    |
| 50          | 167 ms   | 43 ms    |
| 100         | 131 ms   | 49 ms    |
| 1000        | 1054 ms  | 323 ms   |
| 2000        | 2035 ms  | 614 ms   |
| 5000        | 5160 ms  | 1542 ms  |
| 10000       | 10192 ms | 3124 ms  |
| 20000       | 20288 ms | 6173 ms  |
| 50000       | 51636 ms | 15412 ms |

### Serialized object size

| Sample size | Java          | Kryo          |
|-------------|---------------|---------------|
| 1           | 295 bytes     | 68 bytes      |
| 10          | 1195 bytes    | 670 bytes     |
| 20          | 2195 bytes    | 1341 bytes    |
| 50          | 5195 bytes    | 3349 bytes    |
| 100         | 10195 bytes   | 6695 bytes    |
| 200         | 20195 bytes   | 13392 bytes   |
| 500         | 50195 bytes   | 33474 bytes   |
| 1000        | 100195 bytes  | 66938 bytes   |
| 2000        | 200195 bytes  | 133872 bytes  |
| 5000        | 500195 bytes  | 334731 bytes  |
| 10000       | 1000195 bytes | 669394 bytes  |
| 20000       | 2000195 bytes | 1338730 bytes |
| 50000       | 5000195 bytes | 3346782 bytes |