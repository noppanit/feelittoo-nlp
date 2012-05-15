package com.feelittoo.nlp

import org.scalatra._
import scalate.ScalateSupport

class FeelittooServlet extends ScalatraServlet with ScalateSupport {

  get("/:text") {
    contentType = "application/json"
    val text = params("text")
    "{'company' : '%s'}".format(text)
  }

  post("/text") {

  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}
