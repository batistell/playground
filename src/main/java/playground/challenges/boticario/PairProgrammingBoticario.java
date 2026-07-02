package playground.challenges.boticario;

import java.util.HashMap;

/**
 * Desafio Boticário - Pair Programming
 * +-------------+--------+---------------------------------------------------------------+
 * |   Produto   |  Preço |                          Desconto                             |
 * +-------------+--------+---------------------------------------------------------------+
 * | Floratta    | R$60   | Leve 2 e pague 1                                              |
 * | Malbec      | R$210  | Compre ao menos 2 e receba 20% de desconto em produtos Malbec |
 * | Egeo        | R$33   | Sem desconto                                                  |
 * +-------------+--------+---------------------------------------------------------------+
 *
 *  [ ['Floratta', 1], ['Malbec', 0], ['Egeo', 1] ] # resultado => 93
 *  [ ['Floratta', 1], ['Malbec', 1], ['Egeo', 1] ] # resultado => 303
 *  [ ['Floratta', 2], ['Malbec', 2], ['Egeo', 1] ] # resultado => 429
 *  [ ['Egeo', 2], ['Floratta', 3], ['Malbec', 5] ] # resultado => 1026
 *  [ ['Floratta', 7], ['Malbec', 7], ['Egeo', 7] ] # resultado => 1647
 * Este espaço está reservado para você implementar a sua solução.
 */
public class PairProgrammingBoticario {


    // TODO: Adicione seus atributos e métodos aqui para resolver o desafio.
    public double main() {
        HashMap<String, Integer> carrinho = new HashMap<>();
        carrinho.put("Floratta", 7);
        carrinho.put("Malbec", 7);
        carrinho.put("Egeo", 7);
        return carrinhoProcessor(carrinho);
    }

    private double carrinhoProcessor(HashMap<String, Integer> carrinho) {
        double total = 0;
        if (carrinho == null || carrinho.isEmpty()) {
            throw new IllegalStateException("Carrinho is empty");
        }
        for (String key : carrinho.keySet()) {
            String keyLowerCase = key.toLowerCase();
            Integer amount = carrinho.get(key);
            switch (keyLowerCase) {
                case "floratta":
                    int priceFloratta = 60;
                    int pares = amount/2;
                    int remanescentes = amount % 2;
                    total += (pares + remanescentes) * priceFloratta;
                    break;
                case "malbec":
                    int priceMablec = 210;
                    if (amount >= 2) {
                        total += priceMablec * amount * 0.8;
                    } else {
                        total += priceMablec * amount;
                    }
                    break;
                case "egeo":
                    int priceEgeo = 33;
                    total += priceEgeo * amount;
                    break;
            }
        }
        System.out.println("total: " + total);
        return total;
    }

}
