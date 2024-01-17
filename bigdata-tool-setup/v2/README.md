# bigdata-tool-docker

# Standalone
To run standalone hbase:
```
docker-compose -f docker-compose-standalone.yml up -d
```
The deployment is the same as in [quickstart HBase documentation](https://hbase.apache.org/book.html#quickstart).
Can be used for testing/development, connected to Hadoop cluster.

# Local distributed
To run local distributed hbase:
```
docker-compose up -d
```

This deployment will start Hadoop, Spark, Kafka, Zookeeper, HMaster and HRegionserver in separate containers.

# Distributed
To run distributed hbase on docker swarm see this [doc](./distributed/README.md):
