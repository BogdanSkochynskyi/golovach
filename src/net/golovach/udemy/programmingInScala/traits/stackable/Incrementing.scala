package net.golovach.udemy.programmingInScala.traits.stackable

trait Incrementing extends IntQueue{
  abstract override def put(x: Int) {super.put(x + 1)}
}
