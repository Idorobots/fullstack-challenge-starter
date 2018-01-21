package oc

import com.typesafe.config.ConfigFactory

object Config {

  private val config = ConfigFactory.load()

  object Rest {
    val host = config.getString("oc.rest.host")
    val port = config.getInt("oc.rest.port")
  }

}
