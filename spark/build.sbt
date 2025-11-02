name := "spark"


// flag to switch how spark Libraries are included
val isLocal = sys.env.get("LOCAL_MODE").contains("1")
  libraryDependencies ++= {
    println("Local mode = "+isLocal)
    if(isLocal) {    
      // in local mode (IDE), we want the spark libraries
      // set LOCAL_MODE as env variables in your IDE
      Seq(
        "org.apache.spark" %% "spark-core" % "3.5.1", // % Provided,
        "org.apache.spark" %% "spark-sql"  % "3.5.1" // % Provided
      )
    } else {
      // when building a jar to deploy, do not include spark
      // turn off LOCAL_MODE when running sbt assembly!
      Seq(
        "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
        "org.apache.spark" %% "spark-sql"  % "3.5.1" % Provided
      )
    }
  }

Compile / mainClass := Some("org.cscie88c.spark.SparkJob")

assembly / mainClass := Some("org.cscie88c.spark.SparkJob")
assembly / assemblyJarName := "SparkJob.jar"
assembly / test := {}
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case "application.conf"            => MergeStrategy.concat
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}
// see shading feature at https://github.com/sbt/sbt-assembly#shading
assembly / assemblyShadeRules := Seq(
  ShadeRule.rename("shapeless.**" -> "shadeshapeless.@1").inAll
)
