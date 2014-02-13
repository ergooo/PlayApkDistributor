package models.database

import org.squeryl.KeyedEntity
import org.squeryl.annotations.Column

case class Apk(
	@Column("app_name") val appName: String,
	@Column("apk_name") val apkName: String,
	@Column("icon_name") val iconName: String,
	@Column("package_name") val packageName: String,
	@Column("version_code") val versionCode: Int,
	@Column("version_name") val versionName: String
	) extends KeyedEntity[Long] {
	val id: Long = 0L
}
