package com.feelittoo.nlp

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html 
class FeelittooServletSpec extends ScalatraSpec { def is =
  "POST / on FeelittooServlet"                          ^
    "should return status 200 and organisation names"   ! getOrgNames ^
    "should return status 200 and nouns"                ! getNouns ^
    "should return status 200 and nouns of long string" ! getNounsOfLongString
                                                end
    
  addServlet(classOf[FeelittooServlet], "/*")

  def getOrgNames = post("/text", Map("text" -> "I love Google and Apple")) {
    status must_== 200
    body must_== "[\"Google\",\"Apple\"]"
  }

  def getNouns = post("/noun", Map("text" -> "I eat apple")) {
    status must_== 200
    body must_== "[\"apple\"]"
  }

  def getNounsOfLongString = post("/noun", Map("text" -> "The world can be such a scary place, full of trials and tribulations but each day I wake up I know that your face and your morning hugs will be right there waiting for you. There is no other way to describe the word LOVE. To me love means simply means YOU. Many we continue to live the life we deserve. May the good Lord continue to shower us with good life, happiness and health. Happy 16 years anniversary.")) {
    status must_==  200
    body must_== "[\"world\",\"place\",\"trials\",\"tribulations\",\"day\",\"face\",\"morning\",\"hugs\",\"way\",\"word\",\"LOVE\",\"love\",\"life\",\"Lord\",\"life\",\"happiness\",\"health\",\"years\",\"anniversary\"]"
  }
}
