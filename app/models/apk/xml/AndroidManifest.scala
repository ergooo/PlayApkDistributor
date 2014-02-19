package models.apk.xml

import scala.xml.NodeSeq
import java.io.File
import scala.xml.XML

class AndroidManifest(manifestXml: NodeSeq) {
	def this(xmlFile: File) = this(toXML(xmlFile))
	def this(xmlString: String) = this(XML.loadString(xmlString))

	def getAppName: String = {
		(manifestXml \\ "application" \ "@label").toString()
	}

	def getAppName(stringXmlResource: StringXmlResource): String = {
		val appName = getAppName
		if(appName.startsWith("@")) stringXmlResource.get(appName.split("/")(1))
		else appName
	}
	def getAppName(xmlString: String): String = {
		getAppName(new StringXmlResource(xmlString))
	}
	def getAppName(androidResources: AndroidResources): String = {
		getAppName(androidResources.getStringXmlResource)
	}

	def getVersionCode: Int = {
		(manifestXml \\ "manifest" \ "@versionCode").toString().toInt
	}
	def getVersionName: String = {
		(manifestXml \\ "manifest" \ "@versionName").toString()
	}
	def getPackageName: String = {
		(manifestXml \\ "manifest" \ "@package").toString()
	}
	def getIconName: String = {
		(manifestXml \\ "application" \ "@icon").toString()
	}

}