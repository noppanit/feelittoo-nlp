package com.feelittoo.nlp

import org.scalatra._
import scalate.ScalateSupport
import net.liftweb.json.JsonAST._
import net.liftweb.json.Printer._
import net.liftweb.json.JsonDSL._
import edu.stanford.nlp.ie.crf.CRFClassifier
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import edu.stanford.nlp.ling.{Sentence, TaggedWord}

class FeelittooServlet extends ScalatraServlet with ScalateSupport {

  private val classifier = CRFClassifier.getClassifierNoExceptions("./classifiers/english.all.3class.distsim.crf.ser.gz")
  private val tagger = new MaxentTagger("./models/english-bidirectional-distsim.tagger")

  post("/text") {
    val text = params("text")
    contentType = "application/json"
    val pattern = """(\w+)/ORGANIZATION""".r

    val list = pattern.findAllIn(classifier.classifyToString(text)).matchData.map(m => m.group(1)).toList

    pretty(render(list))
  }

  post("/noun") {
    val text = params("text")
    contentType = "application/json"
    val pattern = """(\w+)/NN""".r

    val list = pattern.findAllIn(tagger.tagString(text)).matchData.map(m => m.group(1)).toList

    pretty(render(list))
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
