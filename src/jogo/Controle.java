package jogo;

import javax.swing.JOptionPane;
import jplay.GameObject;
import jplay.TileInfo;
import jplay.Window;


public class Controle {
    private Window janela;
    private Cenario1 cena;
    
        
    
    public boolean colisao(GameObject obj, TileInfo tile){
        
        
        
        if((tile.id >= 7) && (tile.id < 10)&& obj.collided(tile)){
            return true;
        }
        
        else if((tile.id == 10) && obj.collided(tile)){
            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);
            
            int result = Integer.parseInt(JOptionPane.showInputDialog(null, num1+ " + " +num2+ " = ?"));
            
            boolean acertou;
            
            if(result == num1 + num2){
                
                JOptionPane.showMessageDialog(null, "Acertou!");
                 acertou = true;
            }
            
            else if(result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION ){
                JOptionPane.showMessageDialog(null, "Errou!");
                acertou = false;
            }
            
            else {
                
                JOptionPane.showMessageDialog(null, "Errou!");
                acertou = false;
            }
            
            if(acertou == true){
                tile.id = 02;
            }
            
        }
        
        else if((tile.id == 11) && obj.collided(tile)){
            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);
            
            int result = Integer.parseInt(JOptionPane.showInputDialog(null, num1+ " - " +num2+ " = ?"));
            
            boolean acertou;
            
            if(result == num1 - num2){
                
                JOptionPane.showMessageDialog(null, "Acertou!");
                 acertou = true;
            }
            else {
                
                JOptionPane.showMessageDialog(null, "Errou!");
                acertou = false;
            }
            
            if(acertou == true){
                tile.id = 02;
            }
            
        }
        
        else if((tile.id == 12) && obj.collided(tile)){
            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);
            
            int result = Integer.parseInt(JOptionPane.showInputDialog(null, num1+ " x " +num2+ " = ?"));
            
            boolean acertou;
            
            if(result == num1 * num2){
                
                JOptionPane.showMessageDialog(null, "Acertou!");
                 acertou = true;
            }
            
            
            else {
                
                JOptionPane.showMessageDialog(null, "Errou!");
                acertou = false;
            }
            
            if(acertou == true){
                tile.id = 02;
            }
            
        } 
        
        else if((tile.id == 14) && obj.collided(tile)){
            int num1 = (int)(Math.random()*10);
            int num2 = (int)(Math.random()*10);
            
            int result = Integer.parseInt(JOptionPane.showInputDialog(null, num1+ " / " +num2+ " = ?"));
            
            boolean acertou;
            
            if(result == num1 / num2){
                
                JOptionPane.showMessageDialog(null, "Acertou!");
                 acertou = true;
            }
            else {
                
                JOptionPane.showMessageDialog(null, "Errou!");
                acertou = false;
            }
            
            if(acertou == true){
                tile.id = 02;
            }
            
        } 
        
          if((tile.id >= 15) && obj.collided(tile)){
             JOptionPane.showMessageDialog(null, "Parabéns");
            
         }
         
        
        return false;
    }

    
}
