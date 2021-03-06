package newts

import cats.kernel.laws.{GroupLaws, OrderLaws}
import cats.laws.discipline.{MonadTests, TraverseTests}

class MaxTest extends NewtsSuite {

  checkAll("Max[Int]", GroupLaws[Max[Int]].semigroup)
  checkAll("Max[Int]", GroupLaws[Max[Int]].monoid)
  checkAll("Max[Int]", OrderLaws[Max[Int]].order)
  checkAll("Max[Int]", MonadTests[Max].monad[Int, Int, Int])
  checkAll("Max[Int]", TraverseTests[Max].traverse[Int, Int, Int, Int, Option, Option])

  test("combine"){
    5.asMax |+| 1.asMax shouldEqual Max(5)
    1.asMax |+| 5.asMax shouldEqual Max(5)
  }

  test("show") {
    Max(5).show   shouldEqual "Max(5)"
    Max("1").show shouldEqual "Max(1)"
  }
}
