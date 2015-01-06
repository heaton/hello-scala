package me.heaton.profun.week6

/**
 * Queries with for
 * The for notation is essentially equivalent to the common operations of query languages for databases.
 */
object Books {

  case class Book(title: String, authors: Set[String])

  val books = Set(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = Set("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming",
      authors = Set("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java",
      authors = Set("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = Set("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala",
      authors = Set("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
  )

  def findByAuthor(name: String) =
    for (b <- books; a <- b.authors if a startsWith name) yield b.title

  /**
   * Translation of For
   * It is based solely on the presence of the methods map, flatMap and withFilter.
   * There are many types for which this is useful: arrays, iterators, databases, XML data, optional values, parsers, etc.
   * - for (x <- e1) yield e2  >>  e1.map(x => e2)
   * - for (x <- e1 if f; s) yield e2  >>  for (x <- e1.withFilter(x => f); s) yield e2
   * - for (x <- e1; y <- e2; s) yield e3  >>  e1.flatMap(x => for (y <- e2; s) yield e3)
   */
  def findByAuthorInHo(name: String) =
  //books.flatMap(b => for (a <- b.authors if a startsWith name) yield b.title)
  //books.flatMap(b => for (a <- b.authors withFilter (a => a startsWith name)) yield b.title)
    books.flatMap(b => b.authors withFilter (a => a startsWith name) map (_ => b.title))

  def findByTitle(title: String) =
    for (b <- books if b.title contains title) yield b.title

  def findGreatAuthors = for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1
}
