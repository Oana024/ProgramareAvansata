Am modelat problema folosind doua clase: *Street* si *Intersection*. *Intersection* are un singur atribut: numele intersectiei. *Street* are numele strazii, lungimea strazii (in km) si cele 2 intersectii pe care le leaga.


Am creat si afisat intersectiile si strazile din exemplu. Intersectiile le-am salvat intr-un ArrayList, iar strazile intr-un LinkedList. Intersectiile au fost sortate dupa nume, iar strazile dupa lungime.

Am creat un HashMap care contine o intersectie drept cheie, iar valoare este un Array de strazi care sunt incidentele cu intersectia. Pentru asta am parcurs pentru fiecare intersectie lista de noduri si am adaugat intr-un Array strazile care contin la unul din capete intersectia. La final am adaugat in HashMap Array-ul de strazi creat. 