package me.heaton.profun.week4.homework.patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList: no leaf for empty frequency") {
    assert(makeOrderedLeafList(List()) === List())
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("singleton: a tree only has one leaf") {
    assert(singleton(List(Leaf('a', 1))) === true)
    assert(singleton(List()) === false)
  }

  test("combine of one leaf should return it self") {
    val leaflist = List(Leaf('e', 1))
    assert(combine(leaflist) === List(Leaf('e', 1)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("until should combine all leaf to a tree") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton, combine)(leaflist) === List(Fork(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4), List('e', 't', 'x'), 7)))
  }

  test("createCodeTree should return a tree by a char list") {
    assert(createCodeTree(string2Chars("Hello")) === makeCodeTree(Leaf('l', 2), makeCodeTree(Leaf('o', 1), makeCodeTree(Leaf('H', 1), Leaf('e', 1)))))
  }

  test("decode 01 to ab with tree t1") {
    new TestTrees {
      assert(decode(t1, List(0, 1)) === List('a', 'b'))
    }
  }

  test("decode 01001101000111 to baddbabdd with t2") {
    new TestTrees {
      assert(decode(t2, List(0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1)) === "baddbabdd".toList)
    }
  }

  test("see the secret") {
    assert(decodedSecret.foldLeft("")((z, c) => z + c) === "huffmanestcool")
  }

  test("encode ab to 01 with tree t1") {
    new TestTrees {
      assert(encode(t1)(string2Chars("ab")) === List(0, 1))
    }
  }

  test("encode baddbabdd to 01001101000111 with tree t2") {
    new TestTrees {
      assert(encode(t2)(string2Chars("baddbabdd")) === List(0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("quick encode baddbabdd to 01001101000111 with tree t2") {
    new TestTrees {
      assert(quickEncode(t2)(string2Chars("baddbabdd")) === List(0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1))
    }
  }

  test("times of an empty string should return a list of Nil") {
    assert(times(string2Chars("")) === Nil)
  }

  test("times of aba should return a list contains (b, 1) and (a, 2)") {
    assert(times(string2Chars("aba")).sortBy(_._1) == List(('a', 2), ('b', 1)))
  }

}
