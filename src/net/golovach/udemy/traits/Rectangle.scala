package net.golovach.udemy.traits

class Rectangle(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  //and many more geometrical methods
}
