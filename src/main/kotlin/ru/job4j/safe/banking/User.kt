package ru.job4j.safe.banking

data class User(val passport: String, val username: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        return passport == other.passport
    }

    override fun hashCode(): Int {
        return passport.hashCode()
    }
}

