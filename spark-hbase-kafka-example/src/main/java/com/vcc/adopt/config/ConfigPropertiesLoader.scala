package com.vcc.adopt.config

import com.vcc.adopt.config.yaml.ConfigYML
import org.yaml.snakeyaml.Yaml

import java.io.{FileInputStream, FileNotFoundException, IOException}
import java.util.Properties

object ConfigPropertiesLoader {
  def readPropertyFile(nameFile: String): Properties = {
    val prop = new Properties
    try {
      val in = new FileInputStream(nameFile)
      prop.load(in)
    } catch {
      case e: FileNotFoundException =>
        e.printStackTrace()
      case e: IOException =>
        e.printStackTrace()
    }
    prop
  }

  def readYamlPropertyFile(filePath: String): ConfigYML = {
    val yaml = new Yaml()
    try {
      val in = new FileInputStream(filePath)
      return new ConfigYML(yaml.load(in))
    } catch {
      case e: FileNotFoundException =>
        e.printStackTrace()
      case e: IOException =>
        e.printStackTrace()
    }
    null
  }

  def getPropConfig: Properties = {
    val prop = readPropertyFile("config/config.properties")
    prop
  }

  def getConfigFilePath(): String = {
    "config/config.yaml"
  }

  def getYamlConfig: ConfigYML = {
    val prop = readYamlPropertyFile(getConfigFilePath())
    prop
  }

  def main(args: Array[String]): Unit = {
    println(readYamlPropertyFile("config/config.yaml").getProperty("gateway.prod.runAppList"))
    //    println(json.getJSONObject("gateway").get("deployMode"))
  }
}
