package ifsc.poo;

public class Relogio {

    byte hora, minuto, segundo;

    void ajustaHora(byte hora, byte minuto, byte segundo){

        // Se hora for maior que 23, será 0
        // Se minuto ou segundo for maior que 60, será 0

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

    String getHora(){

        // Aqui eu faço uma verificação se todos os parametros são maiores que 9
        // pois não precisa concatenar com "0"
        if(this.hora > 9 && this.minuto > 9 && this.segundo > 9)
            return this.hora + ":" + this.minuto + ":" + this.segundo;

        // Se hora, minuto ou segundo for menor que 9, eu concateno "0" na string
        String horario = this.hora < 10 ? "0" + this.hora + ":": this.hora + ":";

        horario += this.minuto < 10 ? "0" + this.minuto + ":" : this.minuto + ":" ;

        horario += this.segundo < 10 ? "0" + this.segundo : this.segundo + "";

        return horario;
    }

    String getHoraFormatoV2(){

        // Se hora, minuto ou segundo for menor que 9, eu concateno "0" na string

        String horario = this.hora < 10 ? "0" + this.hora + "am " : this.hora + "pm ";

        horario += this.minuto < 10 ? "0" + this.minuto + "m ": this.minuto + "m ";

        horario += this.segundo < 10 ? "0" + this.segundo + "s ": this.segundo + "s ";

        return horario;
    }

    void avancaHora(){

        this.hora++;

        if(hora == 24)
            hora = 0;

    }

    void avancaMinuto(){

        this.minuto++;

        if(minuto == 60){
            minuto = 0;
            avancaHora();
        }

    }


    void avancaSegundo(){

        this.segundo++;

        if(this.segundo == 60){
            this.segundo = 0;
            avancaMinuto();
        }

    }
}