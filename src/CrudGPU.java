import java.util.Scanner; //teclado
import java.io.IOException;
import java.util.ArrayList;

public class CrudGPU {
    public static String xopcao;
	public static Scanner teclado;
	public static ArrayList listaliga;

	//Campos cadastro ////////////
	public static int xid;
	public static String xnome;
	public static String xfab;
	public static String xmem;
	public static String xpreco;

	public static double preco;
	public static int mem;
	///////////////////////////////////

	public static String Scanf (String texto)
	{
		System.out.print(texto);
		xopcao = teclado.nextLine();
		return xopcao;
	}
	
	public static void MSG (String texto)
	{
		System.out.print(texto);
		teclado.nextLine();
	}
	
	public static void cls()
	{
		for(int linha = 0; linha < 20; linha++);
		System.out.println(""); 
	}
	
	public static void main (String tx[])
	{
		teclado = new Scanner(System.in);
		listaliga = new ArrayList<GPU>();
		do
		{
			cls();	
			System.out.print("\n<<Crud - GPU >>");
			System.out.print("\n<1> - Incluir GPU......");
			System.out.print("\n<2> - Excluir GPU......");
			System.out.print("\n<3> - Listar GPU......");
			System.out.print("\n<4> - Alterar GPU......");
			System.out.print("\n<5> - Ler arquivo.txt......");
			System.out.print("\n<6> - Gravar arquivo.txt......");
			System.out.print("\n<7> - Fim programa......");
			xopcao=Scanf("\n Digite a sua opcao (1-7): ");
			
			try{
				int op = Integer.parseInt(xopcao);
				if(op < 1 || op > 7) MSG("Opção inválida!! <enter>");
				if(op==1) Incluir();
				if(op==2) Excluir();
				if(op==3) Listar();
				if(op==4) Alterar();
				if(op==5) Ler();
				if(op==6) Gravar();
				if(op == 7) System.exit(0);
				
			}catch(Exception e)
			{
				MSG("Valor inválido!! <enter>");
			}
			
		}while(true);
	}//main	
	public static int CriaID()
	{
		if(listaliga.isEmpty())return 1;
		int tam=listaliga.size();
		int ult=tam-1;
		GPU aux = (GPU)listaliga.get(ult);
		return aux.getId()+1;
		
	}

	public static void Incluir()
	{
		cls();
		System.out.println(">>Incluir GPU");
		System.out.println(">>Digite os dados da GPU>>"+CriaID());
		xnome = Scanf("Nome da GPU: ");
		xfab = Scanf("Fabricante da GPU: ");
		xmem = Scanf("Memoria da GPU: ");
		xpreco = Scanf("Preço da GPU: ");

		System.out.println("Dados digitados:");
		System.out.println("Nome: "+xnome);
		System.out.println("Fabricante: "+xfab);
		System.out.println("Memoria: "+xmem);
		System.out.println("Preço: "+xpreco);
		xopcao = Scanf("Confirmar dados digitados(s/n)?");
		// if(xopcao.equals("s") || xopcao.equals("S"))
		if(xopcao.toUpperCase().equals("S"))
		{
			GPU aux = new GPU();
			aux.setId(CriaID());
			aux.setNome(xnome);
			aux.setFab(xfab);
			
			try {
				preco = Double.parseDouble(xpreco);
			}catch(Exception errpreco)
			{
				MSG("Valor inválido!! <enter>"); preco = 1.00;
			}
			aux.setPreco(preco);
			try {
				mem = Integer.parseInt(xmem);
			}catch(Exception errmem)
			{
                MSG("Valor inválido!! <enter>"); mem = 1;
            }
			aux.setMem(mem);
			listaliga.add(aux);
			MSG("Cadastrado com sucesso!");
		}

	}
	
	public static void Excluir()
	{
		cls();
		System.out.println(">>Excluir GPU");
		ListaremLinha();
		int ultimo = listaliga.size()-1;
		xopcao = Scanf("Digite o ID da GPU: 0-"+ultimo+": ");
		try 
		{
			int reg=Integer.parseInt(xopcao);
			if(reg >= 0 && reg <= ultimo)
			{
				listaliga.remove(reg);
				MSG("Registro excluído com sucesso!! <enter>");
			}
			else
			{
				throw new Exception();
			}
		} catch(Exception e)
		{
			MSG("Valor inválido!! <enter>");
		}
	}
	
	public static void AlterandoDados(int pos){
		GPU aux = (GPU)listaliga.get(pos);
		while(true)
		{
			cls();
			System.out.println(">>Alterando dados da GPU");
			System.out.println("Registro.........="+pos);
			System.out.println("(1) Nome.............="+aux.getNome());
			System.out.println("(2) Fabricante.......="+aux.getFab());
			System.out.println("(3) Memoria..........="+aux.getMem());
			System.out.println("(4) Preço............="+aux.getPreco());
			System.out.println("(5) Fim das alternativas");
			xopcao = Scanf("<<Qual campo vai alterar?");
			if(xopcao.equals("5")) break;
			if(xopcao.equals("1"))
			{
				xnome = Scanf("Digite o novo nome: ");
				aux.setNome(xnome);
			}
			if(xopcao.equals("2"))
			{
				xfab = Scanf("Digite o novo fabricante: ");
				aux.setFab(xfab);
			}
			if(xopcao.equals("3"))
			{
				xmem = Scanf("Digite a nova memoria: ");
				try {
					mem = Integer.parseInt(xmem);
				}catch(Exception errmem)
				{
					MSG("Valor inválido!! <enter>"); mem = 1;
				}
				aux.setMem(mem);
			}
			if(xopcao.equals("4"))
			{
				xpreco = Scanf("Digite o novo preço: ");
				try {
					preco = Double.parseDouble(xpreco);
				}catch(Exception errpreco)
				{
					MSG("Valor inválido!! <enter>"); preco = 1.00;
				}
				aux.setPreco(preco);
			}


			

		}
		
	}
	public static void Alterar()
	{
		cls();
		System.out.println(">>Alterar GPU");
		ListaremLinha();
		int tam = listaliga.size()-1;
		xopcao = Scanf("Digite o ID da GPU: 0-"+tam+": ");
	}
	
	public static void Listar()
	{
		cls();
		if(listaliga.isEmpty())
		{
			MSG("Lista vazia!! <enter>");
			return;
		}
		for(int i=0; i<listaliga.size(); i++)
		{
			GPU aux = new GPU();
			aux = (GPU)listaliga.get(i);
			System.out.println("ID: "+aux.getId());
			aux.toStr();
			System.out.println("--------------------------");
		}
	}

	public static void ListaremLinha(){
		cls();
		if(listaliga.isEmpty())
		{
			MSG("Lista vazia!! <enter>");
			return;
		}
		System.out.println("ID\tNome\tFabricante\tMemoria\tPreço");
		for(int i=0; i<listaliga.size(); i++)
		{
			GPU aux = new GPU();
			aux = (GPU)listaliga.get(i);
			System.out.println("ID: "+aux.getId());
			aux.emLinha();
			System.out.println("--------------------------");
		}
	}
	
	public static void Ler()
	{
		cls();
        System.out.println(">>Ler GPU");
        System.out.println(">>Digite o ID da GPU>>");
        xid = Integer.parseInt(Scanf("ID da GPU: "));
        int tam = listaliga.size();
	}
	
	public static void Gravar()
	{
		cls();
        System.out.println(">>Gravar GPU");
        System.out.println(">>Digite o ID da GPU>>");
        xid = Integer.parseInt(Scanf("ID da GPU: "));
        int tam = listaliga.size();
	}
}
