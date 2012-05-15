import edu.stanford.nlp.ie._;
import edu.stanford.nlp.ie.crf._
import edu.stanford.nlp.util.CoreMap
;

class FeelittooNLP {

  def getOrganizationName(text: String): List[String] = {
    val pattern = """(\w+)/ORGANIZATION""".r
    var list = List[String]()

    var classifier: AbstractSequenceClassifier[_ <: CoreMap] = CRFClassifier.getClassifierNoExceptions("./classifiers/all.3class.distsim.crf.ser.gz")
    var taggedText = classifier.classifyToString(text)

    pattern.findAllIn(taggedText).matchData foreach {
      m => list ::= m.group(1)
    }

    return list
  }
}