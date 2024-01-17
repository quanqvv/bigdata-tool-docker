
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


### install git cho spark container
vào spark-container-master để cài git và các lệnh khác (do container này dùng os debian nên hơi khác container khác dùng ubuntu) 

```console
# vào user root của spark-container-master
docker exec -u root -it spark-master-container /bin/bash  
apt update
apt install git
apt install maven
```

### test hbase
```console
docker exec -it hbase-master /bin/bash
hbase shell
create 'emp', 'personal data', 'professional data'
put 'emp','1','personal data:name','raju'
```


# How to run bigdata-project-example

### Run com.vcc.adopt.training.bigdata.spark.SparkHBase
```console
# HBase: tạo namespace person, bảng person:person_info (bảng này có namespace là person, tên bảng là person_info, namespace được dùng để tổ chức các bảng)
docker exec -it hbase-master /bin/bash
hbase shell
create_namespace 'person'
create 'person:person_info', 'cf'

# vào user root của spark-container-master
docker exec -u root -it spark-master-container /bin/bash  
cd bigdata-tool-example/bigdata-project-example
mvn package

# vào user noname của spark-container-master
docker exec -it spark-master-container /bin/bash
cd bigdata-tool-example/bigdata-project-example
bash bin/runSparkHbase.sh
```