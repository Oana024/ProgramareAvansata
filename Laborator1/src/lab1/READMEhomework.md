Verific sa fie minim 3 argumente: n, p si minim o litera pentru alfabetul care va vi utilizat.
Folosind alfabetul primit ca argument generez n cuvinte distincte prin intermediul functiei getRandomString() care va alege p litere random din alfabetul de intrare. La final afisez cuvintele obtinute.
Declar o matrice n x n pentru a salva matricea de adiacenta a cuvintelor generate (doua cuvinte sunt adiacente daca au cel putin o litera in comun).
Declar o structura de date ArrayList<ArrayList> pentru a salva pentru fiecare cuvant, lista cuvintelor vecine.
In final, pentru valori mai mari ale lui n ( n >= 30000) afisez timpul de executie in nanosecunde, iar pentru valori n < 30000 afisez structura de date creata.
