/* PizzaTypes - tryb wyliczeniowy przechowujący rodzaje predefiniowanych pizz w systemie.
Zawiera typ oraz name, stanowiące identyfikator pizzy oraz nazwę, która jest wyświetlana dla użytkownika.
Definicje składnik pizz znajdują się w klasie Pizza.
PizzaTypes jest używana do wyświetlania listy dostępnych pizz w klasie Main.
*/

public enum PizzaTypes {

    CAPRICIOSA (1,"Capriciosa"),
    SEROWA (2, "4SERY"),
    MARGHERITA(3,"Margherita");


    private int type;
    private String name;

    //Konstruktor
    PizzaTypes(int type, String name){
        this.type=type; this.name=name;
    }

    //Gettery i settery
    public int getType() {
        return type;
    }

    public String getName() {
        return name();
    }


}
