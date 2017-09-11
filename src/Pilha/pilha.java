package Pilha;

import Pilha.Input;

public class pilha{
	
	public tipoNo topo;
		
	pilha(){}
		
	public void insere(int elemento){
		if(topo == null){
			topo      = new tipoNo();
			topo.setInfo(elemento);
			topo.setProx(null);
		}
		else{
			tipoNo novo;
			novo      = new tipoNo();
			novo.setInfo(elemento);
			novo.setProx(topo);
			topo      = novo;
		}
		System.out.println("Elemento "+elemento+" inserido com sucesso! ");
	}
		
	public void remove(){
		
		if(topo!=null){
			int valor=topo.getInfo();
			System.out.println("Elemento "+valor+" removido com sucesso! ");
			topo=topo.getProx();
		}
	}
	
	public void imprime(){
		tipoNo aux=topo;
		System.out.println("Impressao: \n");
		while(aux!=null){
			System.out.println(aux.getInfo());
			aux=aux.getProx();
		}
		System.out.println("");
	}
	
	public void menu(){
		int valor,opcao=0;
		
		while(opcao!=-1){
			opcao = Input.readInt("\nDigite a opcao: \n(1) Insere \n(2) Remove \n(3) Imprime \n(-1) Sair \nOpcao: ");
			switch(opcao){
			
				case 1:
					valor = Input.readInt("\nValor: ");
					insere(valor);
				break;
				
				case 2:
					remove();
				break;
				
				case 3:
					imprime();
				break;
								
				case -1:
					System.out.println("\nSaindo!");
				break;
				
				default:
					System.out.println("\nOpcao invalida!");
				break;
			
			}
		
		}
	}

	public static void main(String args[]){
		pilha P = new pilha();
		P.menu();
	}
}