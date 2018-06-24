package emissor;

public class Pacote {
	
	private String ipOrigem;
	private String ipDestino;
	private String mensagem;
	private Integer TTL;
	
	public Pacote(String ipOrigem, String ipDestino, String msg) {
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.mensagem = msg;
		this.TTL = 6;
	}

	public String getIpOrigem() {
		return this.ipOrigem;
	}

	public String getIpDestino() {
		return this.ipDestino;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public Integer getTTL() {
		return this.TTL;
	}

	@Override
	public String toString() {
		return 	this.ipOrigem + "," +
				this.ipDestino + "," +
				this.mensagem + "," +
				this.TTL;
	}

}
