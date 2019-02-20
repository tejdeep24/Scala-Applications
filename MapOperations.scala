import scala.collection.mutable.ListBuffer
object MapOperations {
  def main(args:Array[String]):Unit={
    val INPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex8\\cities.txt"
    var city_location:Map[String,ListBuffer[String]]= Map()
    val search_city="HYD"
    for(line<-io.Source.fromFile(INPUT_FILE).getLines())
    {
      var location_list:ListBuffer[String] = ListBuffer()
      var CITY_Location_pair =line.split(":")
      var City = CITY_Location_pair(0)
      for(location<-CITY_Location_pair(1).split(",")) location_list+=location
      city_location+=(City->location_list)
    }
    println(s"${city_location}")
    city_location.get(search_city).get.foreach(println)
  }
}