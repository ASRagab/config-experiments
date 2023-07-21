import java.io.File
import com.typesafe.config.ConfigFactory
import pureconfig._
import pureconfig.generic.auto._

object SampleConfigApp extends App {

  case class AppConfig(hosts: List[String], port: Int)
  case class RootConfig(app: AppConfig)

  val directory = new File("src/main/configs/child")

  val appConfig = ConfigSource
    .file(new File(directory, "application.conf"))
    .load[RootConfig]
    .fold(
      failures => {
        println(s"Failed to load config: ${failures.toList.mkString("\n")}")
        sys.exit(1)
      },
      identity
    )

  println(s"AppConfig: $appConfig")
}
