def doubler(): Int => Int = {
  x => x*2
}

//ex 2.1
def addition(): (Int, Int) => Int = {
  (x, y) => x + y
}

def foldWith(op: (Int, Int) => Int)(start: Int, stop: Int): Int = {
  def tail_fold(crt: Int, acc: Int): Int = {
    if (crt == start) op(crt, acc)
    else op(tail_fold(crt - 1, acc), crt)
  }

  tail_fold(stop, 0)
}


foldWith(addition())(1, 3)



//ex 2.2

def isEven(): Int => Boolean = {
  x => x % 2 == 0
}

def foldConditional(op: (Int, Int) => Int, p: Int => Boolean)(start: Int, stop: Int): Int = {
  def tail_foldConditional(crt: Int, acc: Int): Int = {
    if (crt == start) {
      if (p(crt))
        op(crt, acc)
      else acc
    }
    else if (p(crt))
      op(tail_foldConditional(crt - 1, acc), crt)
    else tail_foldConditional(crt - 1, acc)
  }

  tail_foldConditional(stop, 0)
}

foldConditional(addition(), isEven())(1, 3)

//2.3
def foldMap(op: (Int, Int) => Int, f: Int => Int)(start: Int, stop: Int): Int = {

  def tail_foldMap(crt: Int, acc: Int): Int = {
    if (crt == start) op(f(crt), acc)
    else op(tail_foldMap(crt - 1, acc), f(crt))
  }

  tail_foldMap(stop, 0)
}

foldMap(addition(), doubler)(1, 3)