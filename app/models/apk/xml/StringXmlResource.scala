package models.apk.xml

import java.io.File
import scala.xml.NodeSeq
import models.apk.xml.XmlFilter._
import scala.xml.XML

class StringXmlResource(xml: NodeSeq) {

	def this(xmlFile: File) = this(toXML(xmlFile))
	def this(xmlString: String) = this(XML.loadString(xmlString))

	def get(name: String): String = {
		xml \\@ ("string", "name", name) text
	}
}