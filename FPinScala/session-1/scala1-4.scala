/*
 参照透過性 ->
   関数の結果型に従い、「関数が実行するすべてのことがその戻り知によって表される」という不変条件が適用されます。
   -> この制約により、置換モデルと呼ばれるプログラム評価の単純かつ自然な論証が可能になります。
 */

// ====================
// Shell上での実行
// ====================

val x = "Hello, World"
val r1 = x.reverse
// r1: String = dlroW ,olleH
val r2 = x.reverse
// r2: String = dlroW ,olleH
// --------------------------

/*
 読書メモ:
   このあたりはRubyのreverseとreverse!に関連する話題の
   ように感じる。実際に、次に出てくる話題は、その辺りと
   関連しているように感じる
 */

val x = new StringBuilder("Hello")
val y = x.append(", World")
val r1 = y.toString
val r2 = y.toString

/*

読書メモ:
  この段階においては、両者とも同じ値になっていることが
  確認できるのだが、しかし、次の瞬間に、このアプローチが
  副作用を持っていることが露呈する

*/

val x = new StringBuilder("Hello")
val r1 = x.append(", World").toString
val r2 = x.append(", World").toString
// r2: String = Hello, World, World

/*
読書メモ:
  問題は、xが既に`new StringBuilder`で生成された
  インスタンスの参照ということになっているということだ。

  参照になっているということは、それに対して破壊的な
  行った場合、他の変数にも、その変更が波及してしまうことを
  意味している。

  そして、このようにあるインスタンスを「破壊的に更新」する
  ことは、全体の挙動に依存することであり、その「束縛のみ」で
  結果を把握することが難しくなることを証明する
 */
