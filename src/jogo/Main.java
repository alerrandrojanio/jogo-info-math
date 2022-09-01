package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main{
    
    public static void main(String[] args){
        
        Window janela = new Window(800, 600); // Cria janela 
        janela.setTitle("Jogo"); // Titulo da janela 
        
        GameImage plano = new GameImage(URL.sprite("menu.png"));
        
        Keyboard teclado = janela.getKeyboard(); // Pega o botão q o usuario digita
        
        // Comando vai repetir por toda a execução do jogo 
        while(true){
            plano.draw(); // Desenha na janela
            janela.update();
            
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
             new Cenario1(janela);
              // Caso o usuario aperte ENTER
            }
             
            else if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                System.exit(0);
                // Caso o usuario aperte ESC
            }
            
            
        }
        
    }

}
