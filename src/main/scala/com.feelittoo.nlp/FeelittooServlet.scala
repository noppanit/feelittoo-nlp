package com.feelittoo.nlp

import org.scalatra._
import scalate.ScalateSupport
import net.liftweb.json.JsonAST._
import net.liftweb.json.Extraction._
import net.liftweb.json.Printer._
import net.liftweb.json.JsonDSL._

class FeelittooServlet extends ScalatraServlet with ScalateSupport {

  implicit val formats = net.liftweb.json.DefaultFormats

  get("/:text") {

    contentType = "application/json"
    val text = params("text")
    val json = List("test")
    pretty(render(json))
    //    "{'company' : '%s'}".format(text)
  }

  post("/text") {

  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map {
      path =>
        contentType = "text/html"
        layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}
