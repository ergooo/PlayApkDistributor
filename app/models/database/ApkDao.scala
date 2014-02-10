package models.database

import org.squeryl.PrimitiveTypeMode._

object ApkDao {
  def insert(apk: Apk){
    transaction{
    	Db.apk.insert(apk)
    }
  }

}