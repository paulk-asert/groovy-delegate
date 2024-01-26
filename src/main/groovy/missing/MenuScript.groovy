package missing

import common.MenuItem

class Menu {
    private ArrayList<MenuItem> delegate = []

    def findByPrice(int price) {
        delegate.find{ it.price == price }
    }

    def methodMissing(String name, args) {
        delegate."$name"(*args)
    }
}

def frenchBakery = new Menu().tap {
    add(new MenuItem('Croissant', 4))
    add(new MenuItem('Baguette', 5))
}

assert frenchBakery[0].price == 4
assert frenchBakery.size() == 2
assert frenchBakery.findByPrice(4).name == 'Croissant'
