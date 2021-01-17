$SPARK_HOME/bin/spark-submit \
  --class com.avel.data.Runner \
  --master spark://alpha.avel.local:7077 \
  --deploy-mode cluster \
  hdfs://delta.avel.local:9000/artifacts/bck-transform.jar \