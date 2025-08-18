package ru.job4j.lambda

fun filterAccounts(accounts: List<Account>) :List<Account>
= accounts.filter { "Ivan".equals(it.name) && it.balance > 0  }

