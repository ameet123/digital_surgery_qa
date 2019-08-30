enablePlugins(GatlingPlugin)
name := "digital_surgery_qa"

version := "0.1"

scalaVersion := "2.12.9"

libraryDependencies ++= Seq(
  "io.gatling" % "gatling-app" % "3.2.1",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.2.1",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.2.1" % Test,
  "io.gatling" % "gatling-test-framework" % "3.2.1"% Test,
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}