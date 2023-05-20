class GPU {
	private int id_gpu;
	private String nome_gpu,fab_gpu;
	private int mem_gpu; 
	private double preco_gpu;
	
	GPU()
	{
		setId(0);
		setNome("");
		setFab ("");
		setMem(0);
		setPreco(0.0);
	}
	//
	public void setId(int i)
	{
		this.id_gpu = i;
	}
	
	public void setNome(String n)
	{
		this.nome_gpu = n;
	}
	
	public void setFab(String f)
	{
		this.fab_gpu = f;
	}
	
	public void setMem(int m)
	{
		this.mem_gpu = m;
	}
	
	public void setPreco(double p)
	{
		this.preco_gpu = p;
	}
	
	public int getId()
	{
		return this.id_gpu;
	}
	
	public String getNome()
	{
		return this.nome_gpu;
	}
	
	public String getFab()
	{
		return this.fab_gpu;
	}
	
	public int getMem()
	{
		return this.mem_gpu;
	}
	
	public double getPreco()
	{
		return this.preco_gpu;
	} 

	public void toStr(){
		System.out.println("Dados da GPU:");
		System.out.println("ID: "+getId());
		System.out.println("Nome: "+getNome());
		System.out.println("Fabricante: "+getFab());
		System.out.println("Memoria: "+getMem());
		System.out.println("Preço: "+getPreco());
	}

	public void emLinha(){
		System.out.println("ID: "+getId()+"\tNome: "+getNome()+"\tFabricante: "+getFab()+"\tMemoria: "+getMem()+"\tPreço: "+getPreco());
	}
	
}
	

