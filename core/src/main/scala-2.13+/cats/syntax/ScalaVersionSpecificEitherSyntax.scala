package cats
package syntax

import cats.data.NonEmptyLazyList

trait ScalaVersionSpecificEitherSyntax {
  implicit final def catsSyntaxScalaVersionSpecificValidatedId[A](a: A): ScalaVersionSpecificValidatedId[A] =
    new ScalaVersionSpecificValidatedId[A](a)
}

final private[syntax] class ScalaVersionSpecificEitherId[A](private val a: A) extends AnyVal {

  /**
   * Wrap a value to a left EitherNell
   *
   * For example:
   * {{{
   * scala> import cats.implicits._, cats.data.NonEmptyLazyList
   * scala> "Err".leftNell[Int]
   * res0: Either[NonEmptyLazyList[String], Int] = Left(NonEmptyLazyList(Err))
   * }}}
   */
  def leftNell[B]: Either[NonEmptyLazyList[A], B] = Left(NonEmptyLazyList.one(a))

  /**
   * Wrap a value to a right EitherNell
   *
   * For example:
   * {{{
   * scala> import cats.implicits._, cats.data.NonEmptyLazyList
   * scala> 1.rightNell[String]
   * res0: Either[NonEmptyLazyList[String], Int] = Right(1)
   * }}}
   */
  def rightNell[B]: Either[NonEmptyLazyList[B], A] = Right(a)
}
