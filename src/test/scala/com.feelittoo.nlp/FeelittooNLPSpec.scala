import org.specs2.mutable._
import scala.util._

class FeelittooNLPSpec extends Specification {
	"NLP Library" should {
		"return organisation names" in {
			var feelittooNLP = new FeelittooNLP
			feelittooNLP.getOrganizationName("My iPhone is from Apple") must have size(1)
		}
	}
}