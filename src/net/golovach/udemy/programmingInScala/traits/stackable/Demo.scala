package net.golovach.udemy.programmingInScala.traits.stackable

object Demo {
  def main(args: Array[String]) {
    val queue = new MyQueue // == val queue = new BasicIntQueue with Doubling
    val queue1 = new BasicIntQueue with Doubling
    queue.put(10)
    queue1.put(10)
    println(queue.get())
    println(queue1.get())
  }
}
