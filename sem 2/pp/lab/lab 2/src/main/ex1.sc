def apply(n: Int, f: Int => Int): Int = {
  f(n)
}

def doubler(): Int => Int = {
 x => x*2
}

apply(2,doubler())





