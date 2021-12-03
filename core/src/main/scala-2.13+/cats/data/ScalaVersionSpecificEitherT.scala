package cats
package data

trait ScalaVersionSpecificEitherT[F[_], A, B] {
  def fold[C](fa: A => C, fb: B => C)(implicit F: Functor[F]): F[C]

  def toValidatedNell(implicit F: Functor[F]): F[ValidatedNell[A, B]] =
    fold(Validated.invalidNell, Validated.valid)

  /**
   * Transform this `EitherT[F, A, B]` into a `[[Nested]][F, ValidatedNell[A, *], B]`.
   */
  def toNestedValidatedNell(implicit F: Functor[F]): Nested[F, ValidatedNell[A, *], B] =
    Nested[F, ValidatedNell[A, *], B](
      toValidatedNell
    )
}
