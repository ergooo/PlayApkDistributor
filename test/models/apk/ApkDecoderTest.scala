package models.apk

import java.io.File
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import scala.xml.parsing.ConstructingParser
import scala.io.Source
import org.apache.commons.io.FileUtils
import scala.xml.XML

class ApkDecoderTest extends AssertionsForJUnit{

	@Test
	def testDecode{
		val apkFile = new File("./test/resources/ApkDistributor.apk")

		val apk = ApkDecoder.decode(apkFile)
		println(apk)
		assert(apk.appName == "@string/app_name")
		assert(apk.apkName == "ApkDistributor.apk")
		assert(apk.iconName == "@drawable/ic_launcher")
		assert(apk.packageName == "jp.ergo.android.apkdistributor")
		assert(apk.versionCode == 1)
		assert(apk.versionName == "1.0")

	}
	@Test
	def testExtractAndroidManifest{
		val apkFile = new File("./test/resources/ApkDistributor.apk")
		val manifest = ApkDecoder.extractAndroidManifest(apkFile)
		assert(manifest.exists)
	}
}
