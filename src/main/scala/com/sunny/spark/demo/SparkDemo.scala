package com.sunny.spark.demo

/**
 * Created by Sunny Malik.
 */

import org.apache.spark.SparkContext

object SparkDemo {
  def main(args: Array[String]) {
    val logFile = "/Volumes/workspace/sunny/files/README.md" // Should be some file on your system

    // to run in local mode
    val sc = new SparkContext("local", "Simple App", "/Volumes/workspace/sunny/spark1.2")

    // to run on cluster
    /*
      val sc = new SparkContext("spark://yourhostname:7077", // CHANGE to the hostname in your Spark web UI.
      "Simple App",
      "/path/to/spark-0.9.1-bin-hadoop1/", // CHANGE to reflect the correct path on your installation
      List("target/scala-2.10/spark-simple-app_2.10-1.0.jar"))
    */

    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()


    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))

  }
}

