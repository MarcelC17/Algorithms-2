def fact (n: Int): Int = {
  def aux_fact(n: Int, acc: Int): Int =
    if (n == 0) acc
    else aux_fact(n-1, n * acc)
  aux_fact(n,1)
}

fact(3)
fact(1)
fact(0)

def gcd(a: Int, b: Int): Int = {
  def gcdTailRec(x: Int, y: Int): Int = {
    if (y == 0) x
    else gcdTailRec(y, x % y)
  }
    gcdTailRec(a, b)
}


gcd(9, 3)
gcd(18,30)
gcd(30,18)
gcd(30,1)

def sumSquares(n: Int): Int = {
  def aux_sum(n: Int, acc: Int): Int = {
    if (n==0) acc
    else aux_sum(n-1, n*n+acc)
  }

  aux_sum(n, 0);
}

sumSquares(19)

def sumNats(start: Int, stop: Int): Int = if (start == stop) stop
else if (start < stop) start + sumNats(start+1, stop)
else if (start > stop) 0 else 0

def tailSumNats(start: Int, stop: Int): Int = {
  def aux_sum(start: Int, stop: Int, acc: Int): Int =
    {
      if (start == stop) acc + start
      else if (start < stop) aux_sum(start+1, stop, acc+ start)
      else 0
    }
  aux_sum(start, stop, 0)
}

sumNats(6, 100)
sumNats(6, 2)

tailSumNats(6, 100)

def sumPrimes(start: Int, stop: Int): Int = {
  def vefPrime(num:Int):Boolean = {
    def isPrime(num:Int,acc:Int):Boolean = {
      if(num == acc) true
      else if(num % acc == 0 && acc > 1) false
      else isPrime(num,acc + 1)
    }

    isPrime(num,1)
  }

  def aux_sum(start:Int,stop:Int,acc:Int):Int = {
    if(start == stop) {
      if (vefPrime(start)) acc+start
      else start
    }
    else if(start < stop){
      if (vefPrime(start)) aux_sum(start + 1,stop,acc + start)
      else aux_sum(start + 1,stop,acc)
    }
    else 0
  }

  aux_sum(start,stop,0)
}

sumPrimes(2, 5)

def improvet(xn: Double, a: Double): Double = {
  0.5 * (xn+a/xn)
}

def nth_guess(n: Int, a: Double): Double = {
  def calcG(n:Int , xn: Double, a: Double): Double ={
    if (n==0) xn
    else calcG(n-1, improvet(xn,a), a)
  }

  calcG(n, 0, a)
}

def acceptablet(xn: Double, a: Double): Boolean = {
  if ((xn*xn - a).abs <= 0.001) true
  else false
}

def mySqrt(a: Double): Double = {
  def improve(xn: Double): Double = improvet(xn, a)
  def acceptable(xn: Double): Boolean = acceptablet(xn, a)

  def tailSqrt(estimate: Double): Double = {
    if (acceptable(estimate)) estimate
    else tailSqrt(improve(estimate))
  }

  tailSqrt(0);
}

mySqrt(1.doubleValue())