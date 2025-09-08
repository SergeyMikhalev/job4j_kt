package ru.job4j.safe.banking

class BankService {
    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport: String, requisite: String): Account {
        val user: User = findByPassport(passport)
        return users.getOrDefault(user, emptyList())
            .stream()
            .filter { account: Account? -> account?.requisite.equals(requisite) }
            .findFirst()
            .orElseThrow { NoSuchElementException("Аккаунт, соответствующий реквизитам не найден : $requisite") }
    }

    fun addAccount(passport: String, account: Account) {
        val user: User = findByPassport(passport)
        users[user]?.add(account)
    }


    fun findByPassport(passport: String): User {
        for (user in users.keys) {
            if (user.passport.equals(passport)) {
                return user
            }
        }
        throw NoSuchElementException("Пользователь с соответствующим паспортом не найден : $passport")
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, descRequisite: String, amount: Double
    ) {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)

        source.balance -= amount
        dest.balance += amount
    }

}

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev"))
    var user: User

    try {
        user = bank.findByPassport("3211")
        println(user.username)
    } catch (e: NoSuchElementException) {
        println(e.message)
    }

    try {
        user = bank.findByPassport("321")
        println(user.username)
    } catch (e: NoSuchElementException) {
        println(e.message)
    }
}
