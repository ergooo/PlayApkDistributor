package models.database

import models.apk.ApkFileHolder

object ApkFactory {

	def create(apk: ApkFileHolder): Apk = {
		val androidManifest = apk.getAndroidManifest

		val apkName = apk.getFileName
		val appName = androidManifest.getAppName(apk.getAndroidResources)
		val versionCode = androidManifest.getVersionCode
		val versionName = androidManifest.getVersionName
		val packageName = androidManifest.getPackageName
		val iconName = androidManifest.getIconName

		new Apk(appName, apkName, iconName, packageName, versionCode, versionName)

	}
}