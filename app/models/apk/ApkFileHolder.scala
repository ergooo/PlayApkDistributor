package models.apk

import java.io.File
import scala.sys.process._
import models.apk.xml.AndroidManifest
import models.apk.xml.AndroidResources


class ApkFileHolder(apkFile: File)  {

	val dst = new File("./temp/" + apkFile.getName())

	def ApkFileHolder(apkFile: File) = {
		open
	}

	def open: File = {
		Process("./libs/apktool d -s -f " + apkFile.getAbsolutePath() + " " + dst).!
		dst
	}

	def getFileName = {
		dst.getName
	}

	def getAndroidManifest = {
		val androidManifestFile = new File(dst, "AndroidManifest.xml")
		new AndroidManifest(androidManifestFile)
	}

	def getAndroidResources = {
		val resourceFiles = new File(dst, "res/")
		new AndroidResources(resourceFiles)
	}

	def close: Unit = {
		dst.delete()
	}


}