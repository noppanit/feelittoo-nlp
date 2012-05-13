package com.feelittoo.nlp

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html 
class FeelittooServletSpec extends ScalatraSpec { def is =
  "GET / on FeelittooServlet"                     ^
    "should return status 200"                  ! root200^
                                                end
    
  addServlet(classOf[FeelittooServlet], "/*")

  def root200 = get("/") { 
    status must_== 200
  }
}
