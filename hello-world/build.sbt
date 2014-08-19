name := "hello-world"

version := "0.0.1"

mainClass := Some("io.humandb.Main")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies += "com.rabbitmq" % "amqp-client" % "2.0.0"
