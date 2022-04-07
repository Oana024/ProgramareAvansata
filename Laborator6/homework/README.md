Pentru a putea incepe jocul am generat random stick-uri care sunt marcate pe tabla de joc ca fiind mai groase decat liniile obisnuite. Am creat clasa *Stick* care retine toate coordonatele necesare desenarii stick-ului (x1, y1, x2, y2). In *DrawingPanel* am creat o lista de astfel de obiecte de tip *Stick* pentru a le salva pe cele generate random.

Dupa ce au fost generate stick-urile jocul poate incepe. Incepe jucatorul albastru caruia in este permis ca prima mutare sa aleaga orice nod incident cu un stick. 
De fiecare data cand se apasa click, cu ajutorul metodei *verify* se verifica urmatoarele lucruri:

1. Daca s-a apasat click in interiorul unui nod cu ajutorul metodei *isIntersection()*. Se va verifica pentru fiecare stick daca coordonatele nodului corespund cu unul dintre capete. In caz afirmativ se trece la pasul 2.
2. Urmatoarea verificare se face prin intermediul metodei *freeNode()* care verifica daca nodul ales nu este deja colorat. Pentru asta este suficient sa se parcurga lista de noduri si sa se verifice daca corespunde vreo unul cu cel ales la momentul curent. Daca nodul este disponibil se trece la pasul 3.
3. Ultima verificare este cea a faptului ca nodul ales este adiacent cu unul de culoare opusa. Aici utilizam metoda *isNeighbor()*. Astfel pentru nodul curent verificam ce se gaseste in capatul opus al tuturor stick-urilor cu care este incident nodul pe care dorim sa-l alegem. Poate fi un nod necolorat, unul colorat cu aceeasi culoare si unul de culoare opusa. Putem alege nodul doar daca vecinul sau este de culoare opusa. Daca suntem in cazul in care am gasit nod adiacent de culoare opusa, nodul va fi adaugat pe tabla si in lista de noduri.

Nodurile vor fi stocate intr-o lista de obiecte de tip *Stone*. Un obiect de tip *Stone* are ca atribute coordonatele x si y si culoarea pe care o are. 0 pentru albastru si 1 pentru rosu.

Dupa ce un jucator termina mutarea se verifica in metoda *isPosibleMove()* daca urmatorul jucator poate muta, mai exact daca exista pe tabla de joc un nod necolorat adiacent cu unul de culoare opusa. Daca nu exista inseamna ca jocul s-a terminat si este afisat castigatorul cu un mesaj de forma "Jucatorul [rosu/albastru] a castigat".

In plus, in orice moment al jocului se poate exporta imaginea curenta a tablei de joc intr-un fisier de tip PNG prin apasarea butonului "Export as PNG" din partea de jos a frame-ului. Imaginea jocului va se va gasi in fisierul *drawing.png*.

Dupa ce un joc s-a terminat sau chiar in timpului unui joc se poate crea o tabla noua de joc. Tot ce trebuie facut este sa fie alease dimensiunile folosind cele 2 sprinnere din partea de sus, iar apoi trebuie apasat butonul "Create" din dreapta spinnerelor.