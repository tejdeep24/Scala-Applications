import scala.collection.mutable.{ListBuffer}
object Collection_Operations {
  case class Employee(empId:Int,empName:String,deptNo:String,empSalary:Float,doj:String)
  var l =1
  def main(args:Array[String]):Unit={
    val INPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex7\\employee.txt"
    var emp = new Array[Employee](io.Source.fromFile(INPUT_FILE).getLines().size)
    var object_count = 0
    var dept_wise_empdetails:Map[String,ListBuffer[Employee]] = Map()
    var empdept_set:Set[String]=Set()
    for(line<-io.Source.fromFile(INPUT_FILE).getLines())
    {
      var empdetails = line.split(",")
      emp(object_count)=
        new Employee(empdetails(0).toInt,empdetails(1),empdetails(2),empdetails(3).toFloat,empdetails(4))
      empdept_set+=empdetails(2)
      object_count+=1
    }
    for(deptno<-empdept_set)
    {
      var empList:ListBuffer[Employee]=ListBuffer()
      for(employee<-emp)
      {
        if(employee.deptNo.contentEquals(deptno)) empList += employee
      }
      dept_wise_empdetails+=(deptno->empList.sortWith(_.empSalary < _.empSalary))
    }
    println(s"${dept_wise_empdetails}")

  }
}