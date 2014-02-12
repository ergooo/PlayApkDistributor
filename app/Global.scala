

import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.adapters.PostgreSqlAdapter
import play.api.Application
import play.api.GlobalSettings
import play.api.db.DB

/**
 * アプリケーション全般の設定を行うオブジェクト
 */
object Global extends GlobalSettings {

	/**
	 * アプリケーション起動時のイベントをフック
	 * @param app
	 */
	override def onStart(app: Application) {
		// Squerylの初期化
		SessionFactory.concreteFactory = Some(() ⇒
			Session.create(DB.getConnection("default", true)(app), new PostgreSqlAdapter)
		)
	}

}