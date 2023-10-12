package ms.pix.models;

public record PixCreate(Calendario calendario, Devedor devedor, Valor valor, String chave, String solicitacaoPagador) {
}
