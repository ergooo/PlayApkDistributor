package models.database

import org.squeryl.annotations.Column
import org.squeryl.KeyedEntity

class ApkTable(
  val name: String,
  @Column("apk_url") val apkUrl: String,
  @Column("icon_url") val iconUrl: String,
  @Column("package_name") val packageName: String,
  val id: Long = 0L) extends KeyedEntity[Long] {

}