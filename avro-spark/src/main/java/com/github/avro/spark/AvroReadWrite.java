package com.github.avro.spark;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

/**
 * Created by ccaspanello on 1/17/18.
 */
public class AvroReadWrite {

  private final String AVRO_COMPRESSION_CODEC = "spark.sql.avro.compression.codec";
  private SparkContext sc;

  public AvroReadWrite( SparkContext sc ) {
    this.sc = sc;
  }

  public void execute( String input, String output, String output2 ) {
    SparkSession session = new SparkSession( sc );
    session.sqlContext().setConf( AVRO_COMPRESSION_CODEC, "uncompressed" );
    Dataset<Row> data = session
      .read().format( "com.databricks.spark.avro" ).load( input );
    data.write().format( "com.databricks.spark.avro" ).mode( SaveMode.Overwrite ).save( output );
    data.write().mode( SaveMode.Overwrite ).json( output2 );
  }
}
