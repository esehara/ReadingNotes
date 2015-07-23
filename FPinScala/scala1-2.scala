class Cafe {
  def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
    val cup = new Coffee()
    p.charge(cc, cup.price)
    /*
     scala1-1では、CreditCardのチャージをそのまま呼び出していたため、
     テストが困難になるということがあった。従って、一度Paymentsクラスで
     ラップしてあげることによって、まだ副作用は残るものの、CreditCard
     の問い合わせをしないモックにすることが出来る。

     しかし、この実装の問題は、問い合わせが複数回ある場合である。複数回
     問い合わせがあるたびに、別々にこれらをチャージしなくてはならない。
     単純に非効率なだけでなく、実装として綺麗でもない。
     */
    cup
  }
}
