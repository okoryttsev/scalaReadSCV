
object RunnerApp {
  def main(filenames: Array[String]): Unit = {
    val fileName = "./src/main/resources/file/planes_log.csv.gz" //val filePath = "./src/main/resources/file/planes_log.csv"

    WorkFile.readFileFormatGz((fileName))
//    WorkFile.countFieldDest(er)

  }
}
