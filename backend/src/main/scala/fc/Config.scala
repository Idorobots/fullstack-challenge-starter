package fc

import com.typesafe.config.ConfigFactory

object Config {

  private val config = ConfigFactory.load()

  object Rest {
    val host: String = config.getString("fc.rest.host")
    val port: Int = config.getInt("fc.rest.port")
  }

}
