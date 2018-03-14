import java.util.Scanner;

public class Main {
	private static BinaryTree root;
	private static int soma;

	public static void imprimir(){
		if(root == null){
			System.out.println("Vazio");
		} else {
			imprimir(root);
		}
	}

	private static void imprimir(BinaryTree node){
		if(node.getLeft() != null){
            imprimir(node.getLeft());
        }
        if (node.getRight() != null){
            imprimir(node.getRight());
        }
	}

	public static void incluir(int valor){
        incluir(root, valor);
    }

    public static void incluir(BinaryTree node, int valor) {
        if(root == null){
           root = new BinaryTree(valor);
        } else {
            if (valor < node.getValor()) {
                if (node.getLeft() != null) {
                    incluir(node.getLeft(), valor);
                } else {
                    node.setLeft(new BinaryTree(valor));
                }
            } else if (valor > node.getValor()) {
                if (node.getRight() != null) {
                    incluir(node.getRight(), valor);
                } else {
                    node.setRight(new BinaryTree(valor));
                }
            }
        }
    }

    public static int localizar(int valor){
    	return localizar(root, valor);
    }

    private static int localizar(BinaryTree node, int valor){
    	if(root == null){
			return 0;
		} else {
			if (valor < node.getValor()) {
                if (node.getLeft() != null) {
                    localizar(node.getLeft(), valor);
                } else {
                	soma += valor;
                }
            } else if (valor > node.getValor()) {
                if (node.getRight() != null) {
                	localizar(node.getRight(), valor);
                } else {
                	soma += valor;
                }
            } else {
            	if (node.getLeft() != null) {
            		soma += node.getLeft().getValor();
                    localizar(node.getLeft(), node.getLeft().getValor());
                } else {
                   soma += 0;
                }
            	if (node.getRight() != null) {
            		soma += node.getRight().getValor();
                	localizar(node.getRight(), node.getRight().getValor());
                } else {
                	soma += 0;
                }
            }
		}

    	return soma;
    }

    public static void main(String[] args) {

    	Scanner entrada = new Scanner(System.in);
    	int num = 0;

    	Main b;
    	do {
    		System.out.print("Digite o Nó (para sair digite 0): ");
    		num = entrada.nextInt();
    		if (num != 0) {
    			incluir(num);
    		}
    	}while (num != 0);

    	imprimir();

    	entrada = new Scanner(System.in);
    	System.out.print("Calcular a soma subsequente ao nó: ");
    	num = entrada.nextInt();
    	System.out.println("Soma " + localizar(num));
    }

}
