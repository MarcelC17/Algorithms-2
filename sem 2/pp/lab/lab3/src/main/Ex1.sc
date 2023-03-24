def atLeastk(k: Int, l: List[Int]): Boolean = {

  if (k == 0) true
  else l match {
    case Nil => false
    case _::xs => atLeastk(k-1, xs)
  }
}

val nums: List[Int] = List(1, 2, 3, 4)

atLeastk(5,nums)



def take(n: Int, l: List[Int]): List[Int] = {
    if (n == 0) Nil
   l.foldRight(Nil)()

}
take(2, nums)

//def atLeastkPred(pred: Int => Boolean)(k: Int, l: List[Int]): Boolean = {
//
//}

