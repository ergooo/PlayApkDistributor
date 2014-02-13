package models.apk

import java.io.File

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class ApkDecoderTest extends AssertionsForJUnit{

	@Test
	def testGetPackageName {
		val apkFile = new File("./test/resources/ApkDistributor.apk")
		val packageName = ApkDecoder.getPackageName(apkFile);

		val actual = "jp.ergo.android.apkdistributor"
		assert(packageName == actual)
	}
}
