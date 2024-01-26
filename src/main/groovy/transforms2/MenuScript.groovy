package transforms2

import common.MenuItem

class Menu {
    @Delegate(includes='add,forEach,get,size', interfaces=false)
    final ArrayList<MenuItem> items = []
}

def japanese = new Menu().tap {
    add(new MenuItem('Sushi', 8))
    add(new MenuItem('Vegetarian Ramen', 12))
    add(new MenuItem('Vegetable Gyoza', 12))
    add(new MenuItem('Teriyaki Tofu', 12))
}

assert japanese.size() == 4
japanese.forEach{ it.price % 4 == 0 }
assert japanese.get(3).price == 12
assert japanese !instanceof List
