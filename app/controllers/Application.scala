package controllers

import play.api._
import play.api.mvc._
import org.squeryl.{ SessionFactory, Session }
import org.squeryl.adapters.PostgreSqlAdapter
import play.api.db.DB
import play.api.Play.current
import javax.sql.DataSource
import org.squeryl.adapters.H2Adapter
import org.squeryl.internals.DatabaseAdapter
import models.database.ApkTable
import org.squeryl.PrimitiveTypeMode._
import models.database.Db

object Application extends Controller {

//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//  }


  def index = Action { request =>
    
    transaction{
      Db.apk.insert(new ApkTable("apkName","apkUrl","iconUrl","packageName"))
    }
    
  	Ok("Got request [" + request + "]")
  }
}