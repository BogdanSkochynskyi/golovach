package net.golovach.udemy.programmingInScala.traits

class Animal
trait HasLegs
class Frog extends Animal with Philosophical with HasLegs{

  override def toString = "green"
  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}
