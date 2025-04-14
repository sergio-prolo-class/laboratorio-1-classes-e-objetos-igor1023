package ifsc.poo;

import java.awt.RenderingHints;

/*
 * Os métodos de setar hora, minuto e segundo
 * podem receber qualquer valor float, pois será
 * atribuído o módulo do valor.
*/

public class Relogio {

    private byte hora, minuto, segundo;

    public void ajustaHora(byte hora, byte minuto, byte segundo){

        // Se hora for maior que 23, será 0
        // Se minuto ou segundo for maior ou igual que 60, será 0

        if(segundo < 60)
            this.segundo = (byte) Math.abs(segundo);
        else this.segundo = 0; 
        
        if(minuto < 60)    
            this.minuto = (byte) Math.abs(minuto);
        else this.minuto = 0;
        
        if(hora < 24)
            this.hora = (byte) Math.abs(hora);
        else this.hora = 0;

    }

    public String getHora(){

        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);

    }

    public String getHoraFormatoV2(){

        //String horario = this.hora < 10 ? "0" + this.hora : ((this.hora - 12) < 10 ? "0" + Math.abs(this.hora - 12) : this.hora + "");
        // Apliquei operador ternário dentro de outro operador ternário
        //String horario = this.hora < 10 ? "0" + this.hora : (this.hora > 12 ? Math.abs(this.hora - 12) + "": "0" + this.hora);

        String horario = "";
        if(this.hora <= 12){

            if(this.hora < 10)
                horario += "0" + (this.hora) + "am ";
            else if(this.hora == 12 && this.minuto == 0 && this.segundo == 0)
                horario += this.hora + "am ";
            else horario += this.hora + "pm ";

        } else {

            if(this.hora - 12 < 10)
                horario += "0" + (this.hora - 12) + "pm ";
            else horario += (this.hora - 12) + "pm ";

        }

        // As duas seguintes linhas abaixo analisam, respectivamente, minuto
        // e segundo para concatenação do 0.
        horario += this.minuto < 10 ? "0" + this.minuto + "m " : this.minuto + "m ";
        horario += this.segundo < 10 ? "0" + this.segundo + "s " : this.segundo + "s ";

        return horario;

    }

    public void avancaHora(){

        this.hora++;

        if(hora == 24)
            this.hora = 0;

    }

    public void avancaMinuto(){

        this.minuto++;

        if(minuto == 60){
            this.minuto = 0;
            avancaHora();
        }

    }


    public void avancaSegundo(){

        this.segundo++;

        if(this.segundo == 60){
            this.segundo = 0;
            avancaMinuto();
        }

    }
}