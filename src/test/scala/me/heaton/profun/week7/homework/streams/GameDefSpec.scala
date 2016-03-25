package me.heaton.profun.week7.homework.streams

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class GameDefSpec extends Specification with Mockito {

  "Block" should {

    "be standing if the pos of the two position is same" in new GameDefScoped {
      val block = Block(Pos(0, 0), Pos(0, 0))
      block.isStanding === true
    }

    "be not standing if the pos of the two position is not same" in new GameDefScoped {
      val block = Block(Pos(0, 0), Pos(1, 0))
      block.isStanding === false
    }

    "get one legal block with down" in new GameDefScoped {
      startBlock.legalNeighbors === List((Block(Pos(1, 0), Pos(2, 0)), Down))
    }

  }

  trait GameDefScoped extends Scope with StringParserTerrain {
    override val level: String =
      """ST
        |oo
        |oo""".stripMargin
  }

}
