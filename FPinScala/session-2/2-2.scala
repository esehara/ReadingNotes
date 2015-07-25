object MyModule {

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial (n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc else go(n-1, n*acc)
    // 末尾最適化が行われている
    go(n, 1)
  }


  /*
   例えば、一つの方法として:

   >> private def formatAbs(x: Int)
   >> private def formatFactorial(n: Int)

   という、二つのメソッドを定義することも
   考えることができるが、むしろそれよりかは抽象化したほうが
   早いだろう。そこで高階函数を扱えるようにする。

   Int => Intは、Haskell的な、何の引数を取り、何の値を返す
   函数か、ということになる。

   */
  def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
  }
}
