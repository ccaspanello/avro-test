# avro-test

This project is designed to test the different type conversions when running on Apache Spark as well as other big data
vendors.

## avro-vanilla
This project will use `*.avsc` schema files to auto auto-generate Java classes.
These Java classes are used in the construction of Avro files.  These files
are considered to be the gold standard we expect Spark to be able to read
from.  In addition we expect Spark to output files similar to this.

## avro-spark
This project is used to read in the files created by the `avro-vanilla`
project with Spark.  The file is simply read in and then written back out
to `.avro` and `.json` files (to help visualize data that gets written).

**//TODO** Find a better way to assert the avro files than just eyeballing
it.  Currently the files are different and it is difficult to tell what
the difference is.  We also need to see if these differences are "ok".

## Vendor Support
Currently there 2 profiles available:  `APACHE` and `CDH511` these can
be run with Maven with the `-p[ProfileName]` flag.  In addition the
profile an be set in IntelliJ.  Feel free to add new profiles for other
big data vendors.