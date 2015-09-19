package me.heaton.concurrency

import scala.concurrent.duration._
import scala.concurrent.{Promise, Await, Future, ExecutionContext}
import scala.util.{Failure, Success}

object Futures extends App{

  implicit val ec = ExecutionContext.global

  Future(println("Do something later")) onComplete {
    case Success(_) => println("Do something success")
    case Failure(t) => println(s"Do something failed ${t.getMessage}")
  }

  Future {
    2 / 0
  } onFailure {
    case npe: NullPointerException =>
      println("I'd be amazed if this printed out.")
    case _ => println("Oh NO!")
  }

  val v = Await.result(Future {
    2 / 0
  } recover {
    case _ => 0
  }, Duration.Zero)
  println(s"v is $v")

  val usd = Future { 100 }
  val cnyRate = Future { 6.4 }

  val purchase = for {
    u <- usd
    r <- cnyRate
  } yield u * r
  
  purchase onSuccess {
    case amount => println("Purchased " + amount + " CNY")
  }

  val f = Future { sys.error("failed") }
  val g = Future { 5 }
  val h = f fallbackTo g
  val v2 = Await.result(h, Duration.Zero)
  println(s"v2 is $v2")

  val f2 = Future(List()) andThen {
    case Success(l) => 1 :: l
  } map {
    l => 2 :: l
  }
  val r = Await.result(f2, 0 millis)
  println(r)

  val f3 = Future { 1 }
  val p = Promise[Int]()
  p completeWith f
  p.future onSuccess {
    case x => println(x)
  }

  /**
   * If neither f nor g succeeds, then first(f, g) never completes
   */
  def first[T](f: Future[T], g: Future[T]): Future[T] = {
    val p = Promise[T]()
    f onSuccess {
      case x => p trySuccess x
    }
    g onSuccess {
      case x => p trySuccess x
    }
    p.future
  }

}
