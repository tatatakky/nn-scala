package com.github.tatatakky.ml.nn

import com.github.tatatakky.ml.nn.FunctionTool.Functions

import scala.math._
import scala.io._

object Nn {

  val inputNum = 2

  def readFileToList(e: String): List[List[Double]] = {
    var a: List[List[Double]] = Nil
    for (line <- Source.fromFile(e).getLines) {
      a = line.split(" ").toList.map(f => f.toDouble) :: a
    }
    a.reverse
  }

  def theDataLength[T](data: List[List[T]]): Int = data.length

  def sigmoid(u: Double): Double = 1/(1 + exp(-u))

  def forward(w: List[Double], data: List[Double]): Double = {
    var u: Double = 0.0
    for(x <- 0 until inputNum){
      u += data(x) * w(x)
    }
    u -= w(inputNum)
    sigmoid(u)
  }

  def output(w: List[Double], data: List[List[Double]], dataLength: Int) = {
    for (x <- 0 until dataLength){
      print(x + " -> ")
      for (y <- 0 until inputNum) {
        print(data(x)(y) + " ")
      }
      println(forward(w, data(x)))
    }
  }

  def main(args: Array[String]): Unit = {
    val w: List[Double] = List(1.0, 1.0, 1.5)
    val data: List[List[Double]] = readFileToList("/Users/kodai/scala/MachineLearning/src/main/scala/com/github/tatatakky/ml/nn/data24.txt")
    val dataLength: Int = theDataLength(data)
    output(w, data, dataLength)
  }
}
