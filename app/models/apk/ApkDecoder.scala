package models.apk

import java.io.File
import scala.Array.canBuildFrom
import scala.sys.process.Process
import models.database.Apk
import org.apache.commons.io.FileUtils
import scala.xml.XML
import scala.xml.Document
import scala.xml.Elem
import scala.xml.Node
import scala.xml.NodeSeq

object ApkDecoder {

	def decode(apkFile: File) = {
		val manifest = extractAndroidManifest(apkFile)
		val s = FileUtils.readFileToString(manifest).replaceAll("android:", "")
		val doc = XML.loadString(s)

		val apkName = apkFile.getName();
		val appName = getAppName(doc)
		val versionCode = getVersionCode(doc)
		val versionName = getVersionName(doc)
		val packageName = getPackageName(doc)
		val iconName = getIconName(doc)

		new Apk(appName, apkName, iconName, packageName, versionCode, versionName)
	}

	def extractAndroidManifest(apkFile: File): File={
		Process("./libs/apktool d -s -f " + apkFile.getAbsolutePath() + " ./temp").!
		new File("./temp/AndroidManifest.xml")
	}

	private def getAppName(doc: NodeSeq) : String = {
		(doc \\ "application" \ "@label").toString()
	}
	private def getVersionCode(doc: NodeSeq) : Int = {
		(doc \\ "manifest" \ "@versionCode").toString().toInt
	}
	private def getVersionName(doc: NodeSeq): String = {
		(doc \\ "manifest" \ "@versionName").toString()
	}
	private def getPackageName(doc: NodeSeq): String = {
		(doc \\ "manifest" \ "@package").toString()
	}
	private def getIconName(doc: NodeSeq): String = {
		(doc \\ "application" \ "@icon").toString()
	}
}
