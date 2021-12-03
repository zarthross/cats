package cats
package data

trait ScalaVersionSpecificValidated[+E, +A] {

  def leftMap[EE](f: E => EE): Validated[EE, A]

  /**
   * Lift the Invalid value into a NonEmptyLazyList.
   *
   * Example:
   * {{{
   * scala> import cats.implicits._
   *
   * scala> val v1 = "error".invalid[Int]
   * scala> val v2 = 123.valid[String]
   *
   * scala> v1.toValidatedNell
   * res0: ValidatedNell[String, Int] = Invalid(NonEmptyLazyList(error))
   *
   * scala> v2.toValidatedNell
   * res1: ValidatedNell[String, Int] = Valid(123)
   * }}}
   */
  def toValidatedNell[EE >: E, AA >: A]: ValidatedNell[EE, AA] =
    leftMap(NonEmptyLazyList.one)
}
