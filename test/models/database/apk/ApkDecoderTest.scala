package models.database.apk

import java.io.File

import scala.collection.mutable.ListBuffer

import org.junit.Assert._
import org.junit.Before
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class ApkDecoderTest extends AssertionsForJUnit{

	@Test
	def testGetPackageName {
		val apkFile = new File("./test/resources/ApkDistributor.apk")
		val packageName = ApkDecoder.getPackageName(apkFile);

		assert(packageName == "jp.ergo.android.apkdistributor")
	}
}
