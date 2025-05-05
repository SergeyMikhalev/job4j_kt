package ru.job4j.oop


import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class TrackerTest {

    @Test
    fun whenFindAll() {
        val tracker = Tracker();
        val item1 = Item(name ="Valera")
        val item2 = Item(name ="Igor")

        tracker.add(item1);
        tracker.add(item2);

        assertThat(tracker.findAll().size).isEqualTo(2)
    }

    @Test
    fun whenFindByName() {
        val tracker = Tracker();
        val item1 = Item(name = "Vera")
        val item2 = Item(name = "Vera")
        val item3 = Item(name = "Nikolay")

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        assertThat(tracker.findByName("Valera").size).isEqualTo(0)
        assertThat(tracker.findByName("Vera").size).isEqualTo(2)
    }

    @Test
    fun whenFindById() {
        val tracker = Tracker();
        val item1 = Item(name ="Valera")
        val item2 = Item(name ="Igor")

        val savedItem = tracker.add(item1);
        tracker.add(item2);

        assertThat(tracker.findById(savedItem.id)?.name).isEqualTo("Valera")
    }

    @Test
    fun whenReplace() {
        val tracker = Tracker();
        val item1 = Item(name = "Vera")
        val item2 = Item(name ="Valera")
        val item3 = Item(name ="Nikolay")

        val savedVera = tracker.add(item1)
        tracker.add(item3)

        tracker.replace(savedVera.id, item2)

        assertThat(tracker.findByName("Vera")).isEmpty()
        assertThat(tracker.findById(savedVera.id)?.name).isEqualTo("Valera")
    }

    @Test
    fun whenDelete() {
        val tracker = Tracker();
        val item1 = Item(name ="Vera")
        val item2 = Item(name ="Valera")


        val savedItem = tracker.add(item1);
        tracker.add(item2)
        tracker.delete(savedItem.id)

        assertThat(tracker.findByName("Vera")).isEmpty()
        assertThat(tracker.findById(savedItem.id)).isNull()
    }

}
