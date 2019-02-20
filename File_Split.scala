import java.io.{BufferedWriter, File, FileWriter}
import java.text.SimpleDateFormat
import java.util.Calendar
object File_Split {
  def main(args:Array[String]):Unit = {
    val INPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex10\\sample_file.txt"
    val Dir_Path = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex10\\"
    val SPLIT_SIZE = 1 // In terms of MB
    val no_of_chunks = ((io.Source.fromFile(INPUT_FILE).size/1024)/1024)/SPLIT_SIZE
    val time = Calendar.getInstance().getTime
    val date = Calendar.getInstance()
    val minuteformat = new SimpleDateFormat("mm")
    val hourformat = new SimpleDateFormat("hh")
    val secondformat = new SimpleDateFormat("ss")

    val currentDay = date.get(Calendar.DATE)
    val currentMonth = date.get(Calendar.MONTH) + 1
    val currentYear = date.get(Calendar.YEAR)
    val currentHour = hourformat.format(time)
    val currentMinute = minuteformat.format(time)
    val currentSecond = secondformat.format(time)
    println(s"${currentDay}:::${currentMonth}:::${currentYear}:::${currentHour}:::${currentMinute}:::${currentSecond}")
    val input_list = io.Source.fromFile(INPUT_FILE).getLines().toList
    val OUTPUT_DIR = new File(Dir_Path+"result_"+currentDay+"_"+currentMonth+"_"+currentYear).mkdir()
        var k =0
        for(j<- 1 to no_of_chunks)
        {
          val OUTPUT_FILE = Dir_Path+"result_"+currentDay+"_"+currentMonth+"_"+currentYear+"\\"+"result-part"+j+".txt"
          val bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))
          for(i<-0 until input_list.length if i<=k if(io.Source.fromFile(OUTPUT_FILE).size<=SPLIT_SIZE*1024*1024))
          {
                var lines = input_list(k)
                bw.write(s"${lines}\n")
                k+=1
          }
          bw.close()
        }
  }
}
