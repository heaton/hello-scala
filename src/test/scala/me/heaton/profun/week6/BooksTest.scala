package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BooksTest extends FunSuite {

  test("to find the titles of books whose author's name is Bird") {
    assert((Books findByAuthor "Bird,") === Set("Introduction to Functional Programming"))
  }

  test("to find all the books which have the word Program in the title") {
    assert((Books findByTitle "Program") === Set("Introduction to Functional Programming",
      "Programming in Scala", "Structure and Interpretation of Computer Programs"))
  }

  test("To find the names of all authors who have written at least two books present in the database.") {
    assert(Books.findGreatAuthors === Set("Bloch, Joshua"))
  }

}

