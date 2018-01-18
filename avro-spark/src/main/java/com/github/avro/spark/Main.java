package com.github.avro.spark;

import org.apache.spark.SparkContext;

/**
 * Created by ccaspanello on 1/17/18.
 */
public class Main {

  public static void main(String[] args){
    SparkContext sparkContext = SparkContext.getOrCreate();
    SparkPi sparkPi = new SparkPi(sparkContext );
    sparkPi.run( 10 );
  }

}
