package models.database.apk

import java.io.File

import scala.sys.process._

object ApkDecoder {
	val KEY_OF_PACKAGE_NAME = "name="

	def decode(file: File) = {
		ApkInfo("", "", 0, "");
	}

	def getPackageName(apkFile: File): String = {
		try{
			// println(res) is like "Package Group 0 id=127 packageCount=1 name=jp.ergo.android.apkdistributor"
			val res = (Process("./libs/aapt l -a " + apkFile.getAbsolutePath()) #| Process("grep package") #| Process("grep name=")).!!

			// in case multiple lines be hit.
			val elems = res.trim().split(" ")
			val elemsStartsWithName = for(e <- elems; if e.startsWith(KEY_OF_PACKAGE_NAME)) yield e
			// only need the first one.
			if(!elemsStartsWithName.isEmpty) elemsStartsWithName(0).split(KEY_OF_PACKAGE_NAME)(1)
			else "" // TODO throw a certain exception
		}catch{
			// TODO throw a certain exception
			case _ : Throwable => ""
		}
	}
}
