package net.golovach.udemy.programmingInScala.inheritance

import Element.elem

abstract class Element {

  def contents: Array[String]  //declared method
  // defined methods:
  def height: Int  = contents.length // == val height: Int  = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length // -||- val faster, because of fields are pre computed when class is initialized

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)
//    new ArrayElement(this.contents ++ that.contents)   ----> refactor with factory

  def beside(that: Element): Element =
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

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"

}

//All classes are now private and we can use only factory to get it
//And we can delete other implementations of this classes

object Element{

  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElements(s: String) extends Element{
    val contents = Array(s)

    // == val height: Int  = contents.length
    override def width: Int = s.length

    //declared method
    override def height: Int = 1
  }

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends Element{
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElements(line)

}
