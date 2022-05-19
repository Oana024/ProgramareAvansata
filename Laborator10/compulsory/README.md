Am creat 2 proiecte separate *Client* si *Server*.
In server am implementat clasa SimpleServer care se ocupa cu crearea socketului pentru server. Server-ul va functiona cat timp variabila running este true.
In server exista si clasa ClientThread care se ocupa de clientii care se conecteaza la server.
In client clasa SimpleClient se ocupa de conexiunea de server, citeste un mesaj din consola, il trimite la server, server-ul verifica si daca mesajul este "stop" va opri server-ul. Clientul va primi inapoi un mesaj de genul "Mesjul este" + ce a trimis catre server.
