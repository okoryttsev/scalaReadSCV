
object RunnerApp {
  def main(filenames: Array[String]): Unit = {
    val fileName = "./src/main/resources/file/planes_log.csv.gz" //val filePath = "./src/main/resources/file/planes_log.csv"
    println("\nStep1 read values")
    var resultMap=WorkFile.readFileFormatGz((fileName))
    println("\nStep2 count values")
    val result=WorkFile.countForLastColumnTable(resultMap)
    println("\nStep3 put values into file")
    WorkFile.writeResultIntoFile(result,"countLastColumns")
    println("\nStep4 get results of diffs between columns ")
    val result2=WorkFile.countDiffBetweenColuns(resultMap)
    println("\nStep5 write results into file")
    WorkFile.writeResultIntoFile(result2,"countTheDifference")
    println("\nStep6 number of day ")
    WorkFile.countValueForDays(resultMap)

  }
}
