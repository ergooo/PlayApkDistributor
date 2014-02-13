package controllers

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.adapters.H2Adapter
import org.squeryl.adapters.PostgreSqlAdapter
import org.squeryl.internals.DatabaseAdapter
import play.api._
import play.api.Play.current
import play.api.mvc._
import models.database.Db
import models.database.Apk
import models.database.ApkDao

object Application extends Controller {

	//  def index = Action {
	//    Ok(views.html.index("Your new application is ready."))
	//  }

	def index = Action { request ⇒

		transaction {
			ApkDao.insert(new Apk("TestApp", "testapp.apk", "icon.png", "jp.ergo.android.test", 1, "1,0.0"))
		}

		Ok("Got request [" + request + "]")
	}
}