package trait

import common.MenuItem
import groovy.transform.ToString

import java.time.LocalDate

trait HasList {
    List<MenuItem> listDelegate = []
    boolean add(MenuItem item) { listDelegate.add(item) }
    boolean any(Closure predicate) { listDelegate.any(predicate) }
    boolean contains(MenuItem item) { listDelegate.contains(item) }
}

trait HasDate {
    LocalDate dateDelegate
    boolean isBefore(LocalDate other) { dateDelegate.isBefore(other) }
}

@ToString(includeNames = true)
class Menu implements HasList, HasDate {
    Menu(LocalDate date) { dateDelegate = date }
}

def italianWednesday = new Menu(LocalDate.of(2024, 1, 24)).tap {
    add(new MenuItem('Spaghetti Bolognese', 10))
    add(new MenuItem('Gnocchi di Patate', 11))
    add(new MenuItem('Tiramisù', 9))
}

def italianThursday = new Menu(LocalDate.of(2024, 1, 25)).tap {
    add(new MenuItem('Fettuccine al Pomodoro', 12))
    add(new MenuItem('Pizza Margherita', 10))
    add(new MenuItem('Pannacotta', 10))
}

assert !italianWednesday.any{ italianThursday.contains(it) }
assert italianWednesday.isBefore(italianThursday.dateDelegate)
