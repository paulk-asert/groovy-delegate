package explicit

import common.MenuItem

class Menu {
    private ArrayList<MenuItem> delegate = []

    MenuItem findByPrice(int price) {
        delegate.find{ it.price == price }
    }

    boolean add(MenuItem newItem) {
        delegate.add(newItem)
    }

    MenuItem getAt(int index) {
        delegate[index]
    }

    int size() {
        delegate.size()
    }
}

def vietnamese = new Menu().tap {
    add(new MenuItem('Phở', 7))
    add(new MenuItem('Bánh Mì', 5))
}

assert vietnamese[0].price == 7
assert vietnamese.size() == 2
assert vietnamese.findByPrice(7).name == 'Phở'
