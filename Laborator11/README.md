Am creat proiectul utilizand spring initializr.
Am creat clasa Person care contine numele si id-ul unei persoane.
Am creat Rest Controller-ul PersonController care contine metode pentru:

*HTTP GET REQUEST* -> afiseaza lista de persoane

*HTTP POST REQUEST* -> adauga o noua persoana

*HTTP PUT REQUEST* -> identifica o persoana prin id si ii afiseaza numele

*HTTP DELETE REQUEST* -> sterge o persoana dupa id

Am creat RestController-ul RelationshipController care contine metode pentru:

*HTTP GET REQUEST* -> afiseaza toate relatiile

*HTTP POST REQUEST* -> adauga o noua relatie

*HTTP DELETE REQUEST* -> sterge o relatie dupa id

In PersonController am creat o metoda getMostPopularKPersons care va afisa cele mai populare k persoane, adica primele k persone sortate descrescator dupa numarul de prieteni pe care ii are.

Cu ajutorul Swagger am facut documentatia serviciilor REST. Aceasta poate fi gasita folosind ruta: http://localhost:8010/swagger-ui.html

Am creat un proiect de tip client care apeleaza serviciile REST din server utilizand RestTemplate.

