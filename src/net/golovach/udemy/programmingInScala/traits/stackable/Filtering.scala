package net.golovach.udemy.programmingInScala.traits.stackable

trait Filtering extends IntQueue{
  abstract override def put(x: Int): Unit = {
    if (x > 0) super.put(x)
  }
}
