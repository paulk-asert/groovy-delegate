package plain

import common.MenuItem

var spanishTapas = [
    new MenuItem('Gambas al ajillo', 8),
    new MenuItem('Tortilla de patatas', 6),
    new MenuItem('Calamares a la romana', 7)
]

assert spanishTapas.size() == 3
assert spanishTapas[0].price == 8
assert spanishTapas[-1].name.startsWith('Calamares')
assert spanishTapas.every{it.price < 10 }
