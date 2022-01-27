/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

object GettingStartedApp {
  def main(args: Array[String]) {
    val logFile = "/workspace/test.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Getting started").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("ju")).count()
    val numBs = logData.filter(line => line.contains("st")).count()
    println(s"Lines with ju: $numAs, Lines with st: $numBs")
    spark.stop()
  }
}