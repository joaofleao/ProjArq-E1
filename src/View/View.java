package View;

import java.util.*;



import Controller.ItemListController;
public class View implements Observer{
    
    Scanner keyboard;
    int option;
    ItemListController cart, stock;
    
    public View() {
        keyboard = new Scanner(System.in);
        singleton();
        stock = new ItemListController(true, this);
        mainScreen();
        shoppingScreen();
        
    }

    private void mainScreen() {
        System.out.println("Banquinha do Flores");
    }

    private void shoppingScreen() {
        boolean keepRunning= true;


        System.out.println("Bem vindo a area de compras!");


        
        
        while(keepRunning) {

            System.out.println("\n\nCarrinho com " + cart.size() + " itens");
            System.out.println(cart);
            
            System.out.println("\nStock");
            System.out.println(stock);

            System.out.println("\n\nDigite o número do item para adiciona-lo ao carrinho ou 0 para visitar o seu carrinho");
            option = keyboard.nextInt();
            
            if (option == 0) {
                keepRunning = myCartScreen();
                
            }
            else {
                cart.add(stock.remove(option-1));
            }
        }

    }

    private boolean myCartScreen() {
        
        System.out.println("Bem vindo ao seu carrinho!");
        
        while(true) {
            System.out.println("\nCarrinho com " + cart.size() + " itens");
            System.out.println("Total: R$" + cart.price() + "\n");
            System.out.println(cart);

            System.out.println("\n\nDigite o número do item para remove-lo do seu carrinho, 0 para voltar a área de compras, -1 para finalizar compra");
            option = keyboard.nextInt();

            if (option == 0) {
                return true;
            }
            else if (option==-1){
                return paymentScreen();   
            }
            else {
                stock.add(cart.remove(option-1));
            }
        }
    }

    private boolean paymentScreen() {
        System.out.println("Bem vindo a area de pagamento!");
        
        while(true) {
            System.out.println("Digite o número do método de pagamento para seleciona-lo, ou 0 para voltar as compras");
            option = keyboard.nextInt();

            if (option == 0) {
                return true;
            }
            else {
                //funcao de remover item ao carrinho
                return false;
            }
        }
    }

    private void singleton() {
        if(cart==null) {
            cart = new ItemListController(false, this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Adicionado pelo Observable");

        
    }

  
}