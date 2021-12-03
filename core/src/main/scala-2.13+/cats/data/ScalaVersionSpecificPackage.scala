package cats
package data

abstract private[data] class ScalaVersionSpecificPackage {
  type NonEmptyLazyList[+A] = NonEmptyLazyList.Type[A]
  @deprecated("Use NonEmptyLazyList", "2.0.0-RC2")
  type NonEmptyStream[A] = OneAnd[Stream, A]

  type EitherNell[+E, +A] = Either[NonEmptyLazyList[E], A]
  type IorNell[+B, +A] = Ior[NonEmptyLazyList[B], A]
  type ValidatedNell[+E, +A] = Validated[NonEmptyLazyList[E], A]

  @deprecated("Use NonEmptyLazyList", "2.0.0-RC2")
  def NonEmptyStream[A](head: A, tail: Stream[A]): NonEmptyStream[A] =
    OneAnd(head, tail)

  @deprecated("Use NonEmptyLazyList", "2.0.0-RC2")
  def NonEmptyStream[A](head: A, tail: A*): NonEmptyStream[A] =
    OneAnd(head, tail.toStream)
}
