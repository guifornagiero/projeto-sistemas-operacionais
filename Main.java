public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("\nERRO AO EXECUTAR!\n");
            System.out.println("Como executar: java Main <núm. páginas> <lista de páginas> <algoritmo>");
            System.out.println("Algoritmos disponíveis:\n1-FIFO\n2-LRU\n3-OPT");
            System.exit(1);
        }

        int pagesNum = Integer.parseInt(args[0]);
        String pagesList = args[1];
        int algorithm = Integer.parseInt(args[2]);

        if (algorithm == 1) {
            FIFO fifo = new FIFO(pagesNum, pagesList);
            fifo.execute();
        } else if (algorithm == 2) {
            OPT opt = new OPT(pagesNum, pagesList);
            opt.execute();
        } else if (algorithm == 3) {
            LRU lru = new LRU(pagesNum, pagesList);
            lru.execute();
        } else {
            System.err.println("\nERRO AO EXECUTAR!\n");
            System.out.println("Algoritmo inválido!");
            System.exit(1);
        }
    }
}