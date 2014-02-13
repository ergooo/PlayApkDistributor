package models.database

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test

class ApkDaoTest extends AssertionsForJUnit{

	@Test
	def testInsert {
		ApkDao.insert(new Apk("test","test","test","", 1, "1.0.0"))
	}
}