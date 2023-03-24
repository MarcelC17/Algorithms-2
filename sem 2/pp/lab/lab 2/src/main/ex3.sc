//
def multiply(x:Int)(y:Int): Int = x*y

multiply(1)(2)

def compare(x: Int)(y: Int)(z: Int): Int = {
  if (x > y && x > z)
    x
  else if (y > x && y > z)
    y
  else
    z
}

compare(2)(3)(4)



