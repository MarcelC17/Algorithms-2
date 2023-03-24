def straight(): Double => Double = {
 x => 2*x
}

def shiftOY(line: Double => Double, delta_y: Double): Double => Double = {
   x => line(x) + delta_y
}

shiftOY(straight(), 1)
res0(1)

def shiftOX(line: Double => Double, delta_x: Double): Double => Double = {
  x => line(delta_x + x)
}

shiftOX(straight(), 1)
res2(1)

def intersect(line1: Double => Double, line2: Double => Double)(start: Int, stop: Int): Boolean = {
  def tailIntersect(crt: Int): Boolean ={
    if (line1(crt) == line2(crt)) true
    else if(crt == stop) false
    else tailIntersect(crt+1)
  }

  tailIntersect(start)
}