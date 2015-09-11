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
}
