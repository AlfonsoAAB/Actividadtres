import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] palos = {"tréboles", "corazones", "picas", "diamantes"};
        String[] colores = {"rojo", "negro"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                for (String color : colores) {
                    Card card = new Card(palo, color, valor);
                    cards.add(card);
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.size() > 0) {
            Card card = cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No quedan cartas en el deck.");
        }
    }

    public void pick() {
        if (cards.size() > 0) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card card = cards.remove(randomIndex);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No quedan cartas en el deck.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            System.out.println("Mano de 5 cartas:");

            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card);
            }

            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas para repartir una mano.");
        }
    }
}

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Mezclar el Deck");
            System.out.println("2. Mostrar la primera carta");
            System.out.println("3. Seleccionar una carta al azar");
            System.out.println("4. Repartir una mano de 5 cartas");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
