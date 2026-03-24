package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/
  @Test def mapShouldApplyFunctionToValue(): Unit =
    val nonEmpty = OptionalInt.Just(2)
    val result = OptionalInt.map(nonEmpty, (x: Int) => x * 2)
    assertEquals(OptionalInt.Just(4), result)

  @Test def mapShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    val result = OptionalInt.map(empty, (x: Int) => x * 2)
    assertEquals(OptionalInt.Empty(), result)

  @Test def filterShouldReturnValueWhenPredicateTrue(): Unit =
    val nonEmpty = OptionalInt.Just(2)
    val result = OptionalInt.filter(nonEmpty, (x: Int) => x % 2 == 0)
    assertEquals(OptionalInt.Just(2), result)

  @Test def filterShouldReturnEmptyWhenPredicateFalse(): Unit =
    val nonEmpty = OptionalInt.Just(3)
    val result = OptionalInt.filter(nonEmpty, (x: Int) => x % 2 == 0)
    assertEquals(OptionalInt.Empty(), result)