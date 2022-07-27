# DA Challenge - Fruit
L'applicazione fruit espone i seguenti endpoint rest:
- `/api/fruits?maxCalories=:maxCalories` (Data una quantità massima di calorie restituisce la lista di tutti i frutti con calorie minori)
- `/api/fruits/nutritions/differences?fruit1Name=:fruit1Name&fruit2Name=:fruit2Name` (Dati due nomi di frutti restituisce la differenza di tutti i valori nutrizionali)
- `/api/fruits/nutritions/average?family=:family` (Dato un nome famiglia restituisce la media di tutti i valori nutrizionali dei frutti appartenenti alla famiglia)

# Approccio
L'applicazione è sviluppata in java e creata utilizzando il framework spring-boot versione 2.7.2.
È utilizzato un database in memoria h2 inizializzato all'avvio dell'applicazione con un set di dati che permette di testare le api.


# Avvio in locale
Per poter eseguire l'applicazione è sufficiente:
- eseguire la build con maven: `mvn clean package`
- avviare il jar prodotto dentro la folder `target` con `java -jar fruit-0.0.1-SNAPSHOT.jar`

## Esempi per test API in locale

- [http://localhost:8080/api/fruits?maxCalories=40]()
- [http://localhost:8080/api/fruits/nutritions/differences?fruit1Name=Apple&fruit2Name=Banana]()
- [http://localhost:8080/api/fruits/nutritions/average?family=Rosaceae]()