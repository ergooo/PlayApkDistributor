package database

import org.squeryl.Schema
/**
 * saw at 
 * http://techmedia-think.hatenablog.com/entry/20121203/1354546359
 * http://www.mwsoft.jp/programming/scala/squeryl.html
 */
object Db extends Schema{
  val apk = table[ApkTable]("apk")
}

