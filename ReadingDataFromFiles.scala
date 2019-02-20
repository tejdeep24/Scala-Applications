package Pratice

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._
case class Flight(DEST_COUNTRY_NAME:String,ORIGIN_COUNTRY_NAME:String,count:Int)
object ReadingDataFromFiles {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("PraticeSparkSql")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val FlightData = sc.textFile("/tej/FlightData.csv")
    val header = FlightData.first()
    val content = FlightData.filter(row=>row!= header)
    println("First 10 Records in Descending Order")
    val rows = content.map(_.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"))
      .map(attributes=>Flight(attributes(0),attributes(1),attributes(2).trim.toInt)).toDF()
    val first10desc = rows.orderBy($"count".desc).show(10)
    println(first10desc)
    println("First 10 Records in Ascending Order")
    val first10asc = rows.orderBy($"count".asc).show(10)
    println(first10asc)
    println("Top Five Destination Countries Using DataFrame")
    val topfive = rows.select($"DEST_COUNTRY_NAME").groupBy($"DEST_COUNTRY_NAME")
    .agg(count($"DEST_COUNTRY_NAME")).withColumnRenamed("count(DEST_COUNTRY_NAME)":String,"CT":String)
      .orderBy($"CT".desc).show(5)
    println(topfive)
    println("Top Five Destination Countries Using SQL")
    rows.registerTempTable("flight_temp")
    val topfivesql = sqlContext.sql("select DEST_COUNTRY_NAME,count(*) AS CT from " +
      "flight_temp group by DEST_COUNTRY_NAME order by CT desc").show(5)
    println(topfivesql)
    println("Distinct Destination Countries Using DataFrame")
    val distinct_ct_df = rows.select(countDistinct($"DEST_COUNTRY_NAME"))
      .withColumnRenamed("count(DEST_COUNTRY_NAME":String,"Distinct Dest Country Count":String).show()
    println(distinct_ct_df)
    println("Distinct Destination Countries Using Sql")
    val distinct_ct_sql = sqlContext.sql("select count(distinct DEST_COUNTRY_NAME) AS Distinct_Dest_Country_Count from flight_temp")
    println(distinct_ct_sql.show())

  }
}
