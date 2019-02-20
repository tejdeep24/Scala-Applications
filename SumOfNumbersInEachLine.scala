import java.io.{BufferedWriter, FileWriter}
object SumOfNumbersInEachLine {
  def main(args: Array[String]): Unit = {
    val INPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex1\\numbers.txt"
    val OUTPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex1\\result.txt"
    val bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))
    for(line<-io.Source.fromFile(INPUT_FILE).getLines())
    {
      var total=0
      for(i<-line.split(",")) total+=i.toInt
      println(s"${line.replaceAll(",","+")}=${total}")
      bw.write(s"${line.replaceAll(",","+")}=${total}\n")
    }
    bw.close()
  }
}