# Release new jar to HDFS
cd ..

sbt clean

sbt compile

sbt assembly

sbt "runMain com.avel.data.Hdfs"