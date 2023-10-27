# JVM object serialization

The project was created to explore JVM serialization options.

## Why?!

Some REST service was slow, especially with large objects. Most of the responses is being cached as byte array.
I've heard that Java serialization is quite slow, so I decided to explore other serialization options.

## Conclusion

Long story short using Java serialization is the slowest *but was not the biggest issue in my case*. Sending large JSONs
between services was.
Even tho Kryo seems to be the best, it would be better if that service used gRPC.

## Requirements

- Installed [protoc](https://grpc.io/docs/protoc-installation/) with include package
- JDK 17

## Running

- `/gradlew build`
- `java -jar build/libs/jvm-object-serialization-1.0-SNAPSHOT.jar`

Or  `./gradlew bootRun`

### Time required to serialize

| Sample size | Java     | Kryo    | gRPC    |
|-------------|----------|---------|---------|
| 1           | 8 ms     | 4 ms    | 4 ms    |
| 10          | 20 ms    | 3 ms    | 6 ms    |
| 100         | 215 ms   | 25 ms   | 61 ms   |
| 1000        | 2017 ms  | 267 ms  | 601 ms  |
| 10000       | 22567 ms | 2481 ms | 6126 ms |

### Time required to deserialize

| Sample size | Java    | Kryo    | gRPC    |
|-------------|---------|---------|---------|
| 1           | 17 ms   | 6 ms    | 5 ms    |
| 10          | 17 ms   | 5 ms    | 3 ms    |
| 100         | 91 ms   | 50 ms   | 25 ms   |
| 1000        | 749 ms  | 492 ms  | 248 ms  |
| 10000       | 7563 ms | 4696 ms | 2411 ms |

### Serialized object size

| Sample size | Java          | Kryo         | gRPC         |
|-------------|---------------|--------------|--------------|
| 1           | 295 bytes     | 68 bytes     | 75 bytes     |
| 10          | 1195 bytes    | 670 bytes    | 737 bytes    |
| 100         | 10195 bytes   | 6696 bytes   | 7471 bytes   |
| 1000        | 100195 bytes  | 66935 bytes  | 74533 bytes  |
| 10000       | 1000195 bytes | 669407 bytes | 744334 bytes |

