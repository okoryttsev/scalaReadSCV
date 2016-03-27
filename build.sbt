name := "PlanesProject"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++=  Seq("org.specs2" %% "specs2-core" % "3.7.2" % "test")
libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.3"
scalacOptions in Test ++= Seq("-Yrangepos")



