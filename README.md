# sbt-assembly-reproduce

This repository reproduces a sbt-assembly bug where a "Test" scope dependency causes the
plugin to generate an entirely different JAR.

## Reproduce
1. `sbt clean assembly`
1. Copy the resulting JAR to a side folder
1. Now, comment-out the `"com.google.cloud" % "google-cloud-nio" % "0.123.1" % Test` line in [build.sbt](build.sbt).
1. `sbt clean assembly`
1. Now compare the contents of both JARs.

You'll see some files not appearing in one JAR but the other, and other files (even .class files) have
an entirely different content.

A "Test" dependency should _never_ affect the final artifact.

**This is not just an experiment, it breaks our production code**