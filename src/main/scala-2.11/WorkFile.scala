import java.io._
import java.util.zip._

import scala.collection.mutable.ListBuffer

//Map[String, String] =

object WorkFile {
  def readFileFormatGz(fileName: String): Map[String, ListBuffer[String]] = {
    val in: InputStream = new GZIPInputStream(new FileInputStream(fileName))
    val reader = scala.io.Source.fromInputStream(in).getLines()
    // val mapData: Map[String,List[String]]=null
    val header = reader.next.split(",").map(_.trim)

    var y0 = new ListBuffer[String]()
    var y1 = new ListBuffer[String]()
    var y2 = new ListBuffer[String]()
    var y3 = new ListBuffer[String]()
    var y4 = new ListBuffer[String]()
    var y5 = new ListBuffer[String]()
    var y6 = new ListBuffer[String]()
    var y7 = new ListBuffer[String]()


    while (reader.hasNext) {
      var row = reader.next
      var column = row.split(",")
      y0 += (column(0))
      y1 += (column(1))
      y2 += (column(2))
      y3 += (column(3))
      y4 += (column(4))
      y5 += (column(5))
      y6 += (column(6))
      y7 += (column(7))
      //ms ++= kvs	Adds all mappings in kvs to ms as a side effect and returns ms itself.
    }

    //"YEAR","QUARTER","MONTH","DAY_OF_MONTH","DAY_OF_WEEK","FL_DATE","ORIGIN","DEST"
    val res = Map("YEAR" -> y0, "QUARTER" -> y1, "MONTH" -> y2,
      "DAY_OF_MONTH" -> y3, "DAY_OF_WEEK" -> y4, "FL_DATE" -> y5, "ORIGIN" -> y6, "DEST" -> y7)
    return res

  }

  def countForLastColumnTable(temp: Map[String, ListBuffer[String]]): Unit = {
    var destList:ListBuffer[String]=temp("DEST")
    val dast:List[String]=destList.toList

    println(countRepeatedValues(dast))
  }



  def countRepeatedValues(letters: List[String]): Map[String, Int] = {
    var map = Map[String, Int]()
    for(letter <- letters) map += Pair(letter, map.getOrElse(letter, 0) + 1)
    map
  }

}

