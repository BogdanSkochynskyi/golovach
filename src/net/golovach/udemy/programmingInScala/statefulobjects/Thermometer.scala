package net.golovach.udemy.programmingInScala.statefulobjects

class Thermometer {

  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 +32
  def fahrenheit_ (f: Float) = {
    (f - 32) * 5 / 9
  }

  override def toString = fahrenheit + "F/" + celsius + "C"
}
