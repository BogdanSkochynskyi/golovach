package net.golovach.udemy.traits

object Demo {
  def main(args: Array[String]) {
    val rect = new Rectangle(new Point(1,1), new Point(10, 10))
    println(rect.left)
    println(rect.right)
    println(rect.width)
  }
}
