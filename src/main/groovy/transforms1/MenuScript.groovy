package transforms1

import common.MenuItem
import groovy.transform.TupleConstructor

import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

@TupleConstructor(includes='date')
class Menu {
    @Delegate
    final ArrayList<MenuItem> items = []
    @Delegate
    final LocalDate date
}

def bistroTuesday = new Menu(LocalDate.of(2024, 1, 16)).tap {
    add(new MenuItem('Tacos', 12))
    add(new MenuItem('Chicken Parma', 15))
}
def bistroFriday = new Menu(LocalDate.of(2024, 1, 19)).tap {
    add(new MenuItem('Chicken Parma', 15))
    add(new MenuItem('Fish & Chips', 12))
}

assert bistroTuesday.any{ bistroFriday.contains(it) }
assert bistroTuesday.isBefore(bistroFriday)
assert bistroTuesday instanceof List
assert bistroFriday instanceof ChronoLocalDate
