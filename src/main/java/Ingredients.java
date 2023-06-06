/* Ingredients - tryb wyliczeniowy enum został użyty aby wymienić składniki dostępne dla stworzenia pizzy.
Wymionie składki posiadają dodatkowo wartości type, price oraz id.
Type - stanowi informację o kategorii danego składnika: mięsne (0), sery (1) lub warzywne (2).
Price - stanowi cenę składnika.
Id - identyfikator składnika, pozwalający na jego wybrania podczas tworzenia pizzy.
 */

public enum Ingredients {
    PEPERONI( 0,4.5,1),
    KURCZAK( 0,4.0,2),
    SZYNKA(0,3.75,3),
    BOCZEK(0,4.0,4),
    WOLOWINA(0,5.5,5),
    SALAMI(0,3.75,6),
    MOZARELLA( 1,2.5,7),
    LAZUR( 1,4.0,8),
    PARMEZAN(1,4.75,9),
    EDAMSKI(1,2.0,10),
    GOLDA(1,2.0,11),
    COREGGIO(1, 3.00,12),
    PIECZARKI(2,2.5,13),
    KARCZOCHY(2,3.0,14),
    POMIDORY(2,1.75,15),
    SZPINAK(2,2.0,16),
    RUKOLA(2,4.5,17),
    PAPRYKA(2,2.0,18),
    KUKURYDZA(2, 2.99,19),
    JALEPENO(2, 3.0,20),
    CEBULA(2,2.0,21),
    CZONSEK(2,2.0,22),
    ANANAS(2, 4.0,23);

    private int type; //0 - meat, 1- cheese, 2-vegetables
    private double price;
    private int id;

    //Konstruktor
    Ingredients(int type, double price, int id) {
        this.type=type; this.price = price; this.id=id;
    }

    //Gettery i settery
    public int getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name();
    }
    public int getId() { return id; }

    /*Metoda pozwalająca na pobranie składnika na podstawie identyfikatora. Wykorzystywana w klasie Main.
    Zwraca składnik, który jest następnie dodawany do listy wybranych składników.
    Zwraca null w przypadku gdy podany identyfikator nie istnieje. */
    public static Ingredients getIngredientById(int id) {
        for (Ingredients ingredient : Ingredients.values()) {
            if (ingredient.getId() == id) {
                return ingredient;
            }
        }
        return null;
    }

}
