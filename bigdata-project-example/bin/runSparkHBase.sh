spark-submit \
  --master yarn \
  --deploy-mode client \
  --driver-memory 2G \
  --executor-memory 2G \
  --executor-cores 1 \
  --num-executors 2 \
  --conf spark.kryoserializer.buffer.max=1g \
  --conf spark.executor.memoryOverhead=512 \
  --conf spark.port.maxRetries=40 \
  --conf spark.sql.parquet.binaryAsString=true \
  --class com.vcc.adopt.training.bigdata.spark.SparkHBase \
   target/spark-hbase-example-1.0-SNAPSHOT.jar

