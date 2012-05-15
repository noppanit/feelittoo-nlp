organization := "com.feelittoo"

name := "feelittoo-nlp"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
	"org.scalatra" %% "scalatra" % "2.0.4",
	"org.scalatra" %% "scalatra-scalate" % "2.0.4",
	"org.scalatra" %% "scalatra-specs2" % "2.0.4" % "test",
	"ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
	"org.eclipse.jetty" % "jetty-webapp" % "7.6.0.v20120127" % "container",
	"javax.servlet" % "servlet-api" % "2.5" % "provided",
	"net.liftweb" % "lift-json_2.9.1" % "2.4",
	"edu.stanford.nlp" % "stanford-corenlp" % "1.3.1")

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
