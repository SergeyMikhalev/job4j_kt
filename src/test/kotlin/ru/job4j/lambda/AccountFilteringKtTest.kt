package ru.job4j.lambda

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AccountFilteringKtTest {

  val valera = Account("Valera", 100)
  val igor = Account("Igor", 200)
  val ivan = Account("Ivan", 300)
  val poorIvan = Account("Ivan", 0)

  @Test
  fun whenEmptyListThenEmptyList() {
      assertTrue(filterAccounts(emptyList()).isEmpty())
  }

  @Test
  fun whenNoIvansThenEmptyList() {
      assertTrue(filterAccounts(arrayListOf(valera, igor)).isEmpty())
  }

  @Test
  fun whenPoorIvanThenEmptyList() {
      assertTrue(filterAccounts(arrayListOf(valera, igor, poorIvan)).isEmpty())
  }

  @Test
  fun whenOneIvanWithMoneyThenHePassesFilter() {
      val result = filterAccounts(arrayListOf(valera, ivan, igor, poorIvan))
      assertEquals(result.size, 1)
      assertEquals(result.get(0).balance, 300)
  }


 }
