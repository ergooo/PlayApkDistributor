package models.database

import org.squeryl.PrimitiveTypeMode.long2ScalarLong
import org.squeryl.Schema

/**
 * saw at 
 * http://techmedia-think.hatenablog.com/entry/20121203/1354546359
 * http://www.mwsoft.jp/programming/scala/squeryl.html
 * http://stackoverflow.com/questions/12794427/squeryl-and-postgresqls-autoincrement
 */
object Db extends Schema{
  val apk = table[ApkTable]("apk")
  
  on(apk)(a => declare(
    a.id is(primaryKey, autoIncremented("apk_id_seq"))
  ))
  
}

