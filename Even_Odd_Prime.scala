import scala.collection.mutable.ListBuffer

object Even_Odd_Prime {

  def main(args:Array[String]):Unit = {
    val numbers = (1 to 50).toList
    val even_list:ListBuffer[Int]= ListBuffer()
    val odd_list:ListBuffer[Int]= ListBuffer()
    val prime_list:ListBuffer[Int] = ListBuffer()
    var compute:Map[String,ListBuffer[Int]]= Map()
    for(i<-0 until numbers.length)
      {
          if(numbers(i)%2==0) even_list+=numbers(i)
          if(numbers(i)%2!=0) odd_list+=numbers(i)
        var count =0
          for(j<-1 to numbers(i)if(numbers(i)%j==0)) count+=1
           if(count==2) prime_list+=numbers(i)
      }
    compute+=("Even"->even_list)
    compute+=("Odd"->odd_list)
    compute+=("Prime"->prime_list)
  }
}
