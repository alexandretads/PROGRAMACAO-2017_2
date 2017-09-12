package Fila;

public class fila{
	
	public tipoNo cabeca;
	fila(){
		System.out.println("Criando fila...(construtor fila)");
	}
		
	public void insereFinalCircular(int info){
		if(cabeca == null){
			cabeca = new tipoNo();
			cabeca.setInfo(info);
			cabeca.setProx(cabeca);
		}
		else{
			tipoNo aux,novo;
			
			novo = new tipoNo();
			novo.setInfo(info);
			novo.setProx(cabeca);
						
			aux = cabeca;
			while(aux.getProx()!=cabeca)
				aux=aux.getProx();
			
			aux.setProx(novo);
		}
		
		System.out.println("Elemento "+info+" inserido com sucesso! ");
	}
	
	public void insereInicio(int info){
		if(cabeca == null){
			cabeca      = new tipoNo();
			cabeca.setInfo(info);
			cabeca.setProx(null);
		}
		else{
			tipoNo novo;
			novo = new tipoNo();
			novo.setInfo(info);
			novo.setProx(cabeca);
			cabeca = novo;
		}
		System.out.println("Elemento "+info+" inserido com sucesso! ");
	}
	
	public void removeInicioCircular(){
		if(cabeca!=null){
			if(cabeca.getProx()== cabeca){
                            cabeca=null;
                        }else{
                            tipoNo aux;
                            aux = cabeca;
                            while(aux.getProx()!=cabeca){
                                aux = aux.getProx();
                            aux.setProx(cabeca.getProx());
                            cabeca = cabeca.getProx();
                            }                        
                        }
		}
	}
	
	public void removeFinal(){
		if(cabeca!=null){
			if(cabeca.getProx()==null){
				int valor=cabeca.getInfo();
				System.out.println("Elemento "+valor+" removido com sucesso! ");
				cabeca = null;
			}
			else{
				tipoNo aux;
				aux = cabeca;
				while((aux.getProx()).getProx()!=null)
					aux=aux.getProx();
				int valor=(aux.getProx()).getInfo();
				System.out.println("Elemento "+valor+" removido com sucesso! ");
				aux.setProx(null);
			}
		}
	}
        public void removenesimo(int n){
        
            //se o cabeca ta nulo
        if(cabeca == null){
            System.out.println("Lista vazia");
        }else {
            //remocao do primeiro
            int valor;
            if(n==1){
                valor = cabeca.getInfo();
                cabeca = cabeca.getProx();
                System.out.println("Valor "+valor+" Removido ");
            }else {
                //remocao do segundo
                int pos=1;
                tipoNo aux;
                aux = cabeca;
                
                while(aux.getProx()!=null && pos != n-1){
                    aux= aux.getProx();
                    pos++;
                }
                //remocao do terceiro
                if(aux.getProx()!=null){
                valor = aux.getProx().getInfo();
                aux.setProx(aux.getProx().getProx());
                System.out.println("Valor "+valor+" Removido ");
                }else{
                    System.out.println("Posicao inexistente");
                }
           }
        }
        
    }
	
	public void imprimeCircular(){
            System.out.println("Impressao: ");
            if(cabeca!=null){
                tipoNo aux=cabeca;
                System.out.print(aux.getInfo()+" ");
                aux=aux.getProx();
             
                while(aux!=cabeca){
                    System.out.print(aux.getInfo()+" ");
                    aux=aux.getProx();
                }
                System.out.println("");
            }
        }

	public void menu(){
		int valor,opcao=0,n;
		System.out.print("\n------------ Menu ------------\n");
		while(opcao!=-1){
			opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim Circular \n(3) Remove Inicio Circular\n(4) Remove Fim \n(5) Imprime Circular\n(6)Remove nesimo\n(-1) Sair \nOpcao: ");
			switch(opcao){
			
				case 1: //insereInicio
					valor = Input.readInt("Valor: ");
					insereInicio(valor);
				break;
				
				case 2: //insereFinal
					valor = Input.readInt("Valor: ");
					insereFinalCircular(valor);
				break;
				
				case 3: //removeInicio
					removeInicioCircular();
				break;
				
				case 4: //removeFinal
					removeFinal();
				break;
				
				case 5: //imprime
					imprimeCircular();
				break;
                                
                                case 6: n = Input.readInt("Digite o n-esimo: ");
                                        removenesimo(n);
                                break;
				
				case -1: //sair
					System.out.println("Saindo!");
				break;
				
				default:
					System.out.println("Opcao invalida!");
				break;
			
			}
		
		}
	}

	public static void main(String args[]){
		System.out.println("\n************ Lista Encadeada Din�mica ************\n");
		fila F = new fila();
		F.menu();
		System.out.println("\n************ Fim programa ************\n");
	}
}