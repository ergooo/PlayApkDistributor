package models.database.apk

import java.io.File
import scala.sys.process.Process

object ApkDecoder {

	def decode(file: File) = {
		ApkInfo("", "", 0, "");
	}

	def getPackageName(apkFile: File): String = {
		val res = (Process("./libs/aapt l -a " + apkFile.getAbsolutePath()) #| Process("grep package") #| Process("grep name")).lines.toList
		if (!res.isEmpty) {
			val line = res(0)
			val splitted = line.split("name=")
			splitted(1)
		}else{
			""
		}
	}
}
