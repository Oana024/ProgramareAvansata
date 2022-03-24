Am creat clasa *City* care contine un Map care are drept cheie o intersectie, valoarea fiind o lista de strazi, mai exact strazile incidente cu intersectia. Fiecare intersectie va avea un *index*, reprezentand numarul intersectiei.

Am creat metoda *Filter(int length)* care va afisa doar strazile care au minim lungimea *length* si care intersecteaza alte minim 3 strazi.

Am folosit biblioteca third-party *_Java Faker_* pentru a genera nume random pentru intersectii si strazi.

Pentru a rezolva problema (ce strazi trebuie alese astfel incat costul total pentru a instala cablurile sa fie minim) am folosit algoritmul lui Kruskal, pe care l-am implementat in clasa *Algorithm*.
Metoda *Kruskal* are ca argumente numarul de noduri(intersectiile) si o lista de muchii(strazile). Muchiile sunt ordonate crescator dupa costuri, astfel voi lua pe rand fiecare strada si voi verifica daca capetele acesteia fac pare din aceeasi componenta conexa. In caz afirmativ, nu adaug muchia la solutie pentru ca adaugarea acesteia ar duce la aparitia unui circuit, scopul fiind gasirea unui arbore partial de cost minim.
La final se va afisa costul si muchiile care strazile alese.