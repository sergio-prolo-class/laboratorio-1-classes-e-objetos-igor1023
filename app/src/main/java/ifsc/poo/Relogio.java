package ifsc.poo;

public class Relogio {

    byte hora, minuto, segundo;

    void ajustaHora(byte hora, byte minuto, byte segundo){

        this.segundo = (byte) Math.abs(segundo);
        this.minuto = (byte) Math.abs(minuto);
        this.hora = (byte) Math.abs(hora);

    }

    String getHora(){

        return this.hora + ":" + this.minuto + ":" + this.segundo;

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