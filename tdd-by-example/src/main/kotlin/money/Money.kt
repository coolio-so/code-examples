package money

abstract class Money(protected val amount: Int, protected val currency: String) {
    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Franc(amount, "CHF")
        }
    }

    abstract fun times(multiplier: Int): Money

    fun currency(): String {
        return this.currency
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount
    }
}

class Dollar(amount: Int, currency: String): Money(amount, currency) {
    override fun times(multiplier: Int): Money {
        return dollar(this.amount * multiplier)
    }
}

class Franc(amount: Int, currency: String): Money(amount, currency) {
    override fun times(multiplier: Int): Money {
        return franc(this.amount * multiplier)
    }
}
