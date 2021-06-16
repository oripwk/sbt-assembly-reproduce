name := "sbt-assembly-reproduce"
scalaVersion := "2.12.11"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.7" % Provided,
  "org.asynchttpclient" % "async-http-client" % "2.12.1" % Compile,
  "com.google.cloud" % "google-cloud-datastore" % "1.105.3" % Compile,
  "org.apache.hadoop" % "hadoop-aws" % "2.7.3" % Provided,
  "com.github.scopt" %% "scopt" % "3.7.1" % Compile,
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.1" % Compile,
  "org.glassfish.jersey.core" % "jersey-common" % "2.22.2" % Compile,
  "org.brotli" % "dec" % "0.1.2" % Compile,
  "commons-codec" % "commons-codec" % "1.10",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2" % Compile,
  "commons-io" % "commons-io" % "2.6" % Compile,
  "com.helger" % "ph-css" % "6.2.3" % Compile,
  // Comment this line out
  "com.google.cloud" % "google-cloud-nio" % "0.123.1" % Test,
  "org.scalatest" %% "scalatest" % "3.1.2" % Test,
  "org.mockito" %% "mockito-scala-scalatest" % "1.14.8" % Test,
  "com.github.tomakehurst" % "wiremock" % "2.27.2" % Test,
  "org.gaul" % "s3proxy" % "1.7.1" % Test
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "services", _*) => MergeStrategy.concat
  case PathList("META-INF", "native", _*) => MergeStrategy.singleOrError
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}