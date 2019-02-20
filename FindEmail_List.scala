import java.io.{BufferedWriter, FileWriter}

import scala.collection.mutable.ListBuffer

object FindEmail_List {

  def main(args:Array[String]):Unit={
    val email_list = List("tejdeep.pasupulati@hpe.com","tejdeep.pasupulati@dxc.com","rppasupulati@cf.com","littlemastertej@gmail.com","pasupulatitejdeep@gmail.com")
    val search_string = "pasupulati"
    val OUTPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex5\\result.txt"
    val bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))
    var email_match_list:ListBuffer[String] = ListBuffer()
    for(emails<-email_list if(emails.startsWith(search_string)))
      {
        email_match_list+=emails
        bw.write(s"${emails}\n")
      }
    bw.close()
  }
}
