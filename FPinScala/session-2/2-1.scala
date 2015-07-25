/*
 まず最初に、Scala言語について、どのようなものになっているか
 を説明する章となっている
 */

object MyModule {
  /*
   if式を含めて、全ての式が結果を返す。このとき、右辺を
   評価した結果の値がメソッドから返される値になる。
   これによって、メソッドを簡潔に定義することが可能になる
   */
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  /*
   複数ステートメントが存在している場合、`{}`でくくるように
   する。

   また、ここでこの関数がreturnする型が明示されていないが、
   これは型を推論してくれるためである。実際に:

   >> private def formatAbs(x: Int): String = {

   と明示しても構わない。また、関数型Scalaによれば、これは
   private methodなので、型アノテーションを省略しても
   構わない、とのこと。
   */

  private def formatAbs(x: Int) = {
    /*
     valは再代入できない、一回限りの代入を示す。
     従って、別の値を代入しようとするとエラーになる。

     もちろん、これに関しては
     >> private def formatAbs(x: Int) =
     >>  "The absolute value of %d is %d".format(x, abs(x))
     といった、見慣れたメソッドチェインとしても書くことが可能
     であり、この場合は一行で済む。

     この場合は、valとその値を明確にするために、わざと
     valに代入していると考えられる
     */
  }

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
}
