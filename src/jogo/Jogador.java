package jogo;

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.URL;
import jplay.Window;


public class Jogador extends Sprite{
    
    private double velocidade = 1;
    private int direcao = 3;
    
    private boolean movendo = false;

    public Jogador(int x, int y) {
        super(URL.sprite("sprite.png"), 16);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }
    
    public void mover(Window janela, Keyboard teclado){
        
        if(teclado.keyDown(Keyboard.LEFT_KEY)){
           if(this.x > 0) 
               this.x -= velocidade;
           if(direcao != 1){
               setSequence(4, 8);
               direcao = 1;
           }
           movendo = true;
        
        }
        
        else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
            if(this.x < janela.getWidth()- 60) 
               this.x += velocidade;
                    if(direcao != 2){
                        setSequence(8, 12);
                        direcao = 2;
                    }
                movendo = true; 
        }
        
        else if(teclado.keyDown(Keyboard.UP_KEY)){
            if(this.y > 0) 
               this.y -= velocidade;
           if(direcao != 4){
               setSequence(12, 16);
               direcao = 4;
           }
           movendo = true;
        }
        
        else if(teclado.keyDown(Keyboard.DOWN_KEY)){
            if(this.y < janela.getHeight() - 60) 
               this.y += velocidade;
                    if(direcao != 5){
                        setSequence(0, 4);
                        direcao = 5;
                    }
                movendo = true;
        }
        
        if(movendo){
          update();
          movendo = false;
         }
    }

    Controle controle = new Controle();
    
    public void caminho(Scene cena){
        
        Point min = new Point((int) this.x, (int) this.y);
        Point max = new Point((int) this.x + this.width, (int) this.y + this.height);
        
        Vector<?>tiles = cena.getTilesFromPosition(min, max);
        
        for(int i = 0; i < tiles.size(); i++){
            
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            if(controle.colisao(this, tile) == true){
                if(colisaoVertical(this, tile)){
                
                    if(tile.y + tile.height - 2 < this.y){
                        this.y = tile.y + this.height;
                    }
                
                    else if(tile.y > this.y + this.height - 2){
                        this.y = tile.y - this.height;
                    }
                }
            
                if(colisaoHorizontal(this, tile)){
                    
                    if(tile.x > this.x + this.width - 2){
                        this.x = tile.x + this.width;
                    }
                
                    else{
                        this.x = tile.x + tile.width;
                    }
                    
                }
            }
        } 
        
    }
    
    private boolean colisaoVertical(GameObject obg, GameObject obg2){
       
        if(obg2.x + obg2.width <= obg.x)
            return false;
        if(obg.x + obg.width <= obg2.x)
            return false;
        return true;
    }
    
    private boolean colisaoHorizontal(GameObject obg, GameObject obg2){
        if(obg2.y + obg2.height <= obg.y)
            return false;
        if(obg.y + obg.height <= obg2.y)
            return false;
        return true;
    }
    
    
}
