
# Setup bigdata tool:

### setup
```console
install bigdata tool
git clone https://github.com/quanqvv/bigdata-tool-docker
cd bigdata-tool-docker
docker-compose up -d
```

### create a csv file and upload file to hdfs
```console
docker exec -it nodemanager /bin/bash
echo -e "col1,col2\na,b" >> test.csv
hadoop fs -put test.csv /
```

### test spark job: read above csv file
```console
docker exec -it bigdata-tool-docker_spark_1 /bin/bash
spark-shell --master spark://spark:7077
```


### spark-shell example
```scala
val df = spark.read.option("header", "true").csv("hdfs://namenode:9000/test.csv")
df.show()
df.count()
```


### Install git cho spark container
vào spark-container-master để cài git và các lệnh khác (do container này dùng os debian nên hơi khác container khác dùng ubuntu) 

```console
# vào user root của spark-container-master
docker exec -u root -it spark-master-container /bin/bash  
apt update
apt install git
apt install maven
```

