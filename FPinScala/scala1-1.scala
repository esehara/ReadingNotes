class Cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee()
    cc.charge(cup.price)
    /*
     重要な点:

     本書では、cc.chargeで、CreditCardの問い合わせするためのモデルとして
     想定されている。ここで`cup.price`をCreditCardにチャージするということは、
     問い合わせが行われるということであり、副作用が発生するということである.

     CreditCard -> 外部問い合わせ
     */
    cup
    // Scalaでは最後の文字列は暗黙のreturnになる
  }
}
