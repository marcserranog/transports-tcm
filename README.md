# TRANSPORT TCM 

<ins>Project developed with **JAVA**, **SPRING** and **MYSQL** by Marc Serrano</ins>

> A university project consisting of a lorry company specialising in the transport of frozen food throughout Spain. 
The project is in a private repository of the university subject. But the development is all done by me. 

Transports TCM es una empresa de transport especialitzada en congelats. 
 
Disposen de camions que poden transportar una capacitat (KG) d’aliment congelat.

Els camions recullen l’aliment d’una central l’entreguen un altre magatzem. En tenen cinc per tot España, en les següents ciutats:
Barcelona, Valencia, Madrid, Sevilla, Vigo.

Cada camió, al sortir d’origen, necessita saber ja el seu destí i portar una carrega de mínim un 30% de la seva capacitat màxima. La capacitat màxima son 200 KG.
 
Cal tenir en compte que l’aliment està a -20 ºC i, a mesura que passa el temps, es va escalfant. De fet, la seva temperatura puja 3 ºC per cada hora. Mai es podrà superar la temperatura de 0ºC o el menjà s’hauria de tirar.
 
Un camió de mitja va a 100 km per hora i consumeix 20l per cada 100 km. El tanc de gasolina té una capacitat de 150L.
 
Si s’ha de fer un trajecte superior, per exemple, Barcelona-Vigo, el propi camió ajustarà la ruta per parar a tants magatzems com faci falta perquè pugui arribar a destí sense afectar a l’aliment.  
 
Un camió que para en un magatzem, ha d’estar allà 5h parat per refrigerar l’aliment i carrega la gasolina que li càpiga.
 
Al arribar a destí, s’ha de recarregar el camió de gasolina fins deixar-lo ple de nou.

Les distàncies són les següents:
 
 <img width="717" alt="image" src="https://github.com/user-attachments/assets/a69228f7-5115-4486-b88b-7fe80c8411f1" />

Quan un camió realitza un desplaçament, s’ha de deixar constància del cost i el temps total del transport. Per calcular-l’ho es tenen en compte els següents factors:
 
-   	Preu conductor: el conductor cobra 15€ per hora.
 
-   	Gasolina: el preu de la gasolina és 2€/l. S’ha de calcular la gasolina consumida.
 
-   	Carregar i descarregar el camió: 200€. Cada cop que es carrega o es descarrega el camió, s’ha de sumar aquest import. 

És a dir, si fem per exemple Barcelona - Valencia - Madrid serien, 200€ de carregar el camió, parem a Valencia, 200€ de descarregar. 5h més tard tornem a carregar el camió, 200€ més i arribem a Madrid on descarregarem, que seràn 200€ més. És a dir, el cost total de la carrega i descarrega és de 800€.
