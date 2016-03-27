
object RunnerApp {
  def main(filenames: Array[String]): Unit = {
    val fileName = "./src/main/resources/file/planes_log.csv.gz" //val filePath = "./src/main/resources/file/planes_log.csv"

    var resultMap=WorkFile.readFileFormatGz((fileName))
    println("\nStep1")
    WorkFile.countForLastColumnTable(resultMap)
    println("\nStep2")

  }
}
