## Aplikacija za propitivanje studenata iz predmeta Baze podataka

#### Uvod

Aplikacija je trenutno u fazi pravljenja.  
Za sada je podrzano da se generise lista pitanja za zadati zadatak.  
Kao test podaci, ubaceni su 2 zadatka, pitanja su za sada tipa gde se nalazi koji entitet, ovo ce biti prosireno kasnije.

#### Otvorene rute
Lista svih zadataka: `/v1/assignment/all`  
Tekst zadatka: `/v1/assignment/{id}/text`, *id* - id zadatka  
Dohvatanje liste pitanja: `/v1/assignment/{id}/questions`, *id* - id zadatka  

#### Ostalo
Postoji swagger `/swagger-ui.html`