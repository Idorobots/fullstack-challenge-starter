package fc

import com.typesafe.config.ConfigFactory

object Config {

  private val config = ConfigFactory.load()

  object Rest {
    val host = config.getString("fc.rest.host")
    val port = config.getInt("fc.rest.port")
  }

}
