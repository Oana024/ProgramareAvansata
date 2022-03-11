Am transformat clasa Room intr-o clasa abstracta si am creat alte 2 clase LectureHall si ComputerLab care mostenesc clasa Room. Pe langa asta cele 2 clase au si atribute proprii cum ar fi *projector* care indica faptul ca sala are sau nu video proiector si *operatingSystem* care retine sistemul de operare al calculatoarelor din laborator.
Am creat clasa Problem care descrie instanta problemei: salile si evenimentele pentru care se doreste gasirea unei solutii astfel incat fiecarui eveniment sa ii fie atribuita o sala.
In clasa Solution, prin intermediul vectorului *assignment* care retine obiecte de tip Room si *events* care retine obiecte de tip Event, dupa ce problema este rezolvata, voi afisa pentru fiecare eveniment ce sala i-a fost atribuita.
Clasa GreedyAlgorithm mosteneste clasa Algorithm si descrie un algoritm de tip greedy pentru rezolvarea problemei. Am folosit un algoritm inspirat din "problema spectacolelor".
Pentru acest algoritm sortez crescator vectorul de evenimente dupa ora de final si vectorul de sali dupa capacitate. Voi folosi un vector *used*, unde *used[i]* retine de cate ori a fost folosita sala i. Initial toate valorile vectorului sunt 0. Vectorul de Room *usedRooms* va retine pentru fiecare eveniment i ce sala ii este atribuita. Variabila *hourInterval* va reprezenta numarul de intervale orare diferite ale evenimentelor, iar atunci cand aceasta variabila este incrementata inseamna ca am ajuns la alte intervale orare si pot reutiliza sali in care evenimentele s-au terminat. 
Parcurg toate evenimentele si incerc sa ii gasesc sala potrivita alegand prima sala care are capacitate suficienta si nu este deja ocupata.
Daca la final toate evenimentele au sali atribuite afisez solutia gasita, in caz contrar afisez mesajul "Nu am reusit sa gasesc o atribuire".