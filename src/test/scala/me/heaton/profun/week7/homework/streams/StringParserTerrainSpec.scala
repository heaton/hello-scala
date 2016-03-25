package me.heaton.profun.week7.homework.streams

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class StringParserTerrainSpec extends Specification with Mockito {

  "find char" should {

    "get the position" in new StringParserTerrainScoped {
      val map = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
      findChar('T', map) === Pos(0, 1)
    }
  }

  "terrain" should {

    "check if the pos is valid" in new StringParserTerrainScoped {
      terrain(Pos(0, 0)) === true
      terrain(Pos(0, 1)) === true
      terrain(Pos(2, 1)) === true
      terrain(Pos(0, 2)) === false
      terrain(Pos(3, 0)) === false
    }
  }

  "vals" should {

    "be right" in new StringParserTerrainScoped {
      startPos === Pos(0, 0)
      goal === Pos(0, 1)
    }
  }

  trait StringParserTerrainScoped extends Scope with StringParserTerrain {
    override val level: String = """ST
                                   |oo
                                   |oo""".stripMargin
  }

}
