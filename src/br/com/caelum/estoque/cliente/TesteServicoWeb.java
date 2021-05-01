package br.com.caelum.estoque.cliente;

public class TesteServicoWeb {

	public static void main(String[] args) {
		/*
		 * Inicia uma conexão com o serviço SOAP
		 * através da interface EstoqueWS.
		 */
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();
		/*
		 * Define um filtro para consultar na operação todosOsItens.
		 */
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo(TipoItem.CELULAR);
		filtros.getFiltro().add(filtro);
		/*
		 * Faz uma chamada para operação todosOsItens.
		 */
		ListaItens itens = cliente.todosOsItens(filtros);
		/*
		 * Exibe os itens no console.
		 */
		for (Item item : itens.getItem()) {
			System.out.println("Nome: " + item.getNome());
			System.out.println("Tipo: " + item.getTipo());
			System.out.println("Qtde: " + item.getQuantidade());
		}
//		System.out.println(itens);
	}

}
