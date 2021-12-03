package cats
package syntax

import cats.data.Validated
import cats.data.ValidatedNell

trait ScalaVersionSpecificValidatedSyntax {
  implicit final def catsSyntaxScalaVersionSpecificValidatedId[A](a: A): ScalaVersionSpecificValidatedId[A] =
    new ScalaVersionSpecificValidatedId[A](a)
}

final private[syntax] class ScalaVersionSpecificValidatedId[A](private val a: A) extends AnyVal {
  def validNell[B]: ValidatedNell[B, A] = Validated.Valid(a)

  def invalidNell[B]: ValidatedNell[A, B] = Validated.invalidNell(a)
}
