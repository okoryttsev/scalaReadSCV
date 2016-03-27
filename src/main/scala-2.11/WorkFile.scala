import java.io._
import java.util.zip._

import scala.collection.mutable.ListBuffer

//Map[String, String] =

object WorkFile {
  def readFileFormatGz(fileName: String): Map[String, ListBuffer[String]] = {
    val in: InputStream = new GZIPInputStream(new FileInputStream(fileName))
    val reader = scala.io.Source.fromInputStream(in).getLines()

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

    }

    //"YEAR","QUARTER","MONTH","DAY_OF_MONTH","DAY_OF_WEEK","FL_DATE","ORIGIN","DEST"
    val res = Map("YEAR" -> y0, "QUARTER" -> y1, "MONTH" -> y2,
      "DAY_OF_MONTH" -> y3, "DAY_OF_WEEK" -> y4, "FL_DATE" -> y5, "ORIGIN" -> y6, "DEST" -> y7)
    return res

  }

  def countForLastColumnTable(temp: Map[String, ListBuffer[String]]): Map[String, Int] = {
    var destList: ListBuffer[String] = temp("DEST")
    val dast: List[String] = destList.toList
    countRepeatedValues(dast)
  }

  def countDiffBetweenColuns(temp: Map[String, ListBuffer[String]]): Map[String, Int] = {
    var destList: ListBuffer[String] = temp("DEST")
    var originList: ListBuffer[String] = temp("ORIGIN")
    var resDest = countRepeatedValues(destList.toList)
    var resOrigin = countRepeatedValues(originList.toList)
    countTheDifference(resDest, resOrigin)

  }

  def countTheDifference(first: Map[String, Int], second: Map[String, Int]): Map[String, Int] = {
    var keySet = first.keys
    var sum: Int = 0
    var resmap: Map[String, Int] = Map[String,Int]()
    for (k <- keySet) {
      sum = first(k) - second(k)
      if (sum != 0) {
        resmap += (k -> sum)
      }
    }
    resmap
  }


  def countRepeatedValues(letters: List[String]): Map[String, Int] = {
    var map = Map[String, Int]()
    for (letter <- letters) map += Pair(letter, map.getOrElse(letter, 0) + 1)
    map
  }


  def writeResultIntoFile(temp: Map[String, Int], fileName: String) {
    val out = new FileWriter("./src/main/resources/resultFiles/" + fileName + ".csv")


    val stringAry: Array[String] = (temp.map(_.toString)).toArray
    for (st <- stringAry) {


      out.write((st.replace("(","")).replace(")","") + "\n")
    }
    println("*** write into file, done "+
    "file path:"+"./src/main/resources/resultFiles/" + fileName + ".csv")
    out.close()

  }
}

