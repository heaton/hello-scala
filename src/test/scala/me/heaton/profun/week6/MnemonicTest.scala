package me.heaton.profun.week6

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MnemonicTest extends FunSuite {

  test("read file") {
    assert(Mnemonic.words contains "Scala")
  }

  test("char -> code") {
    assert(Mnemonic.charCode('A') === '2')
  }

  test("word to code") {
    assert(Mnemonic.wordCode("Java") === "5282")
  }

  test("words from nums") {
    assert(Mnemonic.wordsForNum("5282") contains "Java")
    assert(Mnemonic.wordsForNum("72252") contains "Scala")
  }

  test("encode 7225247386") {
    assert(Mnemonic.encode("7225247386") contains List("Scala", "is", "fun"))
  }

  test("describe encode last step") {
    val lastStep = Set(List("is", "fun")) map ("Scala" :: _)
    assert(lastStep === Set(List("Scala", "is", "fun")))
  }

  test("translate 7225247386") {
    assert(Mnemonic.translate("7225247386") contains "Scala is fun")
  }

}

