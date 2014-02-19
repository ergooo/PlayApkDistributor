package models.apk.xml

import java.io.File

class AndroidResources(resourceDirectory: File) {

	def getStringXmlResource = {
		val stringXmlFile = new File(resourceDirectory, "/values/strings.xml")
		new StringXmlResource(stringXmlFile)
	}

}