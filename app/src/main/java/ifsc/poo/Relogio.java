package ifsc.poo;

/*
 * Os métodos de setar hora, minuto e segundo
 * podem receber qualquer valor float, pois será
 * atribuído o módulo do valor.
*/

public class Relogio {

    private byte hora, minuto, segundo;

    public void ajustaHora(byte hora, byte minuto, byte segundo){

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

    public String getHora(){

        return String.format("%2d:%2d:%2d", this.hora, this.minuto, this.segundo);

    }

    public String getHoraFormatoV2(){

        // Se hora, minuto ou segundo for menor que 9, eu concateno "0" na string

        String horario = this.hora < 10 ? "0" + this.hora + "am " : this.hora + "pm ";

        horario += this.minuto < 10 ? "0" + this.minuto + "m ": this.minuto + "m ";

        horario += this.segundo < 10 ? "0" + this.segundo + "s ": this.segundo + "s ";

        return horario;
    }

    public void avancaHora(){

        this.hora++;

        if(hora == 24)
            hora = 0;

    }

    public void avancaMinuto(){

        this.minuto++;

        if(minuto == 60){
            minuto = 0;
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