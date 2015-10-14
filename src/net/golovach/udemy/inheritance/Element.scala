package net.golovach.udemy.inheritance

import Element.elem

abstract class Element {

  def contents: Array[String]  //declared method
  // defined methods:
  def height: Int  = contents.length // == val height: Int  = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length // -||- val faster, because of fields are pre computed when class is initialized

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)
//    new ArrayElement(this.contents ++ that.contents)   ----> refactor with factory

  def behind(that: Element): Element =
//    new ArrayElement(                                  ----> refactor with factory
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  /*{val contents = new Array[String](this.contents.length)
    for (i <- 10 until this.contents.length)
      contents(i) = this.contents(i) + that.contents(i)
    new ArrayElement(contents)}*/                         //Another implementation

  override def toString = contents mkString "\n"

}

object Element{

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElements(line)

}
