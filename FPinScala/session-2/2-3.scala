object MyModule {
  /*
   findFirst函数については、Intであっても、Stringであっても
   一緒のロジックになることが予測される。なので、これは多相型
   の函数にすればいい、と予測される。

   最初は

   >> def findFirst(ss: Array[String], key: String): Int

   という定義だった。また、検索方法に関しても、
   函数で検索方法を指定できると良いだろう。そうした場合、
   下のような函数を書くことが可能になる

   >> findFirst(testarray, (x: Int) => x == 9))

   このとき、

   >> (x: Int) => x == 9
   res1: Int => Boolean = <function1>

   は、函数リテラル(無名函数)とも呼ばれる。このときの
   <functionN>のNは引数の数となる

   */
  def findFirst[A](ss: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (p(ss(n))) n
      else loop(n + 1)
    loop(0)
  }

  def partial1[A, B, C](a: A, f:(A, B) => C): B => C =
    (b: B) => f(a, b)

  /* EXERCISE 2.2 */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean =
    if ( as.length < 2 )
      true
    else if (ordered(as.head, as(1)))
      isSorted(as.tail, ordered)
    else
      false

  /* EXERCISE 2.3 */
  def curry[A, B, C](f: (A, B) => C):A => (B => C) =
    (a: A) => (b: B) => f(a, b)

  /* EXERCISE 2.4 */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  /* EXERCISE 2.5 */
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (x:A) => f(g(x))
}
