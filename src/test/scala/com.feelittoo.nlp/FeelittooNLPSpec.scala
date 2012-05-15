import org.specs2.mutable._
import scala.util._

class FeelittooNLPSpec extends Specification {
  "NLP Library" should {
    "return organisation names given Apple" in {
      var feelittooNLP = new FeelittooNLP
      val organisation_names: List[String] = feelittooNLP.getOrganizationName("My iPhone is from Apple")
      organisation_names must have size (1)
      organisation_names.head must_== "Apple"

    }

    "return organisation names given BT and Apple" in {
      var feelittooNLP = new FeelittooNLP
      val organisation_names: List[String] = feelittooNLP.getOrganizationName("My iPhone is from Apple. I also hate Google")
      organisation_names must have size (2)
      organisation_names.contains("Apple") must_== true
      organisation_names.contains("Google") must_== true
    }
  }
}