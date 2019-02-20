import java.io.{BufferedWriter, File, FileWriter}

object Collection_FileHandling {

  def main(args:Array[String]):Unit={
    val INPUT_DIR = "C:\\Users\\pasupult\\Project\\dataset\\scala_sol\\ex4\\emails\\input"
    val d = new File(INPUT_DIR)
    val File_List = d.listFiles.filter(_.isFile).toList
    var Email_Set:Set[String] = Set()
    val Split_Size = 10
    for(i<-0 until File_List.length)
      {
        for(line<-io.Source.fromFile(File_List(i)).getLines()) Email_Set+=line
      }
    print(Collection_Operations.l)

  }

}
