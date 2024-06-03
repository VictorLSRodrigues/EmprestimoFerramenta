package principal;

import visao.FrmMenuPrincipal;
import visao.FrmGerenciadorAmigo;
import visao.FrmGerenciadorFerramenta;
public class Principal {
    
    public static void main (String [] args){
        
        //Abre o Menu Principal
        FrmMenuPrincipal menu = new FrmMenuPrincipal();
        menu.setVisible (true);
        
         FrmGerenciadorFerramenta menuf = new FrmGerenciadorFerramenta();
        menuf.setVisible (false);
         FrmGerenciadorAmigo menua = new FrmGerenciadorAmigo();
        menua.setVisible (false);
        
    }   
}
