object MyModule {
  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n * acc)
    go(n, 1)
  }

  /* EXERCISE 2.1 */
  def fib(n: Int): Int = {
    def go(p: Int, n: Int, x:Int, m:Int): Int =
      if (x < m) go(n, p + n, x + 1, m)
      else p
    go(0, 1, 0, n)
  }
}
