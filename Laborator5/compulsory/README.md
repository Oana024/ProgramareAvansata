Am creat clasele *Catalog*, *Item*, *CatalogUtil*. Am creat si clasele *Book* si *Article* care mostenesc clasa *Item* care este abstracta.

In clasa *Catalog* am adaugat metoda *add(Item item)* care adauga in catalog item-ul *item*.

Folosind biblioteca third-party *Jackson* am implementat metodele *save* si *load* in clasa *CatalogUtil*, metode care salveaza, respectiv incarca instante ale catalogului. 