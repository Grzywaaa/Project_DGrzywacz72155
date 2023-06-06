import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Klasa Pizza służy do tworzenia obiektu pizzy. Pizza zawiera następujące atrybuty:
name - przechowująca nazwę pizzy, price - przechowujące cenę pizzy, pizzaIngredients - listę składników opartych na Enum,
type - identyfikator pizzy, basePrice - cenę podstawową pizzy (tzw. bazę czy ciasto).
 */
public class Pizza {

 private String name;
 private double price;
 private List<Ingredients> pizzaIngredients;
 private int type;
 private final double basePrice=15;

 /* Istnieją dwa konstruktory - jeden przyjmujący listę składników, który jest
 używany w przypadku tworzenia pizzy z samodzielnym wyborem składników.
 oraz drugi przyjmujący "type" -  obsługujący złożenia zamówienia na zdefiniowaną już pizzę.
 W przypadku drugiego konstruktora przy pomocy konstrukcji switch wywołujemy odpowiednią metodę dla danej pizzy.
 Oba konstruktory tworzą listę składników. Pierwszy z nich tworzy listę na podstawie przekazanej.
 W obu konstruktorach zostaje wywołana funkcja calculatePrice(), która oblicza wartość pizzy i przypisuje ją do ceny. */

 public Pizza(List<Ingredients> pizzaIngredients) {
  this.name = "Custom";
  this.pizzaIngredients = new ArrayList<>(pizzaIngredients);
  this.price = calculatePrice();
 }

 public Pizza(int type) {
  this.pizzaIngredients= new ArrayList<>();
  switch (type) {
   case 1:
    createPizzaCapriciosa();
    break;
   case 2:
    createPizza4sery();
    break;
   case 3:
    createPizzaMargherita();
    break;
  }
  this.price = calculatePrice();
 }

 /* Poniższe metody "createPizza%" pozwalają na zaktualizowanie danych utworzonego obiektu o żądane wartości.
 Są wykorzystywane przy tworzeniu predefiniowanych pizz. Dodają nazwę, typ pizzy (identyfikator) oraz składniki. */

 private void createPizzaCapriciosa() {
  this.name = "Capriciosa";
  this.type = 1;
  this.pizzaIngredients.add(Ingredients.MOZARELLA);
  this.pizzaIngredients.add(Ingredients.SZYNKA);
  this.pizzaIngredients.add(Ingredients.KARCZOCHY);
  this.pizzaIngredients.add(Ingredients.POMIDORY);
 }

 private void createPizza4sery() {
  this.name = "4 sery";
  this.type = 2;
  this.pizzaIngredients.add(Ingredients.MOZARELLA);
  this.pizzaIngredients.add(Ingredients.LAZUR);
  this.pizzaIngredients.add(Ingredients.PARMEZAN);
  this.pizzaIngredients.add(Ingredients.COREGGIO);
 }

 private void createPizzaMargherita() {
  this.name = "Margherita";
  this.type = 3;
  this.pizzaIngredients.add(Ingredients.MOZARELLA);
 }


 /* Metoda calculatePrice pozwala na obliczenie ceny pizzy na podstawie składników oraz ceny bazowej.
 Została wykorzystana pętla iterująca po liście składników, odwołujemy się do gettera składnika getPrice i
 sumujemy wartości dla dostępnych elementów. Zwracamy cenę, która w konstruktorze jest przypisywana do zmiennej price. */

 private double calculatePrice() {
  double pricetemp = basePrice;
  for (Ingredients i : pizzaIngredients) {
   pricetemp += i.getPrice();
  }
  return pricetemp;
 }

 /* Metoda pozwalająca na wyświetlenie składników dla stworzonej pizzy. Wykorzystywana w klasie Main.
 Korzysta z klasy StringBuilder'a, pozwalającego na łączenie tekstów. Zwraca składniki wykorzystane w danej pizzy.
  */

 public String displayPizzaIngredients() {
  StringBuilder stringBuilder = new StringBuilder();
  for (Ingredients i : pizzaIngredients) {
   stringBuilder.append(i.getName()+", ");
  }
  String finalString = stringBuilder.toString();
  return finalString;

 }

 //Gettery i settery

 public double getPizzaPrice(){
  return this.price;
 }

public String getPizzaName(){
  return this.name;
}

public int getPizzaType(){
  return this.type;
}
}