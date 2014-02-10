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

object Application extends Controller {

//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//  }


  def index = Action { request =>
    
    transaction{
      Db.apk.insert(new Apk("apkName","apkUrl","iconUrl","packageName"))
    }
    
  	Ok("Got request [" + request + "]")
  }
}