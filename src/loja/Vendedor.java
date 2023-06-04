package loja;

public class Vendedor {
    String vendedor;
    int categoria;
    double valorVendas;

    public Vendedor(String vendedor, int categoria, double valorVendas) {
        this.vendedor = vendedor;
        this.categoria = categoria;
        this.valorVendas = valorVendas;
    }
    
    public double calcSalFinal(){
        double salFinal;
        if(categoria== 1){
            salFinal =(valorVendas*0.07);
        }
        else if(categoria== 2){
            salFinal = (valorVendas*0.05);
        }
          else{
            salFinal = (valorVendas*0.04);
        }
        return salFinal;
    }
    
}
