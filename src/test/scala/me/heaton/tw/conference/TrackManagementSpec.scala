package me.heaton.tw.conference

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import TrackManagement._

class TrackManagementSpec extends Specification with Mockito{

  "parse talk" should {
    "be a 5 minutes talk when it is lightning" in {
      parseTalk("A topic lightning") === Talk("A topic lightning", 5)
    }

    "be a 30 minutes talk when there is 30min" in {
      parseTalk("A topic 30min") === Talk("A topic 30min", 30)
    }
  }

  "find talks by total minutes" should {
    "have talks in 10min" in {
      val talks = List(Talk("A", 5), Talk("B", 2), Talk("C", 2), Talk("D", 3))
      matchTalks(talks, 10).toSet === List(Talk("A", 5), Talk("B", 2), Talk("D", 3)).toSet
    }
  }

  "time plus" should {
    "be 09:05AM when 09:00AM + 5" in {
      timePlus("09:00AM", 5) === "09:05AM"
    }
    "be 09:59PM when 09:00PM + 59" in {
      timePlus("09:00PM", 59) === "09:59PM"
    }
    "be 10:30AM when 09:45AM + 45" in {
      timePlus("09:45AM", 45) === "10:30AM"
    }
  }

  "make session" should {
    "create a session with correct start time" in {
      val talks = List(Talk("A", 30), Talk("B", 45), Talk("C", 5))
      makeSession("09:00AM")(talks) === List(("09:00AM", Talk("A", 30)), ("09:30AM", Talk("B", 45)), ("10:15AM", Talk("C", 5)))
    }
  }

  "create conference" should {
    "get a perfect conference" in {
      val inputs = """
                     |Writing Fast Tests Against Enterprise Rails 60min
                     |Overdoing it in Python 45min
                     |Lua for the Masses 30min
                     |Ruby Errors from Mismatched Gem Versions 45min
                     |Common Ruby Errors 45min
                     |Rails for Python Developers lightning
                     |Communicating Over Distance 60min
                     |Accounting-Driven Development 45min
                     |Woah 30min
                     |Sit Down and Write 30min
                     |Pair Programming vs Noise 45min
                     |Rails Magic 60min
                     |Ruby on Rails: Why We Should Move On 60min
                     |Clojure Ate Scala (on my project) 45min
                     |Programming in the Boondocks of Seattle 30min
                     |Ruby vs. Clojure for Back-End Development 30min
                     |Ruby on Rails Legacy App Maintenance 60min
                     |A World Without HackerNews 30min
                     |User Interface CSS in Rails Apps 30min
                   """.stripMargin.trim.split("\\r?\\n").toList
      println(printConference(createConference(inputs)))
      createConference(inputs).length === 2
    }
  }

}
