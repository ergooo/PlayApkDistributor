package models.apk

import scala.xml.NodeSeq
import org.apache.commons.io.FileUtils
import java.io.File
import scala.xml.XML

package object xml {
	def toXML(xmlFile: File): NodeSeq = {
		val s = FileUtils.readFileToString(xmlFile).replaceAll("android:", "")
		XML.loadString(s)
	}

}