package com.vcc.adopt.config.yaml

class ConfigYML(yamlData: java.util.Map[String, Any]){
  def getProperty(propertyKey: String): String = {
    val keys = propertyKey.split("\\.")
    var currentMap = yamlData

    // Traverse the YAML structure to retrieve the property value
    for (i <- 0 until keys.length - 1) {
      if (currentMap.containsKey(keys(i))) {
        currentMap = currentMap.get(keys(i)).asInstanceOf[java.util.Map[String, Any]]
      } else {
        throw new Exception(s"Not found property ${propertyKey}")
      }
    }
    currentMap.get(keys.last).toString
  }

  def getPropByDeployMode(propertyKey: String, env: String): String = {
    if(!propertyKey.contains(".deployMode."))
      throw new Exception("Not found deployMode in key")
    getProperty(propertyKey.replace(".deployMode.", s".$env."))
  }

  def getPropByDeployMode(propertyKey: String, env: String, default: String): String = {
    if (!propertyKey.contains(".deployMode."))
      throw new Exception("Not found deployMode in key")
    try {
      getProperty(propertyKey.replace(".deployMode.", s".$env."))
    }catch {
      case _: NullPointerException => default
    }
  }
}
