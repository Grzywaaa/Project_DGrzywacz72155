import java.util.*;

/* Klasa Main stanowi punkt uruchamiający aplikację.
W jej wnętrzu znajdziemy menu pozwalające na poruszanie się po programie. */

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Obiekt klasy pozwalającej na pobierania danych z wejścia użytkownika.
        int choice; //zmienna pomocnicza, przechowująca wybór użytkownika

        //W poniżej części jest wyświetlona oferta pizzeri - dostępne predefiniowane pizze.
        System.out.println("Witaj w pizzeri! Zapoznaj się z naszym menu!");2
        System.out.println("");
        PizzaTypes[] pizzatypes = PizzaTypes.values();
        System.out.println("Dostępne warianty pizzy:");
        for (PizzaTypes i : pizzatypes) {
            Pizza pizza=new Pizza(i.getType());
            System.out.println(i.getType()+". "+ i.getName()+'('+ pizza.displayPizzaIngredients()+')');
            System.out.println("Cena: " + pizza.getPizzaPrice());
            System.out.println("--------------------");

        }

        //Poniżej znajduje się menu pozwalające na sterowanie programem.
        do {
            System.out.println("1. Złóż zamówienie ");
            System.out.println("2. Skomponuj własną pizzę");
            System.out.println("0. Zakończ");
            System.out.print("Twój wybór: ");
            choice = scanner.nextInt(); //odczytanie liczby całkowitej wprowadzonej przez użytkownika i przypisanie jej do zmiennej choice.

            // Konsutrkcja switch pozwalająca na podjęcie odpowiedniej akcji na wybór użytkownika.
            switch (choice) {
                case 1:
                    /* Scenariusz 1 - użytkownik chce zamówić jedną z predefiniowanych pizz.
                    W poniższym oczekujemy na podanie identyfikatora pizzy,
                    następnie przy pomocy pętli if sprawdzamy czy mieści się w podanym przez nas zakresie.
                    Jeśli tak, zostaje stworzony obiekt Pizza dla podanego identyfikatora.
                    Następnie przy pomocy metod publicznych wyświetlamy podstawowe informacje tj. nazwę, listę składników oraz cenę).
                     */
                    System.out.println("1. Podaj numer pizzy");
                    choice = scanner.nextInt();
                    if(choice > 0 && choice <=3){
                        Pizza pizza=new Pizza(choice);
                        System.out.println("Gratulacje! Pizza została zamówiona!");
                        System.out.println("Twoja pizza: "+ pizza.getPizzaName()+": "+ pizza.displayPizzaIngredients().toLowerCase(Locale.ROOT) );
                        System.out.println("Do zapłaty: "+ pizza.getPizzaPrice());
                    }
                    else break;
                    choice=0;
                    break;
                case 2:

                    Scanner local=new Scanner(System.in); //utworzenie nowego obiektu pozwalającego na odczyt wyboru użytkownika
                    System.out.println("Wybierz składniki używając ich numeru - podaj 3 składniki");

                    /*Poniżej zostaje stworzona lista obiektów składników, następnie następuje ich wypisanie
                    wraz z identyfikatorem, nazwą oraz ceną.*/
                    Ingredients[] ingredients = Ingredients.values();
                    for (Ingredients i : ingredients) {
                        System.out.println(i.getId() +" - " +i.getName() + " - " + i.getPrice());
                    }
                    System.out.println("Aby zakończyć użyj 0");

                    int ingChoice; //zmienna pomocnicza przechowująca wybór użytkownika
                    List<Ingredients> customIngredients = new ArrayList<>(Arrays.asList()); //pusta lista przechowująca wartości enum
                    int count = 0; //zmienna służąca do zliczenia ile składników zostało już dodanych w poniżej pętli while
                    int flag=0; //zmienna sprawdzająca czy pizza została stworzona

                    /* Pętla while pozwala na trzykrotne przyjęcie numeru składnika. Została opatrzona dodatkowymi zabezpieczeniami:
                    1. Jeśli wybór użytkownika to 0 - zakończ pętlę.
                    2. Sprawdzamy czy identyfikator mieści się w zadanym zakresie.
                    Jeśli tak, to tworzymy na tej podstawie składnik i dodajemy go do listy jeśli jest niepusty.
                    Następnie inkrementujemy zmienne count oraz flag.
                    W przeciwnym razie zwracamy informację, że podany składnik nie został znaleziony. */
                    while (count < 3) {
                        ingChoice = local.nextInt();
                        if (ingChoice == 0) { break; }
                        if (ingChoice > 0 && ingChoice < 24) {
                            Ingredients ingredient = Ingredients.getIngredientById(ingChoice);
                            if (ingredient != null) {
                                customIngredients.add(ingredient);
                                count++;
                                flag++;
                            } else {
                                System.out.println("Nie znaleziono składnika o identyfikatorze " + ingChoice);
                            }
                        } else {
                            System.out.println("Nieprawidłowy wybór składnika");
                        }
                    }
                    /* Poniższy fragment kodu przedstawia utworzenie obiektu pizza na podstawie listy składników.
                    Następnie wyświetla komunikat o zamówieniu pizzy oraz informacje na jej temat. */
                    if(flag!=0){
                        Pizza customPizza = new Pizza(customIngredients);
                        System.out.println("Gratulacje! Pizza została zamówiona!");
                        System.out.println("Twoja pizza: "+ customPizza.getPizzaName()+": "+ customPizza.displayPizzaIngredients().toLowerCase(Locale.ROOT) );
                        System.out.println("Do zapłaty: "+ customPizza.getPizzaPrice());
                    }

                    local.close(); choice=0; break;
                case 3:
                    break;
                case 0:
                    System.out.println("Smacznego!");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                    break;
            }
        } while (choice != 0);

        scanner.close(); //zamknięcie odczytywania wyboru użytkownika



    }
}