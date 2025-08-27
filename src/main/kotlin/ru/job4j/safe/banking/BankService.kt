package ru.job4j.safe.banking

class BankService {
    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user: User = findByPassport(passport) ?: return null
        /*
        * Возможно это неоптимально по производительности,
        * но на три ретёрна в функции детект уже ругается
        * */
        return users.getOrDefault(user, emptyList())
            .stream()
            .filter { account: Account? -> account?.requisite.equals(requisite) }
            .findFirst()
            .orElse(null)
    }

    fun addAccount(passport: String, account: Account) {
        val user: User = findByPassport(passport) ?: return
        users[user]?.add(account)
    }


    fun findByPassport(passport: String): User? {
        for (user in users.keys) {
            if (user.passport.equals(passport)) {
                return user
            }
        }
        return null
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, descRequisite: String, amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)
        val rsl = source != null && dest != null
        if (rsl) {
            source!!.balance -= amount
            dest!!.balance += amount
        }
        return rsl
    }

}

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev"))
    var user: User? = bank.findByPassport("3211")
    println(user?.username)
    user = bank.findByPassport("321")
    println(user?.username)
}
