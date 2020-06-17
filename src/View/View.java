package view;

import java.util.*;

import controller.ItemListController;
import controller.BillOfExchangeStrategy;
import controller.PayPalStrategy;
import controller.CardStrategy;
public class View extends Observable{
    
    Scanner keyboard;
    int option;
    ItemListController cart, stock;
    
    public View() {
        keyboard = new Scanner(System.in);
        singleton();
        stock = new ItemListController(true, "Estoque");
        this.addObserver(stock.getItemListObject());
        mainScreen();
        shoppingScreen();
    }

    private void mainScreen() {
        System.out.println("Banquinha do João");
    }

    private void shoppingScreen() {
        boolean keepRunning= true;

        System.out.println("Bem vindo a area de compras!");
       
        while(keepRunning) {

            System.out.println("\n\nCarrinho com " + cart.size() + " itens");
            System.out.println(cart);
            
            System.out.println("\nEstoque");
            System.out.println(stock);

            System.out.println("\n\nDigite o número do item para adiciona-lo ao carrinho ou 0 para visitar o seu carrinho");
            option = keyboard.nextInt();
            
            
            if (option == 0) {
                keepRunning = myCartScreen();
                
            }
            else {
                setChanged();
                notifyObservers();
                cart.add(stock.remove(option-1));
            }
        }

    }

    private boolean myCartScreen() {
        
        System.out.println("Bem vindo ao seu carrinho!");
        
        while(true) {
            System.out.println("\nCarrinho com " + cart.size() + " itens");
            System.out.println(cart);
            System.out.println("Total: R$" + cart.price() + "\n");

            System.out.println("\n\nDigite o número do item para remove-lo do seu carrinho, 0 para voltar a área de compras, -1 para finalizar compra");
            option = keyboard.nextInt();

            if (option == 0) {
                return true;
            }
            else if (option==-1){
                return paymentScreen();   
            }
            else {
                setChanged();
                notifyObservers();
                stock.add(cart.remove(option-1));
            }
        }
    }

    private boolean paymentScreen() {
        System.out.println("Bem vindo a area de pagamento!");
        System.out.println("\nMétodos de pagamento\n1: PayPal\n2: Boleto\n3: Cartão de Débito\n4: Cartão de Crédito");
        System.out.println("\nDigite o número do método de pagamento para seleciona-lo, ou 0 para voltar as compras");
        option = keyboard.nextInt();
        String dado1, dado2, dado3, dado4;

        switch (option) {
            case 0:
                return true;
            case 1:
                keyboard.nextLine(); 
                System.out.println("E-mail");
                dado1 = keyboard.nextLine();
                System.out.println("Senha");
                dado2 = keyboard.nextLine();
                cart.pay(new PayPalStrategy(dado1, dado2));
                break;
            case 2:
                cart.pay(new BillOfExchangeStrategy());    
            
                break;
            default:
                keyboard.nextLine();    
                System.out.println("Nome Completo");
                dado1 = keyboard.nextLine();
                System.out.println("Numero do Cartão");
                dado2 = keyboard.nextLine();
                System.out.println("Código de Segurança");
                dado3 = keyboard.nextLine();
                System.out.println("Data de Vencimento");
                dado4 = keyboard.nextLine();
                cart.pay(new CardStrategy(dado1, dado2, dado3, dado4, (option!=3)));                
                break;
       
        }
        return false;
        
    }

    private void singleton() {
        if(cart==null) {
            cart = new ItemListController(false, "Carrinho");
            this.addObserver(cart.getItemListObject());
        }
    } 

}