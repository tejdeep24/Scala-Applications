import java.io.{BufferedWriter, FileWriter}
import scala.util.control.Breaks._
object SumOfNumbersLineWiseInAllFiles {
  def main(args:Array[String]):Unit = {
    val INPUT_FILE1 = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex2\\number1.txt"
    val INPUT_FILE2 = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex2\\number2.txt"
    val OUTPUT_FILE = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex2\\result.txt"
    val bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))
    val number2_arr = io.Source.fromFile(INPUT_FILE1).getLines().toArray
    val number1_arr = io.Source.fromFile(INPUT_FILE2).getLines().toArray
    var total_map:Map[Int,Int] = Map()
    var count_map:Map[Int,Int] = Map()
    var number_count =0;
    if(number1_arr.length<number2_arr.length)
    {
      var lineNumber=0
      for(if1_line<-number1_arr)
      {
        var total =0
        for(i<-if1_line.split(",")) total+=i.toInt
        for(j<-number2_arr(lineNumber).split(",")) total+=j.toInt
        count_map+=(lineNumber+1->(number2_arr(lineNumber).split(",").length+if1_line.split(",").length))
        total_map+=(lineNumber+1->total)
        println(s"Line${lineNumber+1}:${total}")
        bw.write(s"Line${lineNumber+1}:${total}\n")
        lineNumber+=1
      }
      var tot =0
      for(j<-number2_arr(lineNumber).split(",")) tot+=j.toInt
      count_map+=(lineNumber+1->number2_arr(lineNumber).split(",").length)
      total_map+=(lineNumber+1->tot)
      println(s"Line${lineNumber+1}:${tot}")
      bw.write(s"Line${lineNumber+1}:${tot}\n")
      bw.close()
    }
    else
    {

      var lineNumber =0
      for(if2_line<-number2_arr)
      {
        var total =0
        for(i<-if2_line.split(",")) total+=i.toInt
        for(j<-number1_arr(lineNumber).split(",")) total+=j.toInt
        count_map+=(lineNumber+1->(number1_arr(lineNumber).split(",").length+if2_line.split(",").length))
        total_map+=(lineNumber+1->total)
        println(s"Line${lineNumber+1}:${total}")
        bw.write(s"Line${lineNumber+1}:${total}\n")
        lineNumber+=1
      }
      var tot =0
      for(j<-number1_arr(lineNumber).split(",")) tot+=j.toInt
      total_map+=(lineNumber+1->tot)
      count_map+=(lineNumber+1->number1_arr(lineNumber).split(",").length)
      println(s"Line${lineNumber+1}:${tot}")
      bw.write(s"Line${lineNumber+1}:${tot}\n")
    }
    val highest_total = total_map.valuesIterator.max
    val total_key = total_map.find(_._2==highest_total).get._1
    println(s"Line${total_key}:${highest_total} holds the highest value")
    bw.write(s"Line${total_key}:${highest_total} holds the highest value\n")
    val highest_count = count_map.valuesIterator.max
    val count_key = count_map.find(_._2==highest_count).get._1
    println(s"Line${count_key}: contains ${highest_count} maximum numbers")
    bw.write(s"Line${count_key}: contains ${highest_count} maximum numbers\n")
    bw.close()
  }
}