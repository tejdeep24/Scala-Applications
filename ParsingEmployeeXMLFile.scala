import java.io.{BufferedWriter, FileWriter}
object ParsingEmployeeXMLFile {
  case class
  Employee(EmpId:Int,EmpName:String,EmpSal:Float,EmpDob:String,EmpEmail:String,EmpHomePhone:Long,EmpOfficePhone:Long)
  def main(args:Array[String]):Unit = {
    val INPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex3\\employee.xml"
    val bw = new BufferedWriter(new FileWriter("C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex3\\result.txt"))
    val empfile = scala.xml.XML.loadFile(INPUT_FILE)
    var emp = new Array[Employee]((empfile\\"employee").length)
    var object_count =0
    var emp_count =1
    for(employee<-empfile\\"employee")
    {
      var empid = (employee\\"empId").text.toInt
      var empname = (employee\\"empName").text
      var empsalary = (employee\\"empSalary").text.toFloat
      var empdob = (employee\\"empDOB").text
      var empemail = (employee\\"empEmail").text
      val phones = (employee\\"phone").map(value=>(value\\"@type",value.text))
      var emphomephone = phones(0)._2.toLong
      var empofficephone = phones(1)._2.toLong
      emp(object_count)= new Employee(empid,empname,empsalary,empdob,empemail,emphomephone,empofficephone)
      object_count+=1
    }
    for(e<-emp)
    {
      println("--------------------")
      println(s"Employee${emp_count}")
      println("--------------------")
      println(s"Employee Id:${e.EmpId}")
      println(s"Employee Name:${e.EmpName}")
      println(s"Employee Salary:${e.EmpSal}")
      println(s"Employee DOB:${e.EmpDob}")
      println(s"Employee Email:${e.EmpEmail}")
      println(s"Employee Home Phone:${e.EmpHomePhone}")
      println(s"Employee Office Phone:${e.EmpOfficePhone}")
      bw.write("--------------------\n")
      bw.write(s"Employee${emp_count}\n")
      bw.write("--------------------\n")
      bw.write(s"Employee Id:${e.EmpId}\n")
      bw.write(s"Employee Name:${e.EmpName}\n")
      bw.write(s"Employee Salary:${e.EmpSal}\n")
      bw.write(s"Employee DOB:${e.EmpDob}\n")
      bw.write(s"Employee Email:${e.EmpEmail}\n")
      bw.write(s"Employee Home Phone:${e.EmpHomePhone}\n")
      bw.write(s"Employee Office Phone:${e.EmpOfficePhone}\n")
      emp_count+=1
    }
    bw.close()
  }
}
