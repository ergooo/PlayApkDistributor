package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json

object Uploader extends Controller {
  def index = Action {
    Ok(views.html.up())
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("file").map { file =>
      import java.io.File
      val filename = file.filename
      val contentType = file.contentType
      file.ref.moveTo(new File("resources/apks/", filename))
      //Ok("File uploaded")
      Ok(Json.toJson(Map("staus" -> "OK", "message" -> ("completed!")))).as("application/json")
    }.getOrElse {
      Redirect(routes.Uploader.index).flashing(
        "error" -> "Missing file")
    }
  }
}