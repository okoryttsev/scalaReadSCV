import java.io._
import java.util.zip._
import au.com.bytecode.opencsv.CSVReader


class WorkFile{
   def main(filenames: Array[String]): Unit = {
      val fileName = "./src/main/resources/planes_log.csv.gz"
      readCsv(fileName)


    }
    def readCsv(fileName:String) {

      val in: InputStream = new GZIPInputStream(new FileInputStream(fileName))
      val reader = new CSVReader(new InputStreamReader(in))
      val data = reader.readAll().toArray
      println(data.length)

  }
}