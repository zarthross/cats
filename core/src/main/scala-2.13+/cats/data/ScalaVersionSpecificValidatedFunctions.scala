package cats
package data

trait ScalaVersionSpecificValidatedFunctions {

  /**
   * Converts a `A` to a `ValidatedNell[E, A]`.
   *
   * For example:
   * {{{
   * scala> Validated.validNell[IllegalArgumentException, String]("Hello world")
   * res0: ValidatedNell[IllegalArgumentException, String] = Valid(Hello world)
   * }}}
   */
  def validNell[E, A](a: A): ValidatedNell[E, A] = Validated.Valid(a)

  /**
   * Converts an `E` to a `ValidatedNell[E, A]`.
   *
   * For example:
   * {{{
   * scala> Validated.invalidNell[IllegalArgumentException, String](new IllegalArgumentException("Argument is nonzero"))
   * res0: ValidatedNell[IllegalArgumentException, String] = Invalid(NonEmptyLazyList(java.lang.IllegalArgumentException: Argument is nonzero))
   * }}}
   */
  def invalidNell[E, A](e: E): ValidatedNell[E, A] = Validated.Invalid(NonEmptyLazyList(e))

  /**
   * If the condition is satisfied, return the given `A` as valid NELL,
   * otherwise return the given `E` as invalid NonEmptyLazyList.
   */
  final def condNell[E, A](test: Boolean, a: => A, e: => E): ValidatedNell[E, A] =
    if (test) validNell(a) else invalidNell(e)
}
