class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
    /*
     下手にこの段階でchargeするよりも、CoffeeとChargeのペアとして返す
     ようにする。Chargeはデータ型である。このあとに、その定義を書く。
     */
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List [(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    /*
     List.fill(n)はxのコピーをn個含んだListを作成する
     ex. List.fill(10)("foobar")

     この場合、一度valで束縛させることによって、どのようなリストが型として
     作成されているのかが見やすくなっている。valによって、結果を短く保つことも
     重要な要素の一つのように感じる
     */

    /* ** 間違い **
     ------------------ unzipは引数を取らないヨ!
    val (coffee, charges) = purchases.unzip(coffees, chages.reduce(
      (c1, c2) => c1.combine(c2)))

     ** 正しい **
     ------------------ 実は最後に返る(returnする)タプル
    
    val (coffee, charges) = purchases.unzip
    (coffees, chages.reduce((c1, c2) => c1.combine(c2)))
    */

    val (coffees, charges) = purchases.unzip
    /*
     単純にコーヒーの種類と、支払いの種類のリストを分割している。
     必要なのは合計金額と、その数に合わせたコーヒーのセットなので、
     そのようにしている
     */


    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
    /*
     まず最初にreduceが存在している。
     reduceは畳み込み。Chargeの構造体によって、次々に合計した金額を
     追加していることがわかる。

     この畳込みの場合、クレジットカードを
     どうするべきか、という問題が出てくるのだが、この場合の
     クレジットカードが違う場合はエラーとなるため、問題がない
     */
  }

}

case class Charge(cc: CreditCard, amount:Double) {
  // case classはnewを使わずに作成できる
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}
