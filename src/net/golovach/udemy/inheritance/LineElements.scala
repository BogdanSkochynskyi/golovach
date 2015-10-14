package net.golovach.udemy.inheritance

class LineElements(s: String) extends Element{
  val contents = Array(s)

  // == val height: Int  = contents.length
  override def width: Int = s.length

  //declared method
  override def height: Int = 1
}
