package net.golovach.udemy.programmingInScala.traits.stackable

trait Doubling extends IntQueue{
  abstract override def put(x: Int) {super.put(2 * x)}
}
