import java.util.Scanner;

class Nodo {
    String caractere;
    Nodo filhoEsquerdo;
    Nodo filhoDireito;

    public Nodo() {
        this.caractere = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
}

class ArvoreBinariaMorse {
    private Nodo raiz;

    public ArvoreBinariaMorse() {
        this.raiz = new Nodo();
    }

    public void inserir(String codigoMorse, String caractere) {
        Nodo noAtual = raiz;
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i);
            if (simbolo == '.') {
                if (noAtual.filhoEsquerdo == null) {
                    noAtual.filhoEsquerdo = new Nodo();
                }
                noAtual = noAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                if (noAtual.filhoDireito == null) {
                    noAtual.filhoDireito = new Nodo();
                }
                noAtual = noAtual.filhoDireito;
            }
        }
        noAtual.caractere = caractere;
    }

    public String buscar(String codigoMorse) {
        Nodo noAtual = raiz;
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i);
            if (simbolo == '.') {
                noAtual = noAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                noAtual = noAtual.filhoDireito;
            }

            if (noAtual == null) {
                return null;
            }
        }
        return noAtual.caractere;
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        inicializarArvore(arvore);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite um código Morse (ou 'sair' para encerrar): ");
            String codigo = scanner.nextLine();
            if (codigo.equalsIgnoreCase("sair")) {
                break;
            }

            String[] caracteres = codigo.split(" ");
            StringBuilder resultado = new StringBuilder();
            for (String caractere : caracteres) {
                String letra = arvore.buscar(caractere);
                if (letra != null) {
                    resultado.append(letra);
                } else {
                    resultado.append('?'); // Caso o caractere não exista
                }
            }
            System.out.println("Resultado: " + resultado.toString());
        }
        scanner.close();
    }

    public static void inicializarArvore(ArvoreBinariaMorse arvore) {
        // Inserir letras
        arvore.inserir(".-", "A");
        arvore.inserir("-...", "B");
        arvore.inserir("-.-.", "C");
        arvore.inserir("-..", "D");
        arvore.inserir(".", "E");
        arvore.inserir("..-.", "F");
        arvore.inserir("--.", "G");
        arvore.inserir("....", "H");
        arvore.inserir("..", "I");
        arvore.inserir(".---", "J");
        arvore.inserir("-.-", "K");
        arvore.inserir(".-..", "L");
        arvore.inserir("--", "M");
        arvore.inserir("-.", "N");
        arvore.inserir("---", "O");
        arvore.inserir(".--.", "P");
        arvore.inserir("--.-", "Q");
        arvore.inserir(".-.", "R");
        arvore.inserir("...", "S");
        arvore.inserir("-", "T");
        arvore.inserir("..-", "U");
        arvore.inserir("...-", "V");
        arvore.inserir(".--", "W");
        arvore.inserir("-..-", "X");
        arvore.inserir("-.--", "Y");
        arvore.inserir("--..", "Z");

        // Inserir números
        arvore.inserir("-----", "0");
        arvore.inserir(".----", "1");
        arvore.inserir("..---", "2");
        arvore.inserir("...--", "3");
        arvore.inserir("....-", "4");
        arvore.inserir(".....", "5");
        arvore.inserir("-....", "6");
        arvore.inserir("--...", "7");
        arvore.inserir("---..", "8");
        arvore.inserir("----.", "9");
    }
}
