import scala.collection.mutable.ListBuffer
object TruckDataAnalysis {
  case class TruckUsage(miles:Float,gas:Float,observationTime:String)
  case class RiskBean(driverId:String,truckId:String,model:String,truckUsageList:ListBuffer[TruckUsage])
  def main(args:Array[String]):Unit = {
    val TRUCK_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex9\\trucks.csv"
    var RBList:ListBuffer[RiskBean] = ListBuffer()
    for(lines<- io.Source.fromFile(TRUCK_FILE).getLines().drop(1))
      {
        var TUList:ListBuffer[TruckUsage] = ListBuffer()
        var truck_data = lines.split(",").map(_.trim)
        var driverId = truck_data(0)
        var truckId = truck_data(1)
        var model = truck_data(2)
        var truck_usage = truck_data.drop(3)
        var j =0
        for(i<-0 to truck_usage.length if (j<truck_usage.length))
          {
            var miles = truck_usage(j).toFloat
            var gas = truck_usage(j+1).toFloat
            j+=2
            var Month = "01-"
            var tu:TruckUsage = new TruckUsage(miles,gas,"Month")
            TUList+=tu
          }
        var rb:RiskBean = new RiskBean(driverId,truckId,model,TUList)
        RBList+=rb
      }
    for(i<- 0 until RBList.length )
      {
        var rb_obj = RBList(i)
        var truk_usage_list = rb_obj.truckUsageList
        for(j<-0 until truk_usage_list.length)
          {
            var tu_obj = truk_usage_list(j)
            println(s"DriverId::${rb_obj.driverId},TruckId::${rb_obj.truckId},Model::${rb_obj.model},Miles::${tu_obj.miles},Gas::${tu_obj.gas},ObservationTime::${tu_obj.observationTime}")
          }
      }
  }
}
